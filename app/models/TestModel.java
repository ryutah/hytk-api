package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ryuta on 14/12/29.
 */

@Entity
public class TestModel extends Model{
    @Id
    public Long id;

    @Constraints.Required
    public String name;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName="id")
    @JsonBackReference("TestParent")
    public TestParent parentId;

    public static Finder<Long, TestModel> find = new Finder<Long, TestModel>(Long.class, TestModel.class);

    public static List<TestModel> getList(String name) {
        String value = "%" + name + "%";
        List<TestModel> models = TestModel.find.where().like("name", value).findList();

        return models;
    }

    public static List<TestModel> getIds() {
        return find.select("id").findList();
    }
}

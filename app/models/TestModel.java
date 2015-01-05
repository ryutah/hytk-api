package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by ryuta on 14/12/29.
 */

@Entity
public class TestModel extends Model{
    @Id
    private Long id;

    @Constraints.Required
    private String name;


    @ManyToOne
    @JoinColumn(name = "parentId")
    private TestParent parentId;

    public static Finder<Long, TestModel> find = new Finder<Long, TestModel>(Long.class, TestModel.class);

    public static List<TestModel> getList(String name) {
        String value = "%" + name + "%";
        List<TestModel> models = TestModel.find.where().like("name", value).findList();

        return models;
    }

    public static List<TestModel> getIds() {
        return find.select("id").findList();
    }

    @JsonIgnore
    public TestParent getParentId() {
        return parentId;
    }

    public void setParentId(TestParent parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

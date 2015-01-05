package models;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ryuta on 14/12/30.
 */
@Entity
public class TestParent extends Model {
    @Id
    public Long id;

    @NotNull
    public String parentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
    public List<TestModel> models;

    public static Long create(String name) {
        TestParent parent = new TestParent();
        parent.parentName = name;
        parent.save();

        return parent.id;
    }

    public TestParent addChild(TestModel model) {
        models.add(model);
        save();

        return this;
    }

    public static TestParent addChild(Long id, TestModel model) {
        TestParent parent = Ebean.find(TestParent.class, id);
        return parent.addChild(model);
    }
}

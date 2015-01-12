package services;

import com.avaje.ebean.Ebean;
import models.TagData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class TagDataService {

    public Long saveTag(String tag) {
        TagData tagData = new TagData();

        tagData.tag = tag;
        tagData.save();

        return tagData.id;
    }

    public List<TagData> findTags(String tag) {
        List<TagData> tagDatas =
                Ebean.find(TagData.class)
                        .where()
                        .like("tag", tag + "%")
                        .findList();

        return tagDatas;
    }

    public TagData findTag(Long id) {
        TagData tagData = TagData.find.byId(id);

        return tagData;
    }

    public boolean updateTag(Long id, String tag) {
        TagData tagData = TagData.find.byId(id);

        if(tagData == null) {
            return false;
        } else {
            tagData.tag = tag;
            tagData.save();
            return true;
        }
    }

    public boolean delTag(Long id) {
        TagData tagData = TagData.find.byId(id);

        if(tagData == null) {
            return false;
        } else {
            tagData.delete();
            return true;
        }
    }
}

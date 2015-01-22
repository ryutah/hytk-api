package services.impl;

import com.avaje.ebean.Ebean;
import models.TagData;
import org.springframework.stereotype.Service;
import services.TagDataService;

import java.util.List;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class TagDataServiceImpl implements TagDataService{

    @Override
    public Long saveTag(String tag) {
        TagData tagData = new TagData();

        tagData.tag = tag;
        tagData.save();

        return tagData.id;
    }

    @Override
    public List<TagData> getTagList(String tag) {
        List<TagData> tagDatas =
                Ebean.find(TagData.class)
                        .where()
                        .like("tag", tag + "%")
                        .findList();

        return tagDatas;
    }

    @Override
    public TagData getTag(Long id) {
        TagData tagData = TagData.find.byId(id);

        return tagData;
    }

    @Override
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

    @Override
    public boolean deleteTag(Long id) {
        TagData tagData = TagData.find.byId(id);

        if(tagData == null) {
            return false;
        } else {
            tagData.delete();
            return true;
        }
    }
}

package services;

import com.avaje.ebean.Ebean;
import models.CategoryData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class CategoryDataService {

    public List<CategoryData> getCategorys(String category) {
        List<CategoryData> categoryDatas =
                Ebean.find(CategoryData.class)
                        .where()
                        .like("category", category + "%")
                        .findList();

        return categoryDatas;
    }

    public CategoryData getCategory(Long id) {
        CategoryData categoryData = CategoryData.find.byId(id);

        return categoryData;
    }

    public Long savaCategory(String catrgory){
        CategoryData categoryData = new CategoryData();
        categoryData.category = catrgory;
        categoryData.save();

        return categoryData.id;
    }

    public boolean updateCategory(Long id, String category) {
        CategoryData categoryData = CategoryData.find.byId(id);
        if(categoryData == null) {
            return false;
        } else {
            categoryData.category = category;
            categoryData.save();
            return true;
        }
    }
}

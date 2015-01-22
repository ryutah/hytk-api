package services.impl;

import com.avaje.ebean.Ebean;
import models.CategoryData;
import org.springframework.stereotype.Service;
import services.CategoryDataService;

import java.util.List;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class CategoryDataServiceImpl implements CategoryDataService{

    @Override
    public List<CategoryData> getCategoryList(String category) {
        List<CategoryData> categoryDatas =
                Ebean.find(CategoryData.class)
                        .where()
                        .like("category", category + "%")
                        .findList();

        return categoryDatas;
    }

    @Override
    public CategoryData getCategory(Long id) {
        CategoryData categoryData = CategoryData.find.byId(id);

        return categoryData;
    }

    @Override
    public Long savaCategory(String catrgory){
        CategoryData categoryData = new CategoryData();
        categoryData.category = catrgory;
        categoryData.save();

        return categoryData.id;
    }

    @Override
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

    @Override
    public boolean deleteCategory(Long id) {
        return false;
    }
}

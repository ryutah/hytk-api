package services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import models.BlogData;
import org.springframework.stereotype.Service;
import services.BlogDataService;

import java.util.List;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class BlogDataServiceImpl implements BlogDataService {

    @Override
    public List<BlogData> getBlogList() {

        return null;
    }

    @Override
    public BlogData getBlog(Long id) {
        return null;
    }

    @Override
    public Long saveBlog(JsonNode jsonNode) {
        return null;
    }

    @Override
    public boolean updateBlog(Long id, JsonNode jsonNode) {
        return false;
    }

    @Override
    public boolean deleteBlog(Long id) {
        return false;
    }
}

package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.BlogData;

import java.util.List;

/**
 * Created by ryuta on 15/01/22.
 */
public interface BlogDataService {

    public List<BlogData> getBlogList();

    public BlogData getBlog(Long id);

    public Long saveBlog(JsonNode jsonNode);

    public boolean updateBlog(Long id, JsonNode jsonNode);

    public boolean deleteBlog(Long id);
}

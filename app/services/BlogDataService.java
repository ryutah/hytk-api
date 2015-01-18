package services;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import models.BlogData;
import org.springframework.stereotype.Service;
import play.libs.Json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class BlogDataService {

    public void findBlogs(String json) {
        JsonNode node = Json.parse(json);

        String title = node.get("title").asText();
        String state = node.get("status").asText();
        String publishFrom = node.get("publishFrom").asText();
        String publishTo = node.get("publishTo").asText();
        List<String> tags = new ArrayList<>();
        for(JsonNode n : node.get("tag")) {
            tags.add(n.asText());
        }
        
    }
}

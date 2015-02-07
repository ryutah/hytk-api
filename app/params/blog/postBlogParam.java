package params.blog;

import play.data.validation.Constraints;

/**
 * Created by ryuta on 2015/02/02.
 */
public class PostBlogParam {

    @Constraints.MaxLength(80)
    public String title;

    public String content;
}
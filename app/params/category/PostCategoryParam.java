package params.category;

import play.data.validation.Constraints;

/**
 * Created by ryuta on 15/01/24.
 */
public class PostCategoryParam {


    @Constraints.Required
    @Constraints.MaxLength(25)
    public String category;
}

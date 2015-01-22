package params.category;

import org.springframework.format.annotation.NumberFormat;
import play.data.validation.Constraints;

/**
 * Created by ryuta on 15/01/22.
 */
public class GetCategoryParam {

    @Constraints.Required(message = "必須項目です")
    @Constraints.Pattern(value = "\\d", message = "数字のみです")
    public String id;


}

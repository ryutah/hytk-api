package params.category;

import play.data.validation.Constraints;

/**
 * GetServiceListのパラメータの検証をする
 *
 * Created by ryuta on 15/01/22.
 */
public class GetCategoryListParam {

    @Constraints.MaxLength(value = 25, message = "最大文字数は25文字です")
    public String category;

}

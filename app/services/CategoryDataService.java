package services;

import models.CategoryData;

import java.util.List;

/**
 * カテゴリデータを扱う
 *
 * Created by ryuta on 15/01/22.
 */
public interface CategoryDataService {

    /**
     * カテゴリデータを取得する
     *
     * @param category カテゴリ名
     * @return 検索結果のリスト
     */
    public List<CategoryData> getCategoryList(String category);

    /**
     * カテゴリデータを取得する(1件)
     *
     * @param id カテゴリID
     * @return 検索結果
     */
    public CategoryData getCategory(Long id);

    /**
     * カテゴリデータを新規作成する
     *
     * @param catrgory カテゴリ名
     * @return 作成に成功したk
     */
    public Long savaCategory(String catrgory);

    /**
     * カテゴリデータを更新する
     *
     * @param id カテゴリID
     * @param category 新しいカテゴリ名
     * @return 更新に成功したか
     */
    public boolean updateCategory(Long id, String category);

    /**
     * カテゴリデータを削除する
     *
     * @param id カテゴリID
     * @return 削除に成功したか
     */
    public boolean deleteCategory(Long id);
}

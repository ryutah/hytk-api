package services;

import models.TagData;

import java.util.List;

/**
 * Created by ryuta on 15/01/22.
 */
public interface TagDataService {

    /**
     * タグデータを新規作成する
     *
     * @param tag タグ名
     * @return 作成に成功したか
     */
    public Long saveTag(String tag);

    /**
     * タグを検索する
     *
     * @param tag タグ名
     * @return タグリスト
     */
    public List<TagData> getTagList(String tag);

    /**
     * タグを検索する
     *
     * @param id タグID
     * @return タグ
     */
    public TagData getTag(Long id);

    /**
     * タグを更新する
     *
     * @param id タグID
     * @param tag 新タグ名
     * @return 更新に成功したか
     */
    public boolean updateTag(Long id, String tag);

    /**
     * タグデータを削除する
     *
     * @param id タグID
     * @return 削除に成功したか
     */
    public boolean deleteTag(Long id);
}

package services;

import java.io.File;

/**
 * ブログで使用する画像を扱う
 *
 * Created by ryuta on 15/01/22.
 */
public interface ImageDataService {

    /**
     * 画像を保存する
     *
     * @param blogId 関連するブログのID
     * @param file 保存するファイル
     * @return 保存に成功したか
     */
    public boolean saveImage(String blogId, File file);

    /**
     * 画像を取得する
     *
     * @param blogId 関連するブログのID
     * @param fileName 画像のファイル名
     * @return 画像ファイル
     */
    public File getImage(String blogId, String fileName);

    /**
     * 画像を削除する(1ファイル)
     * @param blogId 関連するブログのID
     * @param fileName 画像のファイル名
     * @return 削除に成功したか
     */
    public boolean deleteImage(String blogId, String fileName);

    /**
     * 画像を削除する(全件)
     * @param blogId 削除対象となるブログのID
     * @return 削除に成功したか
     */
    public boolean deleteAllImage(String blogId);
}

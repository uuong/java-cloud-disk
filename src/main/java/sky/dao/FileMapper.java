package sky.dao;

import sky.pojo.File;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:08
 * To change this template use File | Settings | File Templates.
 */
public interface FileMapper {
    List<File> queryAll(File file);

    List<File> queryByType(File file);

    int insert(File file);
}

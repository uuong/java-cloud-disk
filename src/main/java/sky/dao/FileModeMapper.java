package sky.dao;

import org.apache.ibatis.annotations.Param;
import sky.pojo.FileMode;
import sky.pojo.PageUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:08
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public interface FileModeMapper {
    List<FileMode> queryAll(FileMode fileMode);

    List<FileMode> queryByType(FileMode fileMode);

    int insert(FileMode fileMode);

    List<FileMode> queryByPid(String username, Integer pid);

    /**
     * @param fileName 为空==查询所有
     * @return
     */
    List<FileMode> queryPublicByFileName(@Param("fileName") String fileName);

    /**
     * 分页查询
     *
     * @param pageUtil
     * @return
     */
    List<FileMode> queryPage(PageUtil pageUtil);

    FileMode queryById(Integer id);
}

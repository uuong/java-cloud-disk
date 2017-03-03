package sky.service.inter;

import org.springframework.web.multipart.MultipartFile;
import sky.pojo.FileMode;
import sky.pojo.PagedResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:35
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public interface FileService {
    List<FileMode> queryAll(FileMode fileMode);

    List<FileMode> queryByType(FileMode fileMode);

    /**
     * 选择插入
     *
     * @param fileMode
     * @param multipartFile
     * @return 自增主键
     */
    int insert(FileMode fileMode, MultipartFile multipartFile);

    List<FileMode> queryByPid(String username, Integer pid);

    List<FileMode> queryByPublic(String fileName);

    PagedResult<FileMode> queryByPage(String fileName, Integer pageNumber, Integer pageSize);

    /**
     * @param id       文件唯一id
     * @param name     文件名
     * @param response
     * @return 下载链接
     */
    String download(Integer id, String name, HttpServletResponse response);
}

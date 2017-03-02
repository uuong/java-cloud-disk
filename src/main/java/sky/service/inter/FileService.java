package sky.service.inter;

import org.springframework.web.multipart.MultipartFile;
import sky.pojo.FileMode;

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

    int insert(FileMode fileMode, MultipartFile multipartFile);

    List<FileMode> queryByPid(String username, Integer pid);

    List<FileMode> queryByPublic(String fileName);

    List<FileMode> PagedResult(String fileName, Integer pageNumber, Integer pageSize);

    String download(Integer integer, String id, HttpServletResponse response);
}

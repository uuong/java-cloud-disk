package sky.service.inter;

import org.springframework.web.multipart.MultipartFile;
import sky.pojo.FileMode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:35
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public interface UploadAndDown {
    List<FileMode> queryAll(FileMode fileMode);

    List<FileMode> queryByType(FileMode fileMode);

    int insert(FileMode fileMode, MultipartFile multipartFile);
}

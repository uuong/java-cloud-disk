package sky.service.inter;

import org.springframework.web.multipart.MultipartFile;
import sky.pojo.File;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public interface FileUpAndDown {
    List<File> queryAll(File file);

    List<File> queryByType(File file);

    int insert(File file, MultipartFile multipartFile);
}

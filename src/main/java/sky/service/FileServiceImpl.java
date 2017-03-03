package sky.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sky.dao.FileModeMapper;
import sky.pojo.FileMode;
import sky.pojo.PagedResult;
import sky.service.inter.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:42
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Service
public class FileServiceImpl implements FileService {
    private String basePath = "e:/ddd/";
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private FileModeMapper fileModeMapper;

    public List<FileMode> queryAll(FileMode fileMode) {
        return fileModeMapper.queryAll(fileMode);
    }

    public List<FileMode> queryByType(FileMode fileMode) {
        if ("our".equals(fileMode.getFileType())) {
            return fileModeMapper.queryAll(fileMode);
        }
        return fileModeMapper.queryByType(fileMode);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(FileMode fileMode, MultipartFile multipartFile) {
        int i = fileModeMapper.insert(fileMode);
        try {
            File fi = new File(basePath + "/" + fileMode.getId());
            multipartFile.transferTo(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public List<FileMode> queryByPid(String username, Integer pid) {
        return fileModeMapper.queryByPid(username, pid);
    }

    public List<FileMode> queryByPublic(String fileName) {
        //fileName = fileName.equals("") ? null : fileName;
        return fileModeMapper.queryPublicByFileName(fileName);
    }

    public PagedResult<FileMode> queryByPage(String fileName, Integer pageNumber, Integer pageSize) {
        pageNumber = pageNumber == null ? 1 : pageNumber;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNumber, pageSize);
        List<FileMode> files = fileModeMapper.queryPublicByFileName(fileName);
        return new PagedResult<FileMode>(files);
    }

    public String download(Integer id, String name, HttpServletResponse response) {
        // TODO: 2017/3/4 0004 is public
        try {
            OutputStream out = response.getOutputStream();
            response.setContentType("text/html;charset=UTF-8");
            File file = new File(basePath + "/" + id);
            InputStream in = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(name, "UTF-8"));
            byte b[] = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

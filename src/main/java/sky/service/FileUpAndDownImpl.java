package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sky.dao.FileMapper;
import sky.pojo.File;
import sky.service.inter.FileUpAndDown;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FileUpAndDownImpl implements FileUpAndDown {
    @Autowired
    private FileMapper fileMapper;

    public List<File> queryAll(File file) {
        return fileMapper.queryAll(file);
    }

    public List<File> queryByType(File file) {

        return fileMapper.queryByType(file);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int insert(File file, MultipartFile multipartFile) {
        //        目录测试
        java.io.File f = new java.io.File(file.getFilePath());
        if (!f.exists()) {
            f.mkdirs();
        }
        try {
            java.io.File fi = new java.io.File(file.getFilePath() + "/" + file.getFileName());
            multipartFile.transferTo(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileMapper.insert(file);
    }
}

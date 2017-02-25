package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sky.dao.FileModeMapper;
import sky.pojo.FileMode;
import sky.service.inter.UploadAndDown;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:42
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Service
public class UploadAndDownImpl implements UploadAndDown {

    @Autowired
    private FileModeMapper fileModeMapper;

    public List<FileMode> queryAll(FileMode fileMode) {
        return fileModeMapper.queryAll(fileMode);
    }

    public List<FileMode> queryByType(FileMode fileMode) {

        return fileModeMapper.queryByType(fileMode);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int insert(FileMode fileMode, MultipartFile multipartFile) {
        //        目录测试
        java.io.File f = new java.io.File(fileMode.getFilePath());
        if (!f.exists()) {
            f.mkdirs();
        }
        try {
            File fi = new File(fileMode.getFilePath() + "/" + fileMode.getFileName());
            multipartFile.transferTo(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileModeMapper.insert(fileMode);
    }
}

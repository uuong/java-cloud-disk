package sky.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sky._const.UserConst;
import sky.pojo.FileMode;
import sky.pojo.User;
import sky.service.inter.FileService;
import sky.util.TypeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/3/2 0002
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("disk")
public class FileCtrl {
    @Autowired
    private FileService fileService;

    @RequestMapping()
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView mav = new ModelAndView("disk1");
        User user = (User) session.getAttribute(UserConst.USER_SESSION);
        List<FileMode> files = fileService.queryByPid(user.getUsername(), 0);
        mav.addObject("files", files);
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<FileMode> list(Integer pageNumber, Integer pageSize, String fileName) {
        System.out.println(fileName + "-----------------------------------");
        List<FileMode> files = fileService.queryByPublic(fileName);
        System.out.println(files);
        return files;

    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile, Integer pid) {

        User user = (User) request.getSession().getAttribute(UserConst.USER_SESSION);

        //
        String filename = multipartFile.getOriginalFilename();
        String fileType = TypeUtils.typ(multipartFile.getContentType());
        int fileSize = (int) (multipartFile.getSize() / 1024);
        //封装file
        //FileMode fileMode = new FileMode();
        //fileMode.setUsername(user.getUsername());
        //fileMode.setFileName(filename);
        //fileMode.setFileSize((int) (multipartFile.getSize() / 1024));
        //fileMode.setFileType(fileType);
        //fileMode.setPid(pid);
        FileMode fileMode = new FileMode(null, user.getUsername(), pid
                , filename, fileType, fileSize, null, 0, 0);
        fileService.insert(fileMode, multipartFile);
        return "redirect:/disk";
    }
}

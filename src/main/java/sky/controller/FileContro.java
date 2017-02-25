package sky.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sky._const.UserConst;
import sky.pojo.FileMode;
import sky.service.inter.UploadAndDown;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传下载.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:46
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Controller
@RequestMapping("/disk")
public class FileContro {
    @Autowired
    private UploadAndDown fud;

    /**
     * 首屏直接显示全部文件
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String show(HttpServletRequest request, Model model) {
        FileMode fileMode = new FileMode();
        String userName = (String) request.getSession().getAttribute(UserConst.USER_SESS);
        fileMode.setUserName(userName);
        model.addAttribute("fileModes", fud.queryAll(fileMode));
        return "disk";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView queryByType(HttpServletRequest request, Model model, @RequestParam("type") String type) throws IOException {
        FileMode fileMode = new FileMode();
        String userName = (String) request.getSession().getAttribute(UserConst.USER_SESS);
        fileMode.setUserName(userName);
        fileMode.setFileType(type);

        List<FileMode> fileModes;
        if ("all".equals(type)) {
            fileModes = fud.queryAll(fileMode);
        } else {
            fileModes = fud.queryByType(fileMode);
        }
        model.addAttribute("fileModes", fileModes);
        return new ModelAndView("layout/disk-table");
    }

    @RequestMapping(value = "up", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) {
        String userName = (String) request.getSession().getAttribute(UserConst.USER_SESS);
        //封装file
        FileMode fileMode = new FileMode();
        String fileName = multipartFile.getOriginalFilename();
        fileMode.setUserName(userName);
        fileMode.setFileName(fileName);
        fileMode.setFileSize((multipartFile.getSize() / 1024) + "");
        fileMode.setFileType(multipartFile.getContentType());
        String path = "e:/ddd/" + userName;
        fileMode.setFilePath(path);
        int k = fud.insert(fileMode, multipartFile);
        System.out.println(k);
        return "redirect:/disk";
    }


}

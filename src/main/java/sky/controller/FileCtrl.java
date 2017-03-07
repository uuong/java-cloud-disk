package sky.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sky._const.UserConst;
import sky.pojo.FileMode;
import sky.pojo.PageUtil;
import sky.pojo.PagedResult;
import sky.pojo.User;
import sky.service.inter.FileService;
import sky.util.TypeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String getIndex(HttpServletRequest request) {
        request.setAttribute("url", "disk");
        return "disk";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<FileMode> list(HttpSession session, @RequestBody PageUtil pageUtil) {
        User user = (User) session.getAttribute(UserConst.USER_SESSION);
        pageUtil.setUsername(user.getUsername());
        return fileService.queryByPage(pageUtil);
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile, Integer pid) {

        User user = (User) request.getSession().getAttribute(UserConst.USER_SESSION);
        String filename = multipartFile.getOriginalFilename();
        String fileType = TypeUtils.typ(multipartFile.getContentType());
        int fileSize = (int) (multipartFile.getSize() / 1024);
        pid = pid != null ? pid : 0;
        FileMode fileMode = new FileMode(null, user.getUsername(), pid
                , filename, fileType, fileSize, null, 0, 0);
        fileService.insert(fileMode, multipartFile);
        return "redirect:/disk";
    }
}

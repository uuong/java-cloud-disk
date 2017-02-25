package sky.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sky._const.UserConst;
import sky.pojo.File;
import sky.service.inter.FileUpAndDown;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/disk")
public class FileContro {
    @Autowired
    private FileUpAndDown fud;

    @RequestMapping(method = RequestMethod.GET)
    public String show(HttpServletRequest request, Model model) {
        File file = new File();
        String userName = (String) request.getSession().getAttribute(UserConst.USER_SESS);
        file.setUserName(userName);
        model.addAttribute("files", fud.queryAll(file));
        return "disk";
    }

    @RequestMapping(value = "up", method = RequestMethod.POST)
    public String up(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) {
        String userName = (String) request.getSession().getAttribute(UserConst.USER_SESS);
        File file = new File();
        String fileName = multipartFile.getOriginalFilename();
        file.setUserName(userName);
        file.setFileName(fileName);
        file.setFileSize((multipartFile.getSize() / 1024) + "");
        file.setFileType(multipartFile.getContentType());
        String path = "e:/ddd/" + userName;
        file.setFilePath(path);
        int k = fud.insert(file, multipartFile);
        System.out.println(k);
        return "redirect:/disk";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView queryByType(HttpServletRequest request, Model model, @RequestParam("type") String type) throws IOException {
        File file = new File();
        String userName = (String) request.getSession().getAttribute(UserConst.USER_SESS);
        file.setUserName(userName);
        file.setFileType(type);

        List<File> files;
        if ("all".equals(type)) {
            files = fud.queryAll(file);
        } else {
            files = fud.queryByType(file);
        }
        model.addAttribute("files", files);
//        Map<String, List<File>> modelMap = new HashMap<String, List<File>>();
//        modelMap.put("files",files);
//        return modelMap;
        return new ModelAndView("showDisk");
    }
}

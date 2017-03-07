package sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sky.pojo.FileMode;
import sky.pojo.PageUtil;
import sky.pojo.PagedResult;
import sky.service.inter.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/3/2 0002
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("open")
public class OpenCtrl {

    @Autowired
    private FileService fileService;

    @RequestMapping()
    public String getIndex(HttpServletRequest request) {
        request.setAttribute("url", "open");
        return "disk";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<FileMode> list(@RequestBody PageUtil pageUtil) {
        System.out.println(pageUtil);
        return fileService.queryByPage(pageUtil);
    }

    @RequestMapping("/down/{id}")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        fileService.download(id, response);
    }
}

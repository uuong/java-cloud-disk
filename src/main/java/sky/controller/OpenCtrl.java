package sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sky.pojo.FileMode;
import sky.pojo.PageUtil;
import sky.pojo.PagedResult;
import sky.service.inter.FileService;

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
    public String getIndex() {
        return "disk";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<FileMode> list(@RequestBody PageUtil pageUtil) {
        System.out.println(pageUtil);
        PagedResult<FileMode> files = fileService.queryByPage(pageUtil);

        return files;
    }

    @RequestMapping("/down{id}&{name}")
    public String download(@PathVariable Integer id, @PathVariable String name, HttpServletResponse response) throws IOException {
        System.out.println(id + name);
        return fileService.download(id, name, response);
    }
}

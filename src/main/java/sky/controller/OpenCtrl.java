package sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sky.pojo.FileMode;
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
        return "disk1";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<FileMode> list(Integer pageNumber, Integer pageSize, String fileName) {
        PagedResult<FileMode> files = fileService.queryByPage(fileName, pageNumber, pageSize);
        System.out.println(files);
        return files;
    }

    @RequestMapping("/down{id}&{name}")
    public String download(@PathVariable Integer id, @PathVariable String name, HttpServletResponse response) throws IOException {
        System.out.println(id + name);
        return fileService.download(id, name, response);
    }
}

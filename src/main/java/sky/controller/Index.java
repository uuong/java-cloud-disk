package sky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22.js 0022
 * Time: 20:55
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Controller
public class Index {
    @RequestMapping("/")
    public String Index() {
        return "index";
    }


    //@Autowired
    //private FileService fud;
    //
    //
    //@RequestMapping("/json")
    //public ModelAndView show(Model model, @RequestParam("id") String pid, HttpServletResponse response) throws IOException {
    //    //Map<String, String> map = null;
    //    //map = new HashMap<String, String>();
    //    //List<FileMode> fileModes;
    //    //fileModes = fud.queryByPid("Hello",pid);
    //    //for (FileMode fileMode : fileModes) {
    //    //    map.put("username",fileMode.getFilename());
    //    //    map.put("username",fileMode.getFiletype());
    //    //    map.put("username",fileMode.getId());
    //    //    map.put("username",fileMode.getPid());
    //    //    map.put("username",fileMode.getFilesize());
    //    //
    //    //}
    //    List<FileMode> fileModes = fud.queryByPid("Hello",0);
    //    model.addAttribute("fileModes", fileModes);
    //    return new ModelAndView("layout/disk-table");
    //}
}

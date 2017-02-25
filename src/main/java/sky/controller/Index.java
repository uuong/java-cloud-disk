package sky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22 0022
 * Time: 20:55
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Controller
public class Index {
    @RequestMapping("/")
    public String Index() {
        return "index";
    }
}

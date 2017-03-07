package sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sky._const.UserConst;
import sky.pojo.User;
import sky.service.inter.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/27 0027
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("user")
public class UserControll {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String userIndex(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(UserConst.USER_SESSION);
        if ("admin".equals(user.getUsername())) {
            List<User> users = userService.query();
            model.addAttribute("users", users);
            return "user";
        }

        return "user";
    }

    @RequestMapping(value = "change-pass", method = RequestMethod.GET)
    public String changePasswordLine() {
        return "change";
    }

    @RequestMapping(value = "change-pass", method = RequestMethod.POST)
    public String changePassword(String oldpass, String newpass, String newpass2, HttpServletRequest request, Model model) {

        User user = (User) request.getSession().getAttribute(UserConst.USER_SESSION);
        user.setPassword(oldpass);
        if (newpass != null && newpass.equals(newpass2) && userService.change(user, newpass)) {
            model.addAttribute("message", "ok");
            return "change";
        }
        model.addAttribute("message", "error");
        return "change";
    }
}

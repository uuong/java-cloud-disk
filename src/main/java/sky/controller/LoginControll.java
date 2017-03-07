package sky.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sky._const.UserConst;
import sky.exception.UserNameExistException;
import sky.pojo.User;
import sky.service.inter.LoginAndRegist;
import sky.service.inter.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22.js 0022
 * Time: 23:23
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Controller
@RequestMapping("user/login")
public class LoginControll {

    @Autowired
    private LoginAndRegist loginAndRegist;
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String userLoginGet() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String userLogin(User user, HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(name = "remember", required = false) boolean remember) {
        HttpSession session = request.getSession();

        if (loginAndRegist.userLogin(user, remember, response)) {
            //保存session
            request.getSession().setAttribute(UserConst.USER_SESSION, user);
            //回调地址
            String callback = (String) session.getAttribute("callback");
            session.removeAttribute("callback");
            return "redirect:" + callback;
        }
        request.getSession().setAttribute("message", "error");
        return "login";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    @ResponseBody
    public void userLoginAjax(User user, HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(name = "remember", required = false) boolean remember)
            throws IOException {

        response.setContentType("text/plain;charset=UTF-8");
        if (loginAndRegist.userLogin(user, remember, response)) {
//            保存session
            request.getSession().setAttribute(UserConst.USER_SESSION, user);
            response.getWriter().write("success");
        } else {
            response.getWriter().write("帐号密码错误");
        }
    }

    @RequestMapping(value = "ajax/name", method = RequestMethod.POST)
    @ResponseBody
    public void userNmaeAjax(String username, HttpServletResponse response)
            throws IOException {
        if (userService.select(username) != null) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("no");
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, Model model) {
        try {
            loginAndRegist.addUser(user);
        } catch (UserNameExistException e) {
            model.addAttribute("login_error", "用户名重复");
            return "login";
        }
        return "index";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {

        User user = (User) session.getAttribute(UserConst.USER_SESSION);
        session.removeAttribute(UserConst.USER_SESSION);
        session.invalidate();
        User u = new User();
        u.setToken("no");
        u.setUsername(user.getUsername());
        loginAndRegist.logout(u);

        return "redirect:/in";
    }


}

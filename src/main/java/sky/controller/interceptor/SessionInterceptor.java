package sky.controller.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sky._const.UserConst;
import sky.dao.UserMapper;
import sky.pojo.User;
import sky.util.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/23 0023
 * Time: 0:06
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    /**
     * 过滤掉没有登录的
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        User sessionUser = (User) session.getAttribute(UserConst.USER_SESSION);
        if (sessionUser != null) {
            return true;
        }

        // TODO: 2017/2/27 0027 以后精简一下 
        String cookie = CookieUtils.getCookie(request, "remember");
        if (cookie == null) {
            session.setAttribute("callback", request.getRequestURL());
            response.sendRedirect("user/login");
            return false;
        }

        String[] cookies = cookie.split(":");
        if (cookies.length != 2) {
            session.setAttribute("callback", request.getRequestURL());
            response.sendRedirect("user/login");
            return false;
        }

        User dataUser = userMapper.selectByPrimaryKey(cookies[1]);
        if (dataUser == null || dataUser.getToken() == null) {
            session.setAttribute("callback", request.getRequestURL());
            response.sendRedirect("user/login");
            return false;
        }

        String[] uValues = dataUser.getToken().split(":");

        Long dataTime = Long.parseLong(uValues[1]);
        String dataUUID = uValues[0];
        String dataPass = uValues[2];

        Long currentTime = new Date().getTime();
        String cookieUUID = cookies[0];
        String currentPass = dataUser.getPassword();
        if (dataTime > currentTime && dataUUID.equals(cookieUUID) && dataPass.equals(currentPass)) {
            //todo 换个token
            session.setAttribute(UserConst.USER_SESSION, dataUser);
            return true;
        }
        session.setAttribute("callback", request.getRequestURL().toString());
        response.sendRedirect("user/login");
        return false;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

package sky.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 废弃
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 12:46
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Controller
@RequestMapping("disk")
public class FileControll {
//    @Autowired
//    private FileService fud;
//
//
//    @RequestMapping("json")
//    public void show(HttpServletRequest request, @RequestParam("pid") String pid, HttpServletResponse response) throws IOException {
//        List<FileMode> fileModes;
//        FileMode fileMode = new FileMode();
//        User user = (User) request.getSession().getAttribute(UserConst.USER_SESSION);
//        fileModes = fud.queryByPid(user.getUsername(), pid);
//        response.getWriter().write(JSONUtils.toJSONString(fileModes));
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView index(HttpSession session, Model model) throws IOException {
//
//        List<FileMode> fileModes;
//        FileMode fileMode = new FileMode();
//        User user = (User) session.getAttribute(UserConst.USER_SESSION);
//
//        fileMode.setUsername(user.getUsername());
//
//        fileModes = fud.queryAll(fileMode);
//        model.addAttribute("fileModes", fileModes);
//        return new ModelAndView("disk");
//
//
//    }
//
//
//    @RequestMapping(value = "get", method = {RequestMethod.POST})
//    public ModelAndView queryByType(HttpSession session, Model model, String type) throws IOException {
//
//        List<FileMode> fileModes;
//        FileMode fileMode = new FileMode();
//        User user = (User) session.getAttribute(UserConst.USER_SESSION);
//
//        fileMode.setUsername(user.getUsername());
//        fileMode.setFiletype(type);
//        fileModes = fud.queryByType(fileMode);
//        model.addAttribute("fileModes", fileModes);
//        return new ModelAndView("/layout/disk-table");
//    }
//
//    @RequestMapping(value = "up", method = RequestMethod.POST)
//    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) {
//
//        User user = (User) request.getSession().getAttribute(UserConst.USER_SESSION);
//
//        //
//        String filename = multipartFile.getOriginalFilename();
//        String fileType = TypeUtils.typ(multipartFile.getContentType());
//        String path = "e:/ddd/" + user.getUsername();
//        //封装file
//        FileMode fileMode = new FileMode();
//        fileMode.setUsername(user.getUsername());
//        fileMode.setFilename(filename);
//        fileMode.setFilesize((int) (multipartFile.getSize() / 1024));
//        fileMode.setFiletype(fileType);
//        fileMode.setFilepath(path);
//
//        fud.insert(fileMode, multipartFile);
//        return "redirect:disk";
//    }
//
//    /**
//     * 用session中的User验证是否有文件
//     */
//    @RequestMapping(value = "down")
//    public void download(HttpSession session, HttpServletResponse response, @RequestParam("name") String name) throws IOException {
//        User user = (User) session.getAttribute(UserConst.USER_SESSION);
//        OutputStream out = response.getOutputStream();
//        response.setContentType("text/html;charset=UTF-8");
//        File file = new File("e:/ddd/" + user.getUsername() + "/" + name);
//        if (!(file.exists())) {
//            //todo 返回错误消息
//            return;
//        }
//        InputStream in = new FileInputStream(file);
//        response.setHeader("Content-Disposition", "attachment;filename="
//                + URLEncoder.encode(name, "UTF-8"));
////        response.setHeader("Content-Disposition", "attachment;filename="
////                + URLEncoder.encode(fileMode.getFileName(),"UTF-8"));
//        byte b[] = new byte[1024];
//        int len;
//        while ((len = in.read(b)) != -1) {
//            out.write(b, 0, len);
//        }
//        in.close();
//    }

}

package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import service.UserService;
import service.impl.UserServiceImpl;
import vo.UserVo;

/**
 * http://localhost:8080/ums-action/user/showRegist
 *
 * @author zte
 *
 */
@Controller  // 表示此类是一个Controller/Handler/Action
@RequestMapping("/user") // http://localhost:8080/ums-action/user中的/user映射到UserAction类上
public class UserAction
{
    private UserService userService = new UserServiceImpl();

    // http://localhost:8080/ums-action/user/showRegist 跳转到 WEB-INF/view/regist.jsp
    // Handler中方法的返回值如果是String---> 视图名称
    @RequestMapping("/showRegist")
    public String showUpload()
    {
        return "regist"; // 返回具体的视图名称
    }

    // http://localhost:8080/ums-action/user/success
    @RequestMapping("/success")
    public String showSuccess()
    {
        return "success"; // 返回具体的视图名称
    }


    // request.getParameter("username");
    @RequestMapping("/upload")  // 一顶要和<input type="file" name="file" id="photoPic">中name属性值一致
    public String upload(String username, String password, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException
    {
        /*
        String oriFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        long size = file.getSize();

        // System.out.println("原始文件名:" + oriFilename);
        // System.out.println("原始类型:" + contentType);
        // System.out.println("原始大小:" + size);

        // 要上传到的服务器路径 ServletContext
        String realPath = request.getServletContext().getRealPath("/upload/");
        System.out.println(realPath);

        File f = new File(realPath);
        if (!f.exists())
        {
            f.mkdirs();
        }


        String serverFileName = FileNameUtil.renameFileName(oriFilename);

        file.transferTo(new File(realPath, serverFileName));

        // 上传成功之后 重定向(redirect)到regist.jsp(/user/showRegist)
        return "redirect:/user/showRegist";
        */

        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        userVo.setPassword(password);
        userVo.setPhotoPath("/upload/");

        // 将要上传的文件 ----> 输入流
        userVo.setInputStream(file.getInputStream());
        userVo.setPhotoName(file.getOriginalFilename());
        userVo.setSaveServerPath(request.getServletContext().getRealPath("/upload/"));

        userService.regist(userVo);


        request.getSession().setAttribute("uName", username);

        return "redirect:/user/success";


    }

}

package service.impl;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import dao.UserDao;
import entity.User;
import service.UserService;
import util.FileNameUtil;
import util.MyBatisUtil;
import vo.UserVo;

public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    public void regist(UserVo userVo)
    {
        try
        {
            // 重命名之后的文件名
            String fileName = FileNameUtil.renameFileName(userVo.getPhotoName());

            // 做文件上传操作 :org.apache.commons.io.FileUtils.copyInputStreamToFile(InputStream inputStream, File file)
            FileUtils.copyInputStreamToFile(userVo.getInputStream(), new File(userVo.getSaveServerPath() + fileName));

            SqlSession sqlSession = MyBatisUtil.getSession();

            userDao = sqlSession.getMapper(UserDao.class);


            User user = new User();
            user.setUsername(userVo.getUsername());
            user.setPassword(userVo.getPassoword());
            user.setPhotoPath(userVo.getPhotoPath() + fileName);

            userDao.insert(user);

            sqlSession.commit();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }finally
        {
            MyBatisUtil.closeSession();
        }


    }

}

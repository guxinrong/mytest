package util;

import java.util.UUID;

/**
 * 为后期文件上传服务
 *
 * @author zte
 *
 */
public class FileNameUtil extends Object
{
    public static String renameFileName(String fileName)
    {

        if (fileName == null || fileName.length() == 0)
        {
            return null;
        }

        /**
         *  "nice.jpg" ---> 原始文件名+UUID的字符串+原始后缀(niceUUID.jpg) ---> 为后期文件上传服务
         */
        // (1)
        String oriName = fileName.substring(0, fileName.lastIndexOf("."));


        // (2)
        String randomUUID = UUID.randomUUID().toString();

        // (3) 后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // upload 上传
        String uploadServerFileName = oriName + randomUUID + suffix;


        return uploadServerFileName;

    }
}

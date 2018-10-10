package vo;

import java.io.InputStream;
import java.io.Serializable;

public class UserVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    // 文件上传到  DB中的路径  /xxx(不包括文件名)
    private String photoPath;

    // 要上传的文件名
    private String photoName;

    // 文件上传到 web服务器(tomcat)中的路径
    private String saveServerPath;

    // 要上传文件的输入流对象
    private InputStream inputStream;

    public UserVo()
    {
        super();
    }

    public UserVo(String username, String password, String photoPath, String photoName, String saveServerPath,
                  InputStream inputStream)
    {
        super();
        this.username = username;
        this.password = password;
        this.photoPath = photoPath;
        this.photoName = photoName;
        this.saveServerPath = saveServerPath;
        this.inputStream = inputStream;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassoword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getSaveServerPath() {
        return saveServerPath;
    }

    public void setSaveServerPath(String saveServerPath) {
        this.saveServerPath = saveServerPath;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

}

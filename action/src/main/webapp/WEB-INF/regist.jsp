<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <!-- js静态资源 -->
    <!--
    <servlet-mapping>
            <servlet-name>default</servlet-name>
            <url-pattern>/js/*</url-pattern>
    </servlet-mapping>
    -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>


    <script type="text/javascript">

    </script>
</head>

<body>
<!--
    1.必须是表单提交, 提交方式必须是 method="post"
    2.enctype="multipart/form-data" 将要上传图片以二进制流的形式上传
    3.<input type="file" name="file">
 -->
<h1>单文件上传</h1>
<form id="formId" action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">

    用户名:<input type="text" name="username" id="username" />   <br/> <br/>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" id="password" /> <br/> <br/>

    <input type="file" name="file" id="photoPic"><br/><br/>
    <!--
                    注意:
        type="submit" 自动提交表单
        type="button" 我们要手动提交表单
    -->
    <input type="submit" value="上传" id="buttonId"/>

    <!-- (3) 上传图像预览  -->
    <%--  <img style="width:200px; height:200px;" id="img"  src="${pageContext.request.contextPath}/images/upload.png" /> --%>
</form>

</body>
</html>

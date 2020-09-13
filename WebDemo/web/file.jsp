<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2020/8/31
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小滴课堂文件上传样例</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/fileUpload" method="post" enctype="multipart/form-data">

    用户名:<input type="text" name="username"/>
    头像:<input type="file" name="img">
    <input type="submit" value="提交">

</form>

</body>
</html>

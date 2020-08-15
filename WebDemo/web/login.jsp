<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2020/8/13
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/loginServlet" method="post">
        名称：<input type="text" name="name" />

        <br/>

        密码：<input type="password" name="pwd" />

        <input type="submit" value="登录" />

        消息提示： ${msg}

    </form>

</body>
</html>

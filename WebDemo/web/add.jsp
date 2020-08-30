<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2020/8/30
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小滴课堂javaweb统计在线人数</title>
</head>
<body>

<hr>
近30分钟在线人数: ${applicationScope.onlineNum}

<hr>
应用服务器启动后总访问次数：${totalVisit}

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2020/8/8
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>小滴课堂</div>

  <div>
      <%
          out.println("getRequestURL is " + request.getRequestURL());
          out.println("小滴课堂 java学习");
      %>
  </div>

  <br/>

  <div>
      <%= request.getRequestURL() %>
  </div>

  </body>
</html>

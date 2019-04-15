<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/11
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>My JSP 'index.jsp' starting page</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
</head>

<body>
<CENTER>
  <table>
    <tr>
      <td>
        序号
      </td>
      <td>
        姓名
      </td>
      <td>
        性别
      </td>
      <td>
        操作
      </td>
      <td>
        <a href="add.jsp">添加</a>
      </td>
    </tr>

    <c:forEach var="i" items="${list}">
      <tr>
        <td>
            ${i.sid }
        </td>
        <td>
            ${i.sname }
        </td>
        <td>
            ${i.sex }
        </td>
        <td>
          <a href="FindByIdSerlvet?sid=${i.sid}">修改</a>
          &nbsp;&nbsp;
          <a href="DeleteSerlvet?sid=${i.sid}">删除</a>
        </td>
      </tr>
    </c:forEach>

  </table>
  <div>


    第${page.pageno}/${page.totalpage}页 &nbsp;&nbsp;
    <a href="FindAllServlet?pageNo=1">首页</a>
    <c:choose>
      <c:when test="${page.pageno gt 1}">
        <a href="FindAllServlet?pageNo=${page.pageno-1 }">上一页</a>
      </c:when>
      <c:otherwise>
        <a href="javascript:alert('已经是第一页了,没有上一页!');">上一页</a>
      </c:otherwise>
    </c:choose>
    <c:choose>
      <c:when test="${page.pageno lt page.totalpage}">
        <a href="FindAllServlet?pageNo=${page.pageno+1 }">下一页</a>
      </c:when>
      <c:otherwise>
        <a href="javascript:alert('已经是最有一页了,没有下一页!');">下一页</a>
      </c:otherwise>
    </c:choose>

    <a href="FindAllServlet?pageNo=${page.totalpage}">末页</a>
    &nbsp;&nbsp;
    共${page.totalcount}条

  </div>

</CENTER>

</body>
</html>

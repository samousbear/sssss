<%@page import="java.util.List"%>
<%@page import="bean.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="1" align="center">
		<caption>用户管理</caption>
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>角色</th>
			<th>状态</th>
			<th>照片</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<%
		List<User> list = (List<User>)request.getAttribute("user");
		for(int i=0;i<list.size();i++){
			User u = list.get(i);
			%>
			<tr>
			<td><%=i+1 %></td>
			<td><%=u.getUname() %></td>
			<td><%=u.getUpwd() %></td>
			<td><%=u.getUrole() %></td>
			<td><%=u.getUstate() %></td>
			<td><img align="center" src="<%=u.getUphoto()%>" width="100"></td>
			<th><a href="userLoad.do?method=findOne&uid=<%=u.getUid()%>">编辑</a></th>
			<th><a href="userLoad.do?method=del&uid=<%=u.getUid()%>">删除</a></th>
			</tr>
		<%}%>
		
		
		
		
					
						
		
		
	</table>
</body>
</html>
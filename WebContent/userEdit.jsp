<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User u= (User)request.getAttribute("user");
	%>
	<form action="userLoad.do?method=update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="uid" value="<%=u.getUid() %>" /><br>
		用户名:<input type="text" name="uname" value="<%=u.getUname() %>" /><br>
		用户密码:<input type="text" name="upwd" value="<%=u.getUpwd() %>" /><br>
		角色:<input type="text" name="urole" value="<%=u.getUrole() %>" /><br>
		状态:<input type="text" name="ustate" value="<%=u.getUstate() %>" /><br>
		照片:<img src="<%=u.getUphoto() %>" width="100" /><input type="file" name="uphoto" /><br>
		<button>修改</button>
	</form>
</body>
</html>
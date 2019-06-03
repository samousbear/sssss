<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userLoad.do?method=add" method="post" enctype="multipart/form-data">
		
		用户名:<input type="text" name="uname"/><br>
		密码:<input type="text" name="upwd"/><br>
		照片:<input type="file" name="uphoto"/><br>
		<button>添加</button>
	</form>
</body>
</html>
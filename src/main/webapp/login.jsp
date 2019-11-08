<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
登陆
<form action="/login" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="提交">
</form>
<form action="/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="提交">
</form>
<br/>
<form action="/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="提交">
</form>
</body>
</html>

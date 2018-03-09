<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<body>
	<form action="" id = "form1">
		username:<input type="text" name="email" id="email"><br>
		password:<input type="password" name="password" id="password"><br>
		<input type="text" name="checkcode" id = "checkcode"/>
		<img alt="验证码" id="imagecode" src="<%=request.getContextPath() %>/servlet/ImageServlet"/>
    	<a href="javascript: reloadCode();">看不清楚</a><br>
		<input type="button" value="login" name="login" id="login">
		<input type="reset" value = "reset" name = "reset" id = "reset"> 
	</form>

	<form action="">
		oldpwd:<input type="password" id="oldpwd" name="oldpwd"><br>
		newpwd:<input type="password" id="newpwd" name="newpwd"><br>
		newpwd2:<input type="password" id="newpwd2" name="newpwd2"><br>
		<input type="button" id="changepwd" value="changepwd" name="changepwd">
	</form>
	
	<a href = "user/verificationAgain">重新发送</a><br>
	
	<a href="user/exit">user-exit</a><br>
	
	<a href ="user/registerPage">user-registerPage</a><br><br>
	
	
	文件上传：
	<form action="file/upload" method="post" enctype="multipart/form-data">
		<input type="text" name = "txt" id = "txt"><br>
		<input type="text" name = "txt2" id = "txt2"><br>		
		<input type="file" name = "file" id = "file"><br>
		<input type="file" name = "file2" id = "file2"><br>
		<input type="submit" id = "submit" name = "submit">
	</form>
	
	图片路径测试：
	<form action="">
		<input type="text" name = "id" id = "countryid"><br><br>
		<input type="button" id = "searchCountry" value="changepwd">
	</form>
	
	<div id = "pic">
		<img alt="" src="" id = "aa"></div>
<script type="text/javascript" src="js/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/src/show_detail.js"></script>
<script type="text/javascript" src="js/src/changePwd.js"></script>

<script type="text/javascript">
	function reloadCode(){
		var time = new Date().getTime();
		document.getElementById("imagecode").src="<%=request.getContextPath() %>/servlet/ImageServlet?d="+time;
	}
</script>
</body>
</html>

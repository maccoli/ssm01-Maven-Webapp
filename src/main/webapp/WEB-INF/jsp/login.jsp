<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>

<style>
body {
	background-color: #FEFEFE;
}

.wrap {
	width: 960px;
	margin: 100px auto;
	font-size: 125%;
}

.row {
	margin: 30px 0;
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">
</head>

<body>
	<!-- 验证码 -->
	<div class="wrap">
		<form id="form" method="post" action="VerifyLoginServlet">
			<div class="row">
				<label for="name">邮箱</label> <input type="text" id="email"
					name="email" value="geetest@126.com" />
			</div>
			<div class="row">
				<label for="passwd">密码</label> <input type="password" id="passwd"
					name="passwd" value="gggggggg" />
			</div>
			<div class="row">
				<input type="button" value="登录" id="opener" />
			</div>
			<!-- 验证码 -->
			<div id="dialog">
				<div id="captcha"></div>
			</div>
		</form>
	</div>

<script src="http://static.geetest.com/static/tools/gt.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#opener").click(function(){
		 $("#captcha").empty();
		  var handler = function (captchaObj) {
		         // 将验证码加到id为captcha的元素里
		         captchaObj.appendTo("#captcha");
		     };
		    $.ajax({
		        // 获取id，challenge，success（是否启用failback）
		        url: "StartCaptchaServlet",
		        type: "get",
		        dataType: "json", // 使用jsonp格式
		        success: function (data) {
		            // 使用initGeetest接口
		            // 参数1：配置参数，与创建Geetest实例时接受的参数一致
		            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
		            initGeetest({
		                gt: data.gt,
		                challenge: data.challenge,
		                product: "embed", // 产品形式
		                offline: !data.success
		            }, handler);
		        }
		    });
			$("#dialog").dialog({
		        autoOpen: true,   
		        modal: true,
				width:344,
				height:311,
				title:'请先完成下方验证',
				buttons: {
					"确定": function() {
						$( this ).dialog( "close" );
	 					$(".challenge").attr("value",$(".geetest_challenge").val());
						$(".validate").attr("value",$(".geetest_validate").val());
						$(".seccode").attr("value",$(".geetest_seccode").val()); 
						$("#form").submit();
				},
								
					"取消": function() {
						$( this ).dialog( "close" );
							}
						}
			});
	 })
 })
</script>

</body>
</html>

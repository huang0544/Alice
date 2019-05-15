<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html class="no-js">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>

<script>
	function login() {
		//var json = ${sessionScope.userInfo};
		//var email = json.email;
		//var password = json.password;
		var email = $("#email").val();
		var password = $("#password").val();
		var roleid=$("input[type='radio']:checked").val();
		
		var user = JSON.stringify({
			'email' : email,
			'password' : password,
			'roleid':roleid
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "POST",
					url : '${pageContext.request.contextPath}/Login',
					//dataType : "Application/json",
					data : user,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
							if (roleid == 0) {
								window.location.href = "http://localhost:8080/Alice/Admin/ManagementView";
							} else{

								window.location.href = "http://localhost:8080/Alice/Home";
							}
						} else {
							alert("失败，请重新输入")
						}
					}
				});
	}
</script>

<body>
	<div class="box">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<!-- Start Sign In Form -->
				<center>
					<form class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>
							<center>登录</center>
						</h2>
						<div class="form-group">
							普通用户<input id="roleid" type="radio"  value="1"
								name="1" /> 超级管理员 <input id="roleid" type="radio" value="0"
								name="1" />
						</div>
						<div class="form-group">
							<label for="username" class="sr-only">邮箱</label> <input
								type="text" class="form-control" id="email" placeholder="email"
								name="user.email" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label> <input
								type="password" class="form-control" id="password"
								placeholder="Password" name="user.password" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox"
								id="remember"> 记住账号</label>
						</div>
						<div class="form-group">
							<p>
								还未注册？ <a href="${pageContext.request.contextPath}/RegisterView">注册</a>
								| <a href="${pageContext.request.contextPath}/LostPasswordView">忘记密码</a>
							</p>
						</div>
						<div class="form-group">
							<input type="button" value="登录" class="btn btn-primary"
								onclick="login()" />
						</div>
					</form>
				</center>
				<!-- END Sign In Form -->

			</div>
		</div>

	</div>

</body>

</html>
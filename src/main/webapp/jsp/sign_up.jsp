<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>注册</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>

<script>
	function sign_up() {
		//var json = ${sessionScope.userInfo};
		//var email = json.email;
		//var password = json.password;
		var name = $("#name").val();
		var email = $("#email").val();
		var iphone = $("#iphone").val();
		var password = $("#password").val();
		var sex = $("input[type='radio']:checked").val();
		var roleid = $("input[type='radio']:checked").val();

		var user = JSON.stringify({
			'email' : email,
			'password' : password,
			'name' : name,
			'sex' : sex,
			'iphone' : iphone,
			'roleid' : roleid
		});
		$.ajax({
			contentType : 'application/json;charset=utf-8',
			type : "POST",
			url : '${pageContext.request.contextPath}/RegisterApply',
			//dataType : "Application/json",
			data : user,
			success : function(result) {
				if (result == 1) {
					alert("注册成功，请在邮件激活账号")
					//window.location.reload("http://localhost:8080/Alice/Login"); 
				} else {
					alert("注册失败，请重新注册")
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
				<form class="fh5co-form animate-box" data-animate-effect="fadeIn">
					<h2>注册</h2>

					<div class="form-group">
						普通用户<input id="roleid" type="radio" value="1" name="1" /> 超级管理员 <input
							id="roleid" type="radio" value="0" name="1" />
					</div>
					<div class="form-group">
						<label for="name" class="sr-only">用户名</label> <input type="text"
							class="form-control" id="name" name="user.name"
							placeholder="Name" autocomplete="off">
					</div>
					<div class="form-group">
					<label for="name" class="sr-only">性别</label>
						男<input id="sex" type="radio" value="男" name="2" /> 女<input
							id="sex" type="radio" value="女" name="2" />
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">电子邮箱</label> <input
							type="email" class="form-control" id="email" name="user.email"
							placeholder="Email" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="iphone" class="sr-only">手机号码</label> <input
							type="phone" class="form-control" id="iphone" name="user.iphone"
							placeholder="Iphone" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">密码</label> <input
							type="password" class="form-control" id="password"
							name="user.password" placeholder="Password" autocomplete="off">
					</div>
					<div class="form-group">
						<p>
							已经注册？ <a href="${pageContext.request.contextPath}/LoginView">登录</a>
						</p>
					</div>
					<div class="form-group">
						<input type="button" value="注册" class="btn btn-primary"
							onclick="sign_up()">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>
	</div>

</body>

</html>
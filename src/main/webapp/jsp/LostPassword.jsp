<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>忘记密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>
<script>
	function password() {
		var email = $("#email").val();
		var user = JSON.stringify({
			'email' : email
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "POST",
					url : '${pageContext.request.contextPath}/LostPassword',
					//dataType : "json",
					data : user,
					success : function(result) {
						if (result == 1) {
							alert("验证成功，请在邮箱查看您的密码")
							window.location.href = "http://localhost:8080/Alice/LoginView";
						} else {
							alert("失败")
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
					<h2>忘记密码</h2>
					<div class="form-group">
						<div class="alert alert-success" role="alert">发送邮箱</div>
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">电子邮箱</label> <input
							type="email" class="form-control" id="email" placeholder="Email"
							autocomplete="off">
					</div>
					<div class="form-group">
						<p>
							<a href="${pageContext.request.contextPath}/LoginView">登录</a> 或 <a
								href="${pageContext.request.contextPath}/RegisterView">注册</a>
						</p>
					</div>
					<div class="form-group">
						<input type="button" value="发送到电子邮箱" class="btn btn-primary"
							onclick="password()">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>
	</div>

</body>

</html>
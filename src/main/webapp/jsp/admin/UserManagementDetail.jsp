<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>用户管理详情</title>

<!-- CSS
   ================================================== -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/vendor.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bar.css" />

<!-- script
   ================================================== -->
<script src="${pageContext.request.contextPath}/js/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/js/pace.min.js"></script>

<!-- favicons
	================================================== -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">

</head>
<script>
	function deleteUser() {
		//var datingId = $("#datingId").val();
		//var datingName = $("#datingName").val();
		var user = JSON.stringify({
			'email' : '${User.email}'
		});

		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "delete",
					url : '${pageContext.request.contextPath}/DeleteUser',
					//dataType : "json",
					data : user,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
							window.location.href = "http://localhost:8080/Alice/UserManagementView";
						} else {
							alert("失败")
						}
					}
				});
	}
</script>

<body id="top">

	<!-- header 
   ================================================== -->
	<header class="short-header">

		<div class="gradient-block"></div>

		<div class="row header-content">

			<div class="logo">
				<a href="#">驴友之家</a>
			</div>

			<nav id="main-nav-wrap">
				<ul class="main-navigation sf-menu">
					<li class="current"><a
						href="${pageContext.request.contextPath}/ManagementView"
						title="主页">主页</a></li>
					<li class="has-children"><a title="文章管理">文章管理</a>
						<ul class="sub-menu">
							<c:forEach items="${allCategory}" var="node">
								<li><a target="_blank"
									href="${pageContext.request.contextPath}/ArticleManagementView?categoryName=${node.categoryName}&categoryId=${node.categoryId}&categoryIntroduce=${node.categoryIntroduce}"><c:out
											value="${node.categoryName}"></c:out> </a></li>
							</c:forEach>
						</ul></li>
					<li class="has-children"><a
						href="${pageContext.request.contextPath}/DatingManagementView"
						title="户外活动分类">活动管理</a></li>
					<li class="has-children"><a
						href="${pageContext.request.contextPath}/UserManagementView"
						title="个人信息">用户管理</a></li>

				</ul>
			</nav>
			<!-- end main-nav-wrap -->


		</div>

	</header>
	<!-- end header -->

	<!-- page header
   ================================================== -->

	<div class="banner">用户信息详情</div>
	<div class="g-bd">
		<table border="1" width="100%" height="200px">

			<tr>
				<td width="50%">
					<center>昵称</center>
				</td>
				<td>${User.name}</td>
			</tr>
			<tr>
				<td width="50%">
					<center>邮箱</center>
				</td>
				<td>${User.email }</td>
			</tr>
			<tr>
				<td>
					<center>密码</center>
				</td>
				<td>${User.password}</td>
			</tr>
			<tr>
				<td>
					<center>性别</center>
				</td>
				<td>${User.sex }</td>
			</tr>
			<tr>
				<td>
					<center>电话</center>
				</td>
				<td>${User.iphone }</td>
			</tr>

		</table>
		<td><input type="button" value="删除用户" onclick="deleteUser()"
			style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;" />
	</div>
	<!-- footer
   ================================================== -->
	<footer>

		<div class="footer-bottom">
			<div class="row">

				<div class="col-twelve">
					<div class="copyright">

						<div id="go-top">
							<a class="smoothscroll" title="Back to Top" href="#top"><i
								class="icon icon-arrow-up"></i></a>
						</div>
					</div>

				</div>
			</div>
			<!-- end footer-bottom -->
	</footer>
	<div id="preloader">
		<div id="loader"></div>
	</div>

	<!-- Java Script
   ================================================== -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>
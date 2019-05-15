<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>文章详情</title>

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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />

<!-- script
   ================================================== -->
<script src="${pageContext.request.contextPath}/js/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/js/pace.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/npm.js"></script>

<!-- favicons
	================================================== -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">

</head>
<script>
	function updateDating() {
		var datingName = $("#datingName").val();
		var datingContent = $("#datingContent").val();
		var dating = JSON.stringify({
			'datingId' : '${dating.datingId}',
			'datingName' : datingName,
			'datingContent' : datingContent,
		//'datingId' : '${dating.datingId}'

		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "POST",
					url : '${pageContext.request.contextPath}/UpdateDating',
					//dataType : "Application/json",
					data : dating,
					success : function(result) {
						if (result == 0) {
							alert("失败，请重新输入")

						} else {

							alert("成功！")
							window.location.href = "http://localhost:8080/Alice/DatingBySponsorEmailView";
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
						href="${pageContext.request.contextPath}/Home" title="">主页</a></li>
					<li class="has-children"><a title="驴友博客">驴友博客</a>
						<ul class="sub-menu">
							<c:forEach items="${allCategory}" var="node">
								<li><a target="_blank"
									href="${pageContext.request.contextPath}/ArticleView?categoryName=${node.categoryName}&categoryId=${node.categoryId}&categoryIntroduce=${node.categoryIntroduce}"><c:out
											value="${node.categoryName}"></c:out> </a></li>
							</c:forEach>
						</ul></li>
					<li class="has-children"><a title="户外活动分类">户外活动分类</a>
						<ul class="sub-menu">
							<li><a href="${pageContext.request.contextPath}/DatingView">查看活动</a></li>
							<li><a
								href="${pageContext.request.contextPath}/AddDatingView">发布活动</a></li>
							<li><a
								href="${pageContext.request.contextPath}/DatingBySponsorEmailView">我发布的活动</a></li>
							<li><a
								href="${pageContext.request.contextPath}/DatingByUser">我参加的活动</a></li>
						</ul></li>
					<li class="has-children"><a title="个人信息">个人信息</a>
						<ul class="sub-menu">
							<li><a href="${pageContext.request.contextPath}/UserView">查看个人信息</a></li>
							<li><a
								href="${pageContext.request.contextPath}/UserEditView">编辑个人信息</a></li>
							<li><a
								href="${pageContext.request.contextPath}/UpdatePassword">密码修改</a></li>
							<li><a
								href="${pageContext.request.contextPath}/ArticleByUserView">我发表的文章</a></li>
						</ul></li>
				</ul>
			</nav>
			<!-- end main-nav-wrap -->


		</div>

	</header>
	<!-- end header -->

	<!-- content
   ================================================== -->
	<div class="banner">活动详情</div>
	<div class="g-bd1 f-cb">
		<div class="g-sd1">
			<div>

				<img src="images/avatars/user-01.jpg">
				<table height="200px">

					<tr>
						<td width="auto">昵称:</td>

						<td><c:out value="${dating.datingSponsorName}"></c:out></td>
					</tr>
					<tr>
						<td width="auto">邮箱:</td>
						<td><c:out value="${dating.datingSponsorEmail}"></c:out></td>
					</tr>

				</table>
			</div>
		</div>

		<div class="g-mn1c">
			<table>

				<tr>
					<td><h3>活动标题</h3></td>
					<td><input type="text" id="datingName"
						value="${dating.datingName}" style="width: 500px" /></td>
				</tr>
				<tr>
					<td width="auto">
						<p>活动开始时间：</p>
					</td>
					<td width="100px">${dating.datingStartTime}</td>
				</tr>
				<tr>
					<td>
						<p>活动结束时间：</p>
					</td>
					<td>${dating.datingOverTime }</td>
				</tr>
				<tr>
					<td>
						<p>活动内容:</p>
					</td>
					<td><textarea id="datingContent" style="width: 800px">${dating.datingContent}</textarea></td>
				</tr>
				<tr>
					<td><input type="button" onclick="updateDating()" value="编辑活动"
						style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;" />
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- end content -->
	<div>

		<div>
			<table border="1px" width="1300px">
				<tr>
					<h2>参加活动的人：</h2>
				</tr>
				<tr>
					<td width="60px" align="center">邮箱</td>
					<td width="100px" align="center">昵称</td>
					<td width="900px" align="center">性别</td>
					<td align="center">电话</td>
				</tr>
				<c:forEach items="${joinDatingUser}" var="node">
					<tr>
						<td><c:out value="${node.joinUserEmail }"></c:out></td>
						<td><c:out value="${node.joinUserName }"></c:out></td>
						<td><c:out value="${node.joinUserSex }"></c:out></td>
						<td><c:out value="${node.joinUserIphone }"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</div>
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
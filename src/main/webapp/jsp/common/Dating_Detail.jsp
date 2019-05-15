<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>活动详情</title>

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
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>




</head>
<script>
	function joinDating() {
		//var json = ${sessionScope.userInfo};
		//var email = json.email;
		//var password = json.password;
		//var datingName = $("#datingName").val();
		var dating = JSON.stringify({
			'joinDatingId':'${dating.datingId}',
			'joinDatingName' : '${dating.datingName}',
			'joinDatingContent' : '${dating.datingContent}',
			'joinDatingStartTime' : '${dating.datingStartTime}',
			'joinDatingOverTime' : '${dating.datingOverTime}',
			'joinDatingSponsorName' : '${dating.datingSponsorName}',
			'joinDatingSponsorEmail' : '${dating.datingSponsorEmail}'
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "POST",
					url : '${pageContext.request.contextPath}/AddJoinDating',
					//dataType : "Application/json",
					data : dating,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
							window.location.href = "http://localhost:8080/Alice/DatingView";
						} else {
							alert("失败，请重新输入")
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

					<td><h2>${dating.datingName}</h2></td>
				</tr>
				<tr>
					<td width="auto">
						<p>活动开始时间：</p>
					</td>
					<td>${dating.datingStartTime}</td>
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
					<td>${dating.datingContent}</td>
				</tr>
				<tr>
					<td><input type="button" value="参加活动"
						style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;"
						onclick="joinDating()" /></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- end content -->

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
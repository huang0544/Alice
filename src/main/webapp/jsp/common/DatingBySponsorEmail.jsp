<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>我发布的活动</title>

<!-- CSS
   ================================================== -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bar.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />

<!-- script
   ================================================== -->
<script src="${pageContext.request.contextPath}/js/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/js/pace.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/npm.js"></script>

<!-- favicons
	================================================== -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">

</head>

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
							<li><a href="${pageContext.request.contextPath}/DatingBySponsorEmailView">我发布的活动</a></li>
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
	<div class="banner">我发布的活动</div>

	<div>
		<table border="1" width="100%">
			<tr>
				<td>全部主题</td>
				<td>作者</td>
				<td>发表时间</td>
			</tr>
			<c:forEach items="${datingBySponsorEmail}" var="node">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/DatingBySponsorEmailDetailView?datingId=${node.datingId }&datingName=${node.datingName}">
							<c:out value="${node.datingName}"></c:out>
					</a></td>
					<td><c:out value="${node.datingSponsorName }"></c:out></td>
					<td><c:out value="${node.datingCreatetime}"></c:out></td>
				</tr>
			</c:forEach>
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
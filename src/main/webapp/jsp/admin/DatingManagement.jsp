<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>


<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>活动管理</title>

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
						href="${pageContext.request.contextPath}/ManagementView" title="主页">主页</a></li>
					<li class="has-children"><a title="文章管理">文章管理</a>
						<ul class="sub-menu">
							<c:forEach items="${allCategory}" var="node">
								<li><a target="_blank"
									href="${pageContext.request.contextPath}/ArticleManagementView?categoryName=${node.categoryName}&categoryId=${node.categoryId}&categoryIntroduce=${node.categoryIntroduce}"><c:out
											value="${node.categoryName}"></c:out> </a></li>
							</c:forEach>
						</ul></li>
					<li class="has-children"><a href="${pageContext.request.contextPath}/DatingManagementView" title="户外活动分类">活动管理</a></li>
					<li class="has-children"><a href="${pageContext.request.contextPath}/UserManagementView" title="个人信息">用户管理</a></li>

				</ul>
			</nav>
			<!-- end main-nav-wrap -->


		</div>

	</header>
	<!-- end header -->

	<!-- content
   ================================================== -->
	
	<div class="banner">活动管理</div>

	<div>
		<table border="1" width=1300>
			<tr>
				<td>活动主题</td>
				<td>发布人</td>
				<td>发表时间</td>
			</tr>

			<c:forEach items="${allDating}" var="node">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/DatingManagementDetailView?datingName=${node.datingName }&datingId=${node.datingId}"><c:out
								value="${node.datingName}"></c:out></a></td>
					<td><c:out value="${node.datingSponsorName}"></c:out></td>
					<td><c:out value="${node.datingCreatetime}"></c:out></td>
				</tr>
			</c:forEach>
		</table>

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
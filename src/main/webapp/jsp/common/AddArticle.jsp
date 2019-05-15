<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>${categoryName}-发布帖子</title>
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
	function add_article() {
		//var json = ${sessionScope.userInfo};
		//var articleSponsorName = json.name;
		//var articleSponsorEmail = json.email;
		var articleName = $("#articleName").val();
		var articleContent = $("#articleContent").val();
		var article = JSON.stringify({
			'articleCategoryId' : '${categoryId}',
			'articleCategoryName' : '${categoryName}',
			'articleName' : articleName,
			'articleContent' : articleContent
		});
		$.ajax({
			contentType : 'application/json;charset=utf-8',
			type : "POST",
			url : '${pageContext.request.contextPath}/AddArticle',
			//dataType : "json",
			data : article,
			success : function(result) {
				if (result == 1) {
					alert("成功！")
					window.location.reload="http://localhost:8080/Alice/Home"; 
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
	<div class="body-title">
		<div class="title">${categoryName}</div>
		<div class="title-font">版主:hjj</div>
		<div class="title-font2">${categoryIntroduce}</div>
	</div>
	<div class="g-bd">
		<table>
			<tr>
				<td><b>标题：</b></td>
				<td><input type="text" placeholder="请输入标题" id="articleName"
					name="articleName" style="width: 1000px; height: auto" /></td>
			</tr>
			<tr>
				<td><b>文章内容：</b></td>
				<td><textarea name="a" style="width: 1100px; height: auto;"
						id="articleContent" name="articleContent" placeholder="请输入要发表内容"></textarea></td>
			</tr>
			<tr>
				<td><input type="button" value="发表新帖"
					style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;"
					onclick="add_article()" /></td>
			</tr>
		</table>
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
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>我发表的文章详情</title>

<!-- CSS
   ================================================== -->
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/vendor.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bar.css" />

<!-- script
   ================================================== -->
<script src="js/modernizr.js"></script>
<script src="js/pace.min.js"></script>

<!-- favicons
	================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

</head>
<script>
	function deleteArticle() {
		var article = JSON.stringify({
			'articleId' : '${articleManagementDetail.articleId}'
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "DELETE",
					url : '${pageContext.request.contextPath}/DeleteArticle',
					//dataType : "json",
					data : article,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
							window.location.href = "http://localhost:8080/Alice/ArticleByUserView";
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

	<!-- page header
   ================================================== -->
	<div class="banner">我发表的文章详情</div>
	<section id="content-wrap" class="blog-single">
		<div class="row">
			<div class="col-twelve">

				<article class="format-gallery">

					<div class="content-media">
						<div class="post-slider flexslider">
							<ul class="slides">
								<li><img
									src="images/thumbs/single/gallery/single-gallery-01.jpg">
								</li>
								<li><img
									src="images/thumbs/single/gallery/single-gallery-02.jpg">
								</li>
								<li><img
									src="images/thumbs/single/gallery/single-gallery-03.jpg">
								</li>
							</ul>
						</div>
					</div>

					<div class="primary-content">

						<h1 class="entry-title">${articleManagementDetail.articleName}</h1>

						<ul class="entry-meta">
							<li class="date">${articleManagementDetail.articleCreateTime}</li>

						</ul>

						<p>${articleManagementDetail.articleContent }</p>
						<input type="button" value="删除文章" onclick="deleteArticle()"
							style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;" />

					</div>
					<!-- end entry-primary -->

				</article>

			</div>
			<!-- end col-twelve -->
		</div>
		<!-- end row -->

		</div>

		<!-- Form End -->

	</section>
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
	<script src="js/jquery-2.1.3.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>

</body>

</html>
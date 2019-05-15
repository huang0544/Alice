<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>驴友之家后台管理</title>

<!-- CSS
   ================================================== -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/vendor.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">

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

	<!-- masonry
   ================================================== -->
	<section id="bricks">

		<div class="row masonry">

			<!-- brick-wrapper -->
			<div class="bricks-wrapper">

				<div class="grid-sizer"></div>

				<div class="brick entry featured-grid animate-this">
					<div class="entry-content">
						<div id="featured-post-slider" class="flexslider">
							<ul class="slides">

								<li>
									<div class="featured-post-slide">

										

										<div class="overlay"></div>

										<div class="post-content">

											<h1 class="slide-title">
												驴友之家后台管理<a href="#" title="">l</a>
											</h1>
										</div>

									</div>
								</li>
								<!-- /slide -->

								<li>
									<div class="featured-post-slide">

									
										<div class="overlay"></div>

										<div class="post-content">

											<h1 class="slide-title">
												<a href="single-standard.html" title="">文章管理</a>
											</h1>
										</div>

									</div>
								</li>
								<!-- /slide -->

								<li>
									<div class="featured-post-slide">

										
										<div class="overlay"></div>

										<div class="post-content">
											<ul class="entry-meta">

											</ul>

											<h1 class="slide-title">
												<a href="single-standard.html" title="">活动管理</a>
											</h1>
										</div>

									</div>
								</li>
								<!-- end slide -->
								<li>
									<div class="featured-post-slide">

									
										<div class="overlay"></div>

										<div class="post-content">
											<ul class="entry-meta">

											</ul>

											<h1 class="slide-title">
												<a href="single-standard.html" title="">用户管理</a>
											</h1>
										</div>

									</div>
								</li>
								<!-- end slide -->

							</ul>
							<!-- end slides -->
						</div>
						<!-- end featured-post-slider -->
					</div>
					<!-- end entry content -->
				</div>

				<article class="brick entry format-standard animate-this">

					

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="#">文章管理</a>
							</h1>

						</div>
						<div class="entry-excerpt">将违规操作的文章进行删除</div>
					</div>

				</article>
				<!-- end article -->

				<article class="brick entry format-standard animate-this">

					

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="#">活动管理</a>
							</h1>

						</div>
						<div class="entry-excerpt">将违规的活动或者已完成的活动进行删除</div>
					</div>

				</article>
				<!-- end article -->
				<article class="brick entry format-standard animate-this">

					

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="#">用户管理</a>
							</h1>

						</div>
						<div class="entry-excerpt">发布违规文章或活动三次以上的用户可进行删除</div>
					</div>

				</article>
				<!-- end article -->



			</div>
			<!-- end brick-wrapper -->

		</div>
		<!-- end row -->

	</section>
	<!-- end bricks -->
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
	<script src="${pageContext.request.contextPath}/js/jquery.appear.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>

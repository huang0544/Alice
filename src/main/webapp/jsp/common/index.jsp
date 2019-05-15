<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>驴友之家</title>

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

										<div class="post-background"
											style="background-image: url('images/thumbs/featured/featured-1.jpg');"></div>

										<div class="overlay"></div>

										<div class="post-content">

											<h1 class="slide-title">
												<a href="#" title="">欢迎来到驴友之家</a>
											</h1>
										</div>

									</div>
								</li>
								<!-- /slide -->

								<li>
									<div class="featured-post-slide">

										<div class="post-background"
											style="background-image: url('images/thumbs/featured/featured-2.jpg');"></div>

										<div class="overlay"></div>

										<div class="post-content">

											<h1 class="slide-title">
												<a href="single-standard.html" title="">在这里你可以分享自己的旅游经历</a>
											</h1>
										</div>

									</div>
								</li>
								<!-- /slide -->

								<li>
									<div class="featured-post-slide">

										<div class="post-background"
											style="background-image: url('images/thumbs/featured/featured-3.jpg');"></div>

										<div class="overlay"></div>

										<div class="post-content">
											<ul class="entry-meta">

											</ul>

											<h1 class="slide-title">
												<a href="single-standard.html" title="">相约志同道合的驴友共同出游</a>
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

					<div class="entry-thumb">
						<a href="single-standard.html" class="thumb-link"> <img
							src="images/thumbs/diagonal-building.jpg" alt="building">
						</a>
					</div>

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="#">户外活动分类</a>
							</h1>

						</div>
						<div class="entry-excerpt">
							在这里你可以组织一场活动，邀请广大驴友参加，寻找志同道合的驴友共同出游</div>
					</div>

				</article>
				<!-- end article -->

				<article class="brick entry format-standard animate-this">

					<div class="entry-thumb">
						<a href="single-standard.html" class="thumb-link"> <img
							src="images/thumbs/ferris-wheel.jpg" alt="ferris wheel">
						</a>
					</div>

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="#">活动约伴</a>
							</h1>

						</div>
						<div class="entry-excerpt">
							在这里你可以发表文章，邀请驴友们来参加你打算举行或者已经举行的活动，分享你的活动想法，让更多的驴友加入你的行程</div>
					</div>

				</article>
				<!-- end article -->

				<article class="brick entry animate-this">

					<div class="entry-thumb">
						<a href="single-standard.html" class="thumb-link"> <img
							src="images/thumbs/usaf-rocket.jpg" alt="USAF rocket">
						</a>
					</div>

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="#">行摄笔记</a>
							</h1>

						</div>
						<div class="entry-excerpt">
							在这里你可以向驴友们分享自己的旅行笔记，将自己的快乐行程诉说给驴友们，让大家一起享受旅游的喜悦</div>
					</div>

				</article>
				<!-- end article -->

				<article class="brick entry format-gallery group animate-this">

					<div class="entry-thumb">

						<div class="post-slider flexslider">
							<ul class="slides">
								<li><img src="images/thumbs/salad.jpg"></li>

							</ul>
						</div>

					</div>

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="single-gallery.html">线路攻略</a>
							</h1>

						</div>
						<div class="entry-excerpt">
							在这里你可以向驴友们推荐各种线路，给驴友们推荐不同的旅行选择，以及不同的线路旅行时所需注意的</div>
					</div>

				</article>
				<!-- end article -->

				<article class="brick entry animate-this">

					<div class="entry-thumb">
						<a href="single-standard.html" class="thumb-link"> <img
							src="images/thumbs/shutterbug.jpg" alt="Pattern">
						</a>
					</div>

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="single-standard.html">户外装备</a>
							</h1>

						</div>
						<div class="entry-excerpt">
							在这里你可以向驴友们推荐出行所需的装备，所谓”工欲善其事，必先利其器“，有了好的装备，驴友们的出行体验必定更上一层楼</div>
					</div>

				</article>
				<!-- end article -->

				<article class="brick entry animate-this">

					<div class="entry-thumb">
						<a href="single-standard.html" class="thumb-link"> <img
							src="images/thumbs/single/gallery/single-gallery-03.jpg"
							alt="Pattern">
						</a>
					</div>

					<div class="entry-text">
						<div class="entry-header">

							<h1 class="entry-title">
								<a href="single-standard.html">驴友问答</a>
							</h1>

						</div>
						<div class="entry-excerpt">
							驴友们可就出行的各种问题在这一模块提出，让其他驴友解答旅行中的各种问题，驴友们出行前可以更好的做好自己的旅行攻略，出行体验便会变了更好
						</div>
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

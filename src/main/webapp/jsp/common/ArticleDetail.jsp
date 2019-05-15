<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>${categoryName}-文章详情</title>

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
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>


<!-- favicons
	================================================== -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">

</head>
<script>
	function add_comment() {
		//var json = ${ sessionScope.userInfo};
		//var commentByName = json.name;
		//var commentByEmail = json.email;
		var commentContent = $("#commentContent").val();
		var comment = JSON.stringify({
			'commentArticleId' : '${commentArticleId}',
			'commentContent' : commentContent,
		});
		$.ajax({
			contentType : 'application/json;charset=utf-8',
			type : "POST",
			url : '${pageContext.request.contextPath}/AddComment',
			//dataType : "json",
			data : comment,
			success : function(result) {
				if (result == 1) {
					alert("成功！")
					window.location.reload();
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

	<!-- content
   ================================================== -->
	<div>
		<div class="body-title">
			<div class="title">${categoryName}</div>
			<div class="title-font">版主:hjj</div>
			<div class="title-font2">${categoryIntroduce}</div>
		</div>

	</div>
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

						<h1 class="entry-title">${articleDetail.articleName}</h1>

						<ul class="entry-meta">
							<li class="date">${articleDetail.articleCreateTime}</li>

						</ul>

						<p>${articleDetail.articleContent}</p>
						<div class="author-profile">
							<img src="images/avatars/user-03.jpg" alt="">

							<div class="about">
								<h4>
									<a href="#">${articleDetail.articleSponsorName}</a>
								</h4>

								邮箱:${articleDetail.articleSponsorEmail}

								<ul class="author-social">
									<li><a href="#">Facebook</a></li>
									<li><a href="#">Twitter</a></li>
									<li><a href="#">WeChat</a></li>
									<li><a href="#">Instagram</i>
									</a></li>
								</ul>
							</div>
						</div>
						<!-- end author-profile -->

					</div>
					<!-- end entry-primary -->



				</article>

			</div>
			<!-- end col-twelve -->
		</div>
		<!-- end row -->

		</div>

		<!-- Form End -->

		<div id="comments" class="row">
			<!-- Respond End -->
			<div class="comments-wrap">
				<!-- respond -->
				<div class="respond">

					<h3>发表评论</h3>

					<form name="contactForm" id="contactForm" method="post" action="">
						<fieldset>

							<div class="message form-field">
								<textarea name="commentContent" id="commentContent"
									class="full-width" placeholder="请输入评论内容"></textarea>
							</div>

							<input type="button" value="评论" class="submit button-primary"
								onclick="add_comment()" />

						</fieldset>
					</form>
					<!-- Form End -->

				</div>
				<!-- Respond End -->
				<div class="col-full">

					<h3>所有评论</h3>

					<!-- commentlist -->

					<c:forEach items="${comment}" var="node">
						<ol class="commentlist">

							<li class="depth-1">
								<div class="avatar">
									<img width="50" height="50" class="avatar"
										src="images/avatars/user-03.jpg" alt="">
								</div>

								<div class="comment-content">

									<div class="comment-info">
										<cite><c:out value="${node.commentByName}"></c:out></cite>

										<div class="comment-meta">
											<time class="comment-time">
												<c:out value="${node.commentCreateTime}"></c:out>
											</time>

										</div>
									</div>

									<div class="comment-text">
										<p>
											<c:out value="${node.commentContent}"></c:out>
										</p>
									</div>

								</div>

							</li>

						</ol>
					</c:forEach>
					<!--
					<div>
						<table border="1px" width="1300px">
							<tr>
								<td width="60px" align="center">索引</td>
								<td width="100px" align="center">昵称</td>
								<td width="900px" align="center">评论内容</td>
								<td align="center">评论时间</td>
							</tr>
							<c:forEach items="${comment}" var="node">
								<tr>
									<td width="60px" align="center"><c:out
											value="${node.commentId}"></c:out></td>
									<td width="100px" align="center"><c:out
											value="${node.commentByName}"></c:out></td>
									<td width="900px" align="center"><c:out
											value="${node.commentContent}"></c:out></td>
									<td align="center"><c:out
											value="${node.commentCreateTime}"></c:out></td>
								</tr>
							</c:forEach>
						</table>
					</div>
-->
					<!-- Commentlist End -->

				</div>
				<!-- end col-full -->
			</div>
			<!-- end row comments -->
		</div>
		<!-- end comments-wrap -->

	</section>
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
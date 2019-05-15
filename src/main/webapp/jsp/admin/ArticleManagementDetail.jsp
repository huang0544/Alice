<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js" lang="en">
<!--<![endif]-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>文章管理详情</title>

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
	function deleteArticle() {
		var article = JSON.stringify({
			'articleId' : '${articleDetail.articleId}'
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
							//window.location.href = "http://localhost:8080/Alice/ManagementView";
						} else {
							alert("失败")
						}
					}
				});
	}
</script>
<script>
	function deleteComment() {
		var commentId = $("#commentId").val();
		var comment = JSON.stringify({
			'commentId' : commentId
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "delete",
					url : '${pageContext.request.contextPath}/DeleteComment',
					//dataType : "json",
					data : comment,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
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

	<div class="banner">文章管理详情</div>

	<div class="g-bd1 f-cb">
		<div class="g-sd1">
			<div>

				<img src="images/avatars/user-01.jpg">
				<table height="200px">

					<tr>
						<td width="auto">昵称:</td>

						<td>${articleDetail.articleSponsorEmail}</td>

					</tr>
					<tr>
						<td width="auto">邮箱:</td>
						<td>${articleDetail.articleSponsorEmail}</td>

					</tr>

				</table>
			</div>
		</div>

		<div class="g-mn1c">
			<table>

				<tr>
					<center>
						<h2>${articleDetail.articleName}</h2>
					</center>
				</tr>
				<tr height="auto">
					<td>
						<h3>文章内容:</h3>
					</td>
					<td>${articleDetail.articleContent}</td>
				</tr>
				<tr valign="bottom">
					<td><input type="button" onclick="deleteArticle()"
						value="删除文章"
						style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;" />
					</td>
				</tr>

			</table>
		</div>
	</div>
	<div>
		<table>
			<tr>
				<td>删除评论：</td>
				<td><input type="text" placeholder="填写需要删除的评论的索引"
					id="commentId" name="commentId" style="width: 800px" /></td>
				<td><input type="button" value="删除评论"
					style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;"
					onclick="deleteComment()" /></td>
			</tr>
		</table>
	</div>
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
					<td align="center"><c:out value="${node.commentCreateTime}"></c:out>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
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

</body>

</html>


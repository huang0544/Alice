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
<title>我参加的活动-详情</title>


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
<script>
	function deleteDating() {
		//var datingId = $("#datingId").val();
		//var datingName = $("#datingName").val();
		var dating = JSON.stringify({
			'joinId' : '${datingDetail.joinId}'
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "delete",
					url : '${pageContext.request.contextPath}/DeleteJoinDating',
					//dataType : "json",
					data : dating,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
							window.location.href = "http://localhost:8080/Alice/DatingByUser";
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
	<div class="banner">${datingDetail.joinDatingName}</div>

	<div class="g-bd1 f-cb">

		<table>
			<tr>

				<td>
					<h2>${datingDetail.joinDatingName}</h2>
				</td>
			</tr>

			<tr>
				<td><br> <b>活动开始时间：</b></br></td>
				<td><br>${datingDetail.joinDatingStartTime}</br></td>
			</tr>
			<tr>
				<td><br> <b>活动结束时间：</b></br></td>
				<td><br>${datingDetail.joinDatingOverTime}</br></td>
			</tr>
			<tr>
				<td><br> <b>活动内容:</b></br></td>
				<td><br>${datingDetail.joinDatingContent}</br></td>
			</tr>
			<tr>
				<td><input type="button" value="取消参加活动"
					onclick="deleteDating()"
					style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;" />
				</td>
			</tr>
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
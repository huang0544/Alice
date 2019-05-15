<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

   <!--- basic page needs
   ================================================== -->
   <meta charset="utf-8">
	<title>个人信息编辑</title>

 	<!-- CSS
   ================================================== -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor.css">  
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bar.css" />
        

   <!-- script
   ================================================== -->
	<script src="${pageContext.request.contextPath}/js/modernizr.js"></script>
	<script src="${pageContext.request.contextPath}/js/pace.min.js"></script>

   <!-- favicons
	================================================== -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">

</head>
<script>
	function userEdit() {
		//var json = ${sessionScope.userInfo};
		//var email = json.email;
		//var password = json.password;
		var name = $("#name").val();
		var sex = $("#sex").val();
		var iphone = $("#iphone").val();
		var user = JSON.stringify({
			'name' : name,
			'sex' : sex,
			'iphone' : iphone
		});
		$
				.ajax({
					contentType : 'application/json;charset=utf-8',
					type : "POST",
					url : '${pageContext.request.contextPath}/UpdateUser',
					//dataType : "Application/json",
					data : user,
					success : function(result) {
						if (result == 1) {
							alert("成功！")
							window.location.href = "http://localhost:8080/Alice/UserView";
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
<div class="banner">个人信息修改</div>
			
			<div class="g-bd">
					<table height="200px">
					<tr>
						<td>邮箱：</td>
						<td>${UserEdit.email}</td>
					</tr>
					<tr>
						<td>密码：</td>
						<td>${UserEdit.password}</td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input type="text" id="sex" value="${UserEdit.sex}" /></td>
					</tr>
					<tr>
						<td>昵称：</td>
						<td><input type="text" id="name" value="${UserEdit.name}" /></td>
					</tr>
					<tr>
						<td>电话：</td>
						<td><input type="text" id="iphone" value="${UserEdit.iphone}" /></td>
					</tr>
					<tr>
						<td><input type="button" value="确定" onclick="userEdit()"
							style="background-color: #F78536; width: auto; height: auto; font-size: large; color: #F1F1F1;" />
						</td>
					</tr>
				</table>
			</div>

  <!-- end content -->




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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
.header {
	padding: 1px;
	font-size: 24px;
	text-align: center;
	background: #f1f1f1;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.Column {
	width: 100%;
}

/* Fake image */
.fakeimg {
	background-color: #aaa;
	width: 100%;
	padding: 20px;
}

/* Add a card effect for articles */
.card {
	background-color: #f1f1f1;
	padding: 20px;
	margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Footer */
.footer {
	padding: 20px;
	text-align: center;
	background: #ddd;
	margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.Column {
		width: 100%;
		padding: 0;
	}
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 4px 14px;
	margin-top: 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	float: right;
}
</style>
<body>


	<%@ include file="common/header.jsp"%>
	<div class="content">
		<div class="header">
			<h2>Blogs</h2>
		</div>
		<%
			if (request.getAttribute("message") != null)
				out.println(request.getAttribute("message"));
		%>
		<%
			if (request.getSession().getAttribute("blogger") != null && request.getParameter("blogger") != null) {
		%>
		<a class="button" href="${pageContext.request.contextPath}/Blog">+
			Add Blog</a>
		<%
			}
		%>
		<div class="row">
			<div class="Column">
				<c:forEach items="${blogsList}" var="blog">
					<div class="card">

						<h2>${blog.title}</h2>
						<h5>${blog.date}
							<p>Posted By ${blog.author}</p>
						</h5>
						<!-- <div class="fakeimg" style="height:200px;">Image</div> -->
						<p>${blog.description}
							<%
								if (request.getSession().getAttribute("blogger") != null && request.getParameter("blogger") != null) {
							%>
							<a class="button" href="${pageContext.request.contextPath}/Blog?blogId=${blog.id}&method=DELETE">Delete</a><a
								class="button" style="margin-right: 5px;"
								href="${pageContext.request.contextPath}/Blog?blogId=${blog.id}">Edit</a>
						</p>
						<%
							}
						%>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
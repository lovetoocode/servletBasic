<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
body {
	margin: 0;
	font-family: "Lato", sans-serif;
}

.sidebar {
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

.sidebar a {
	display: block;
	color: black;
	padding: 16px;
	text-decoration: none;
}

.sidebar a.active {
	background-color: #4CAF50;
	color: white;
}

.sidebar
 
a
:hover
:not
 
(
.active
 
)
{
background-color
:
 
#555
;

	
color
:
 
white
;


}
div.content {
	margin-left: 200px;
	padding: 32px 22px 9px 12px;
}

@media screen and (max-width: 700px) {
	.sidebar {
		width: 100%;
		height: auto;
		position: relative;
	}
	.sidebar a {
		float: left;
	}
	div.content {
		margin-left: 0;
	}
}

@media screen and (max-width: 400px) {
	.sidebar a {
		text-align: center;
		float: none;
	}
}
</style>
<div class="sidebar">
<%
		
		if (request.getSession().getAttribute("blogger") != null) {
	%>
<p style="text-align:center;">Welcome ${blogger.fullName}</p>
<%
		}
	%>
	<a class="active" href="${pageContext.request.contextPath}">Blogs</a>
	<%
		
		if (request.getSession().getAttribute("blogger") != null) {
	%>
	<a class="" href='${pageContext.request.contextPath}?blogger=${blogger.registrationId}'>Your Blogs</a>
	<a class="" href='${pageContext.request.contextPath}/Logout'>Logout</a>
	<%
		}
	%>
	<%
		if (request.getSession().getAttribute("blogger") == null) {
	%>
	<a class="" href="${pageContext.request.contextPath}/Login">Login</a>
	<% } %>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.input, select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.card {
	background-color: #f1f1f1;
	padding: 20px;
	margin-top: 20px;
}
</style>
<body>


	<%@ include file="common/header.jsp"%>
	<div class="content">
		<%
	if(request.getAttribute("message")!=null)
    	out.println(request.getAttribute("message"));
%>
		<div class="card">
			<form action="${pageContext.request.contextPath}/Login" method="post">
				<label for="fname">Username</label> <input type="text" id="username"
					class="input" name="username"
					placeholder="Email Id or Mobile Number..."> <label
					for="fname">Password</label> <input type="password" id="password"
					class="input" name="password" placeholder="Enter Password...">
				<input type="submit" value="Submit"> <a
					href="${pageContext.request.contextPath}/Register">Register
					Here</a>
			</form>
		</div>
	</div>
</body>
</html>
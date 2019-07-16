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

.button {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.button:hover {
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
			<form action="${pageContext.request.contextPath}/Register"
				method="post">
				<label for="fname">Username</label> <input type="text" id="username"
					class="input" name="username" placeholder="Enter Username...">
				<label for="fname">Password</label> <input type="password"
					id="password" class="input" name="password"
					placeholder="Enter Password..."> <label for="fname">Re
					Password</label> <input type="password" id="repassword" class="input"
					name="repassword" placeholder="Enter Password Again..."> <input
					type="submit" value="Submit" class="button" /><br> <a
					href="${pageContext.request.contextPath}/Login">Already
					Registered.. Click here to login</a>
			</form>
		</div>
	</div>
</body>
</html>
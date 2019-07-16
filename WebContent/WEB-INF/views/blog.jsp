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
			if (request.getAttribute("message") != null)
				out.println(request.getAttribute("message"));
		%>

		<div class="card">
			<form action="${pageContext.request.contextPath}/Blog" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${blogDetails.id}" name="id" />
				<label for="fname">Title</label> <input type="text" id="title"
					class="input" name="title" value="${blogDetails.title}" placeholder="Enter Title..."> 
					<label
					for="fname">Description</label> 
					<textarea type="text" id="description"
					class="input" name="description" value="${blogDetails.description}" placeholder="Enter Description..." rows="7">${blogDetails.description}</textarea>
					<label for="fname">Attachment</label> <input type="file" id="file"
					class="input" name="file" accept="image/*"/> 
					
					<input type="submit"
					value="Submit" class="button" />
			</form>
		</div>
	</div>
</body>
</html>
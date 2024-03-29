<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css">

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

	<!-- commandName refers to "offer" in the model in the controllers -->
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		commandName="offer">

		<!-- The "path" on each input text correspond to the property of Offer object in Offer.java -->
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td>
					<sf:input class="control" path="name" name="name"
						type="text" /><br> 
					<sf:errors cssClass="error" path="name"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td>
					<sf:input class="control" path="email" name="email"
						type="text" /><br>
					<sf:errors cssClass="error" path="email"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Your offer:</td>
				<td>
					<sf:textarea class="control" path="text" name="text"
						rows="10" cols="10"></sf:textarea><br>
					<sf:errors cssClass="error" path="text"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create advert" type="submit" /></td>
			</tr>
		</table>

	</sf:form>

</body>
</html>
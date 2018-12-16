<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Hibernate</title>
<style type="text/css">
fieldset {
	border: 1px solid #dedede;
}

legend {
	font-size: 20px;
	text-transform: uppercase;
}

.error {
	color: red;
}

.resltTable {
	width: 50%;
	border-collapse: collapse;
	border-spacing: 0px;
}

.resltTable td, .resltTable th {
	border: 1px solid #565454;
}
</style>
</head>

<body>
	<%-- <jsp:include page="jsp/fragments/header.jsp" /> --%>
	<fieldset>
		<legend>User Input From</legend>
		<form:form action="saveUser" method="post" modelAttribute="user">

			<table>
				<tr>
					<th>Name</th>
					<td><form:input path="name" /> <form:errors path="name"
							cssClass="error" /></td>
					<th>Address</th>
					<td><form:input path="address" /> <form:errors path="address"
							cssClass="error" /></td>
					<th>Email</th>
					<td><form:input path="email" /> <form:errors path="email"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="receivePaper">Subscribe Newsletter</form:label></td>
					<td><form:checkbox path="receivePaper" /></td>
				</tr>
				<tr>
	               <td><form:label path = "country">Country</form:label></td>
	               <td>
	                  <form:select path = "country">
	                     <form:option value = "NONE" label = "Select"/>
	                     <form:options items = "${countryList}" />
	                  </form:select>     	
	               </td>
	            </tr>  

				<tr>
					<td><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Users List</legend>
		<table class="resltTable">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>address</th>
				<th>Receive Paper</th>
				<th>Country</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td>${user.receivePaper}</td>
					<td>${user.country}</td>
				</tr>
			</c:forEach>

		</table>
	</fieldset>

	<%-- <jsp:include page="jsp/fragments/footer.jsp" /> --%>
</body>
</html>
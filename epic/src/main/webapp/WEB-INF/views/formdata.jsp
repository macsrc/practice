<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Form Input Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>

<body>
	<h1>Form Input Types</h1>

	<c:url var="addAction" value="/formdata/add"></c:url>

	<form:form action="${addAction}" commandName="formdata">
		<table>
			<c:if test="${!empty formdata.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="password" />
					</form:label></td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="confirmpassword">
						<spring:message text="confirmpassword" />
					</form:label></td>
				<td><form:password path="confirmpassword" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="Address" />
					</form:label></td>
				<td><form:textarea path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="newsletter">
						<spring:message text="Newsletter" />
					</form:label></td>
				<td><form:checkbox path="newsletter" value="0"/></td>
			</tr>
			<tr>
				<td><form:label path="country">
						<spring:message text="Country" />
					</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty formdata.name}">
						<input type="submit" value="<spring:message text="Edit Formdata"/>" />
					</c:if> <c:if test="${empty formdata.name}">
						<input type="submit" value="<spring:message text="Add Formdata"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Form Data List</h3>
	<c:if test="${!empty listFormdatas}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Name</th>
				<th width="120">Email</th>
				<th width="120">Address</th>
				<th width="120">Country</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listFormdatas}" var="formdata">
				<tr>
					<td>${formdata.id}</td>
					<td>${formdata.name}</td>
					<td>${formdata.email}</td>
					<td>${formdata.address}</td>
					<td>${formdata.country}</td>
					<td><a href="<c:url value='/fdedit/${formdata.id}' />">Edit</a></td>
					<td><a href="<c:url value='/fdremove/${formdata.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

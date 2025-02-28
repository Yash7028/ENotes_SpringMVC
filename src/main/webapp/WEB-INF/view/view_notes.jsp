<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container-fluid p-4">
		<h4 class="text-center">View All Notes</h4>
		<c:if test="${not empty msg }">
<p class="fs-3 fw-bold text-success text-center">${msg}</p>
<c:remove var="msg"/>
</c:if>
		<div class="row">
		<c:forEach items="${list}" var="n" >
			<div class="col-md-10 offset-md-1 mt-2">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<img alt="" src="<c:url value="/resources/img/notes2.png"/>"
								width="50px" height="50px">
						</div>
						<p>${n.title}</p>
						<p>${n.description}</p>
						<p>${n.date}</p>
						<div class="text-center">
							<a href="editNotes?id=${n.id}" class="btn btn-primary btn-sm">Edit</a> <a
								href="deleteNotes?id=${n.id}" class="btn btn-danger btn-sm">Delete</a>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
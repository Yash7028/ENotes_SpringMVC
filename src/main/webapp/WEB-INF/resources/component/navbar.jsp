
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#"><i class="fa-solid fa-book"></i>Notes</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home"><i
					class="fa-solid fa-house"></i>Home <span class="sr-only">(current)</span>
			</a></li>
			<c:if test="${not empty userObj }">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/addNotes">Add
						Notes</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/viewNotes">View
						Notes</a></li>
			</c:if>

		</ul>
		<form class="d-flex me-2">
			<c:if test="${empty userObj }">
				<a href="login" class="btn btn-light mr-sm-2" type="submit">Login</a>
				<a href="register" class="btn btn-light me-2" type="submit">Register</a>
			</c:if>
			<c:if test="${not empty userObj }">
				<a href="#" class="btn btn-light mr-sm-2" type="submit">${userObj.fullName}</a>
				<a href="${pageContext.request.contextPath}/user/logout" class="btn btn-light me-2" type="submit">Logout</a>
			</c:if>
		</form>

	</div>
</nav>
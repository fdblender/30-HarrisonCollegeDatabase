<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<p class="navbar-brand">HarrisonCollege</p>
		</div>
		<ul class="nav navbar-nav">			
			<li><a href="./ViewCourses">View Courses</a></li>
			<li><a href="./ViewClasses">View Classes</a></li>
			<c:if test="${user != null}">
				<li><a href="./Portal"><c:out value="${user.firstname}"/> <c:out value="${user.lastname}"/></a></li>
				<li><a href="./Logout">Logout</a></li>
				<li>                </li>
			</c:if>
				<c:if test="${user == null}">
				<li><a href="./login.jsp">Login</a></li>
			</c:if>			
		</ul>
	</div>
</nav>
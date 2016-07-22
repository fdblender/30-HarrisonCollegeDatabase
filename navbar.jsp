<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-default" background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUe-HAoajPGfWog8Yicp3VIj1hXncN7_j7a-zzyaZAg8uDV-E_Fw">>
	<div class="container-fluid">
		<div class="navbar-header">
			<p class="navbar-brand">HarrisonCollege</p>
		</div>
		<ul class="nav navbar-nav">
			<li><h1>Harrison College</h1></li>
			<li><a href="./ViewCourses">View Courses</a></li>
			<li><a href="./ViewClasses">View Classes</a></li>
			<c:if test="${user != null}">
				<li><a href="./Portal"><c:out value="${user.username}"/></a></li>
				<li><a href="./Logout">Logout</a></li>
				<li>                </li>
			</c:if>
				<c:if test="${user == null}">
				<li><a href="./login.jsp">Login</a></li>
			</c:if>			
		</ul>
	</div>
</nav>
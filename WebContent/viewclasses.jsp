<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Courses</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>	
	<div>
		<h2>
			<c:out value="Class Listing" />
		</h2>
	</div>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>					
					<th>Course Num</th>
					<th>Course Name</th>					
						<th>Subject</th>
					<th>Department</th>
					<th>Credits</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
						<td><c:out value="${course.coursenumber}" /></td>
						<td><c:out value="${course.coursename}" /></td>
						<td><c:out value="${course.subject}" /></td>						
						<td><c:out value="${course.department}" /></td>	
						<td><c:out value="${course.credits}" /></td>											
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>
					
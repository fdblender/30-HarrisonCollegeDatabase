<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Portal</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<h3>Student Portal</h3>
	<c:set var="user.firstname" value="${fn:trim(user.firstname)}" />
	<h4>Welcome, ${user.firstname}${user.lastname}</h4>
	<h4>Your email:${user.useremail}</h4>
	<br>

	<h4>Your Schedule of Classes</h4>
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>CRN</th>
				<th>Course Num</th>
				<th>Course Name</th>					
				<th>Credits</th>
				<th>Description</th>
				<th>Instructor</th>	
			</tr>
		</thead>
			<tbody>
				<c:forEach var="class" items="${classes}">
					<tr>
						<td><c:out value="${class.crn}" /></td>
						<td><c:out value="${class.hcours.coursename}" /></td>
						<td><c:out value="${class.hcours.credits}" /></td>						
						<td><c:out value="${class.description}" /></td>	
						<td><c:out value="${class.hinstructor.firstname"} ${class.hinstructor.lastname"}/></td>									
						<td><form action="DropClass" method="get">
							<input type="hidden" name="classid" id="classid" value="${class.classid}"/>
							<input type="submit" name="submit" id="submit" value="Drop Class"/>
							</form>						
							<form action="EmailInstructor" method="get">
							<input type="hidden" name="classid" id="classid" value="${class.classid}"/>
							<input type="submit" name="submit" id="submit" value="Email Instructor"/>
							</form>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>
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
	
	<h3>Welcome, Student ${user.firstname} ${user.lastname}</h3>
	<h4>Your email: ${user.useremail}</h4>
	<br>

	<h4>Your Schedule of Classes</h4>
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>CRN</th>
				<th>Course</th>	
				<th>Course Name</th>							
				<th>Credits</th>
				<th>Description</th>
				<th>Instructor</th>	
				<th>Actions</th>	
			</tr>
		</thead>
			<tbody>
				<c:forEach var="e" items="${enrollment}">
					<tr>
						<td><c:out value="${e.hclass.crn}" /></td>
						<td><c:out value="${e.hclass.hcours.coursenumber}" /> </td>
						<td><c:out value="${e.hclass.hcours.coursename}" /></td>
						<td><c:out value="${e.hclass.hcours.credits}" /></td>						
						<td><c:out value="${e.hclass.description}" /></td>	
						<td><c:out value="${e.hclass.huser.firstname}"/> <c:out value="${e.hclass.huser.lastname}"/></td>															
						<td><form action="DropClass" method="get">
							<input type="hidden" name="enrollmentid" id="enrollmentid" value="${e.enrollmentid}"/>
							<input type="submit" name="submit" id="submit" value="Drop Class"/>
							</form>						
							<form action="EmailInstructor" method="get">
							<input type="hidden" name="classid" id="classid" value="${e.hclass.classid}"/>
							<input type="submit" name="submit" id="submit" value="Email Instructor"/>
							</form>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
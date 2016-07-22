<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instructor Portal</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>	
	<h3>Welcome, Instructor ${user.firstname} ${user.lastname}</h3>
	<br>
	<h4>Your Class List</h4>	
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>CRN</th>
				<th>Course</th>								
				<th>Credits</th>
				<th>Description</th>
				<th>Instructor</th>	
				<th>Action</th>								
			</tr>
		</thead>
			<tbody>
				<c:forEach var="c" items="${classes}">
					<tr>
						<td><c:out value="${c.crn}" /></td>
						<td><c:out value="${c.hcours.coursenumber}" /> <c:out value="${c.hcours.coursename}" /></td>						
						<td><c:out value="${c.hcours.credits}" /></td>						
						<td><c:out value="${c.description}" /></td>	
						<td><c:out value="${c.huser.firstname}" /> <c:out value="${c.huser.lastname}" /></td>
						<td><form action="ViewRoster" method="get">
							<input type="hidden" name="classid" id="classid" value="${c.classid}"/>
							<input type="submit" name="submit" id="submit" value="View Roster"/>
							</form>	
						</td>							
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Roster</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<h2>Instructor Portal</h2>	
	<h3>Welcome, ${user.firstname} ${user.lastname}</h3>
	<br>
	<h4>Roster for CRN ${section.crn} ${section.hcours.coursename} ${section.description}</h4>	
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>Student</th>
				<th>Grade</th>					
			</tr>
		</thead>
			<tbody>
				<c:forEach var="student" items="${enrollment}">
					<tr>
						<td><c:out value="${student.huser.firstname} ${student.huser.lastname}" /></td>
						<td><form action="EditGrade" method="get">
						<input type="hidden" name="classid" id="classid" value="${section.classid}"/>							
							<input type="hidden" name="enrollmentid" id="enrollmentid" value="${student.enrollmentid}"/>
							<input type ="text" name="grade" id="grade" size="2" value="${student.grade}"/>
							<input type="submit" name="submit" id="submit" value="Edit"/>
							</form>													
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>
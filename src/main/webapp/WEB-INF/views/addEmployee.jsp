<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<br>
<form:form action="saveEmployee" method="post"
	modelAttribute="employeeRequest">
	<table>
		<tr>
			<td>Emp no</td>
			<td><form:input path="empno" /></td>
		</tr>

		<tr>
			<td>Emp Name</td>
			<td><form:input path="ename" /></td>
		</tr>

		<tr>
			<td>Emp sal</td>
			<td><form:input path="sal" /></td>
		</tr>

		<tr>
			<td>Dept No</td>
			<td><form:input path="deptno" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="submit" /></td>
		</tr>
	</table>
	<hr>
	<a href="logout"> Logout </a>
</form:form>
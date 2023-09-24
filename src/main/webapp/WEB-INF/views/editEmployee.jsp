<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="updateEmployee" modelAttribute="emp" method="post">
	<table>
		<tr>
			<td>empno</td>
			<td><form:input path="empno" /></td>
		</tr>
		<tr>
			<td>emp name</td>
			<td><form:input path="ename" /></td>
		</tr>
		<tr>
			<td>sal</td>
			<td><form:input path="sal" /></td>
		</tr>
		<tr>
			<td>dept no</td>
			<td><form:input path="deptno" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="submit" /></td>
		</tr>
	</table>

</form:form>
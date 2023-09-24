<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="addEmployee"
	style="font-size: 30px; background-color: DodgerBlue; color: white; padding: 14px 25px; text-align: center; text-decoration: none; display: inline-block;">add
	more employees</a>
<hr>
<h3 style="text-align: center; color: blue">List of Employees</h3>
<table border="1"
	style="margin-left: 200px; margin-right: 200px; border-collapse: collapse; margin: 20px 0; font-size: 0.9em; font-family: sans-serif; width: 100%; box-shadow: 0 0 20px rgba(0, 0, 0, 0.15)">
	<tbody style="text-align: center">
		<tr style="padding: 3px 3px; background-color: MediumSeaGreen">
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>SAL</th>
			<th>DEPTNO</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<c:if test="${!empty employees}">

			<c:forEach items="${employees}" var="emp">
				<tr>
					<td><c:out value="${emp.empno}" /></td>
					<td><c:out value="${emp.ename}" /></td>
					<td><c:out value="${emp.sal}" /></td>
					<td><c:out value="${emp.deptno}" /></td>
					<td><a href="editEmployee?id=${emp.empno}"><img
							style="border-radius: 50%" src="images/image_edit.png"
							height="40px" width="40px"> </a></td>

					<td><a href="deleteEmployee?id=${emp.empno}"><img
							src="images/image_delete.png" height="40px" width="40px"> </a></td>

				</tr>

			</c:forEach>
		</c:if>
	</tbody>
</table>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
a:link, a:visited {
  background-color: DodgerBlue;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: blue;
}
</style>
</head>
<c:if test="${message ne null}">
	<c:out value="${message}" />
</c:if>
<hr>
 1.
<a href="addEmployee"> add employee </a>
<br>
<br>
 2.
<a href="listEmployees"> list employees </a>

</html>
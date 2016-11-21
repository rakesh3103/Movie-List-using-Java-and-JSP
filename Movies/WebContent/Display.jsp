<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.java.Movies.MovieDataBean" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
    background-color: lightblue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
</head>
<body>




<%-- <%for(int i =0 ; i<v.size(); i++){%>

${v.get(i).getTitle() }
${v.get(i).getYear() }
${v.get(i).getIMDB_Rating() }


<%} %> --%>
<form action="WebClass" method="get">
<br>Enter Movie name: <input autofocus="autofocus" type="text" name="movie">
<br><input   type="checkbox" name="Action" value="true">Check if you have watched this movie.

<br><input type="submit">
</form>

</body>
</html>
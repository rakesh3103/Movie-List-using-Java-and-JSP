<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.java.Movies.MovieDataBean" import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Movies Display</title>
</head>
<body>

<%String title = (String)request.getAttribute("title");%>
<%String year = (String)request.getAttribute("year");%>
<%String IMDB_rating = (String)request.getAttribute("IMDB_rating");%>

<br>


<%ArrayList<MovieDataBean> w = (ArrayList<MovieDataBean>)request.getAttribute("WatchedMovieArray");%>
<%ArrayList<MovieDataBean> unw = (ArrayList<MovieDataBean>)request.getAttribute("unWatchedArray");%>

<h1 id="demo" onmouseover="myFunction()">Watched Movies</h1>


<div class="watched" style="overflow-x:auto;">
<a href="/Movies/EditMovies"> Click here to Edit Movies</a>
<table cellspacing="20">
<tr>
<td><h3>Title</h3></td>
<td><h3>Year</h3></td>
<td><h3>IMDB rating</h3></td>
<td><h3>Poster</h3></td>
</tr>
<%int watchedruntime =0;
int unwatchedruntime = 0;
%>

<%for(int i =0 ; i<w.size(); i++){%>
<tr>
<td><div class ="dropdown"><a href="https://www.google.com/search?newwindow=1&safe=off&q=<%=w.get(i).getMovie().substring(1) %>"target="_blank"><%=w.get(i).getMovie().substring(1) %></a>

<div class="dropdown-content">
<p><%=w.get(i).getPlot() %></p>
</div>
</div>
</td>
<td><%=w.get(i).getYear() %></td>
<td><a href="https://www.imdb.com/title/<%=w.get(i).getImdbID() %>"target="_blank"><%=w.get(i).getIMDB_Rating() %></a></td>
<td><img src ="<%=w.get(i).getPoster() %>"title="poster"alt="Movie Poster" style="width:100px;height:120px;"></td>


</tr>


<%watchedruntime = (watchedruntime + Integer.parseInt(w.get(i).getRuntime().substring(0, 3).trim())); %>



<%} %>
</table>
<br>
You have <%=w.size() %> movies in your Watched list.
You have seen over <%=watchedruntime/60 %> hours of movies.
</div>
<br>
<br>
<h1>UnWatched Movies</h1>
<div class="unwatched" style="overflow-x:auto;">
<table cellspacing="20">
<tr>
<td><h3>Title</h3></td>
<td><h3>Year</h3></td>
<td><h3>IMDB rating</h3></td>
<td><h3>Release Date</h3></td>
<td><h3>Poster</h3></td>
</tr>
<%for(int i =0 ; i<unw.size(); i++){%>
<tr>
<td><div class ="dropdown"><a href="https://www.google.com/search?newwindow=1&safe=off&q=<%=unw.get(i).getMovie() %>"target="_blank"><%=unw.get(i).getMovie() %></a>
<div class="dropdown-content">
<p><%=unw.get(i).getPlot() %></p>
</div>
</div>

</td>

<td><%=unw.get(i).getYear() %></td>
<td><a href="https://www.imdb.com/title/<%=unw.get(i).getImdbID()%>" target="_blank"><%=unw.get(i).getIMDB_Rating() %></a></td>
<td><p id="releaseDate[<%=i %>]" onmouseover="myDateCheck()"  ><%=unw.get(i).getRelease_date() %></p></td>
<td><img src ="<%=unw.get(i).getPoster() %>" alt="Movie Poster" title="poster"style="width:100px;height:120px;"></td>
<td><div class = "img"><a href="https://www.torrentz.eu/search?q=<%=unw.get(i).getMovie() %>"target="_blank">
<img src = "resources/torrentimage.jpg"title="Search Torrent" alt="Search Torrent"style="width:100px;height:120px;">
</a>

</div>
</td>
</tr>


<%unwatchedruntime = (unwatchedruntime + Integer.parseInt(unw.get(i).getRuntime().substring(0, 3).trim())); %>


<%} %>
</table>
<p id="totalunmovies" hidden="true"><%=unw.size() %></p>

You have <%=unw.size() %> movies to watch.
You have over <%=unwatchedruntime/60 %> hours of movies to watch.
</div>

<form action="WebClass" method="get">

<br>Enter Movie name to add to list: <input placeholder="Movie name" required="required" type="text" name="movie">

<br><input type="checkbox" name="Action" value="true">Check if you have watched this movie.

<br><input type="submit">
</form>

&copy;2016 Rakesh
<script src="myScript.js"></script>
</body>
</html>
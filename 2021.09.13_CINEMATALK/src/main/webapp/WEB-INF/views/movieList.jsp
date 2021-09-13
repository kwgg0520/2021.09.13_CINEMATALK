<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/movie/resources/css/movieList.css">
</head>
<body>
    <center>
        <form action="movieList.do">
            <input type="text" name="keyword" >
            <input type="submit" value="검색">
        </form>
        
    </center>
    <table>
        <tr>
            <td colspan="7" width="100%" bgcolor="pink"></td>
        </tr>
        <c:forEach items="${movieList}" var ="b">
            <tr>
                <td id="image" rowspan="2"><img src="${b.image}" alt="포스터 없음"></td>
                <td id="title">${b.title}</td>
                <td width="200">${b.director}</td>
                <td colspan="7">${b.userRating}</td>
                
            </tr>
            <tr>
                <td width="200">${b.subtitle }</td>
                <td width="200">
					<c:forEach var="item" items="${b.actorList}">
						${item }<br>
					</c:forEach>
				</td>
                <td width="200">${b.pubDate }</td>
            </tr>
            <tr>
                <td colspan="7" width="100%" bgcolor="pink"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
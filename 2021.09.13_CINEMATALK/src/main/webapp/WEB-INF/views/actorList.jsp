<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/movie/resources/css/actorList.css">
</head>
<body>
    <center>
        <form action="actorList.do">
            <input type="text" name="keyword" >
            <input type="submit" value="검색">
        </form>
        
    </center>
    <table>
        <tr>
            <td colspan="7" width="100%" bgcolor="pink"></td>
        </tr>
            <tr>
                <td id="thumbnail" rowspan="2"><img src="${actor}" alt="사진 없음"></td>
                        
            </tr>
            <tr>
                <td colspan="7" width="100%" bgcolor="pink"></td>
            </tr>
    </table>
</body>
</html>
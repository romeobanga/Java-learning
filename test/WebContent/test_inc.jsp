<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%
	ArrayList<Integer> liste = new ArrayList<Integer>();
	liste.add( 12 );
	out.println( liste.get( 0 ) );
%>
</p>
</body>
</html>
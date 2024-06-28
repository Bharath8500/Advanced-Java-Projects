<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String pCode = request.getParameter("pcode");
String pName = request.getParameter("pname");
float pPrice = Float.parseFloat(request.getParameter("pprice"));
float qty = Float.parseFloat(request.getParameter("pqty"));
out.println("code: "+pCode);
out.println("<br>Name: "+pName);
out.println("<br>Price: "+pPrice);
out.println("<br>Qty: "+qty);
%>

</body>
</html>
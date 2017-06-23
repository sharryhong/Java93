<%-- JSP 구성요소
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시(directive) 엘리먼트
4) 표현식(expresstion) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그 
7) JSP 확장 태그(JSTL)
8) EL(Expresstion Language)
9) JSP 주석
--%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html">
<html>
<head>
  <meta charset=UTF-8">
  <title>JSP</title>
</head>
<body>
<h1>JSTL - c:parseDate 태그 사용법</h1>

<fmt:parseDate value="2017-06-16" pattern="yyyy-MM-dd" var="date1"/>
<fmt:parseDate value="06/17/2017" pattern="MM/dd/yyyy" var="date2"/>
<%
  java.util.Date date2 = (java.util.Date)pageContext.getAttribute("date1");
  out.println(date2);
  out.println("<br>");
  java.util.Date date4 = (java.util.Date)pageContext.getAttribute("date2");
  out.println(date4);
%>
</body>
</html>

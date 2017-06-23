<%-- JSP 구성요소
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시어(directive) 엘리먼트
4) 표현식(expresstion) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그 
7) JSP 확장 태그(JSTL)
8) EL(Expresstion Language)
9) JSP 주석
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html">
<html>
<head>
<%
int i = 20;
int j = 30;
%>
  <meta charset=UTF-8">
  <title>JSP</title>
</head>
<body>
<!-- html 주석도 템플릿 데이터이다. -->
<h1>스크립트릿(scriptlet) 엘리먼트</h1>
<% 
out.write("=>" + i * j);
%>
</body>
</html>
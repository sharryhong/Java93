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
<!DOCTYPE html">
<html>
<head>
  <meta charset=UTF-8">
  <title>JSP</title>
</head>
<body>
<h1>EL - 배열에서 값꺼내기</h1>
<% pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","유관순"}); %>
\${pageScope.names[0]}: ${pageScope.names[0]}<br>
\${pageScope.names[1]}: ${pageScope.names[1]}<br>
\${pageScope.names[2]}: ${pageScope.names[2]}<br>

<h1>EL - 목록맵에서 값꺼내기</h1>
<h1>EL - 맵에서 값꺼내기</h1>




</body>
</html>

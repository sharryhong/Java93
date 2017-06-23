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
<%@page import="java.util.HashMap"%>
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
<h1>EL - 조건 연산자 사용법</h1>

<c:set var="name" value="홍길동"/>
<c:set var="age" value="20"/>

\${name == "홍길동" ? "핫" : "뉘신지" }:
${name == "홍길동" ? "핫" : "뉘신지" }<br>

\${age < 19 ? "미성년" : "성년" }:
${age < 19 ? "미성년" : "성년" }<br>

</body>
</html>

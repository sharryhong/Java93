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
<h1>EL - List(컬렉션)에서 값꺼내기</h1>
<%
ArrayList<String> list = new ArrayList<>();
list.add("홍길동");
list.add("임꺽정");
list.add("유관순");
list.add("안중근");
list.add("윤봉길");
pageContext.setAttribute("list", list);
%>
${list[0]}<br>
${list[1]}<br>
${list[2]}<br>
${list[3]}<br>


</body>
</html>

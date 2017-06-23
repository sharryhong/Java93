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
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html">
<html>
<head>
  <meta charset=UTF-8">
  <title>JSP</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:include</h1>
<jsp:include page="c.jsp">
  <jsp:param name="name" value="홍길동"/>
  <jsp:param name="age" value="20"/>
</jsp:include>
</body>
</html>

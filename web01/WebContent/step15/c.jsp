<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<% request.setCharacterEncoding("UTF-8"); %>
<p>
이름: <%=request.getParameter("name")%><br>
나이: ${param.age}<br>
</p>
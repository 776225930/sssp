
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form:form action="${pageContext}/emp" method="POST" modelAttribute="employee">
       LastName:<form:input path="lastName"/>
       <br>
       Email:<form:input path="email"/>
       <br>
       Birth:<form:input path="birth"/>
       <br>
       CreateTime:<form:input path="createTime"/>
       <br>
       Department:<form:select path="department.id" itemLabel="departmentName" items="${departments}" itemValue="id" ></form:select>
       <br>
       <br>
       <input type="submit" value="Submit">
    </form:form>
</body>
</html>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户管理--客户列表</title>
</head>
<body>
    <h1>客户列表界面</h1>

    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>contact</td>
            <td>email</td>
            <td>telephone</td>
            <td>操作</td>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.contact}</td>
                <td>${customer.email}</td>
                <td>${customer.telephone}</td>
                <td>操作</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
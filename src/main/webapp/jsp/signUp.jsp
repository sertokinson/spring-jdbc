<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ������
  Date: 10.10.2018
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=Cp1251" %>
<html>
<head>
    <title>SignUp</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="signUp">
    <form method="post">
        <h2>�����������</h2>
        <p type="���:"><input class="input" type="text" id="name" name="name"/></p>
        <p type="���� ��������:"><input class="input" type="text" id="birthDate" name="birthDate"/></p>
        <p type="������:"><input class="input" type="password" id="password" name="password"/></p>
        <button>������������������!</button>
    </form>
</div>
</body>
</html>

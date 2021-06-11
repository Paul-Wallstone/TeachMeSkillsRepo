<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 25.05.2021
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post" action="calc">
    <h2> <p><i><b>Calculator:</b></i></p></h2>
    <b>Operator1:</b> <input type="text" name="oper1" size="10" maxlength="10"/> <br/>
    <b>Operator2:</b> <input type="text" name="oper2" size="10" maxlength="10"/> <br/>
    <p><b> Result: <i>${result}</i> </b></p>
    <input type="submit" name="action" value="sum">
    <input type="submit" name="action" value="sub">
    <input type="submit" name="action" value="mult">
    <input type="submit" name="action" value="div"> <br/>

</form>
</body>
</html>


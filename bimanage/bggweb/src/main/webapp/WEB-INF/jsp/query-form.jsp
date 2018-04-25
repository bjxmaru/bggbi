<%--
  Created by IntelliJ IDEA.
  User: bjx
  Date: 2018/4/13
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello , jsp  测试


<form id="paraVO" style="display: block;" method="post" action="http://localhost:8080/bggweb/jasper/a.action">
    <input type="text" name="para.paraDate"  value="para.paraDate">
    <input type="text" name="para.paraCorpCode" value="para.paraCorpCode">
    <input type="text" name="jasperUncompiledFilePath" value="" >
    <input type="text" name="jasperCompiledFilePath" value="" >
    <input type="text" name="funcCode" value="" >

    <input type="submit" >
</form>
<script>
    var para = {
        paraCorpCode:"1001" ,
        paraDate : "2018-04-16 13:23:12"
    };


</script>
</body>
</html>

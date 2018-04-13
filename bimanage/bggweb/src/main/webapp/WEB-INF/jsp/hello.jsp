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


<form id="paraVO" style="display: none;" method="post" action="http://localhost:8080/bggweb/jasper/corpInfo.action">
    <input type="text" name="para.paraYear">
    <input type="text" name="para.paraMonth">
    <input type="text" name="para.paraDay">
    <input type="text" name="para.paraCorpCode">
    <input type="submit" >
</form>
<script>
    var para = {
        paraYear:"2018" ,
        paraMonth:"01" ,
        paraDay: "02" ,
        paraCorpCode:"1001"
    };


</script>
</body>
</html>

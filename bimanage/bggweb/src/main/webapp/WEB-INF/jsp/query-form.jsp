<%@ taglib prefix="s" uri="/struts-tags" %>
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


<form id="paraVO" style="display: block;" method="post" action="http://localhost:8080/bggweb/jasper/jasper_index.action">
    <input type="text" name="jasperQueryVO.jasperreportsParameter.qDateStr"  value="para.paraDate">
    <input type="text" name="jasperQueryVO.jasperreportsParameter.qOrgCode" value="para.paraCorpCode">
    <input type="text" name="jasperQueryVO.jasperUncompiledFilePath" value="" >
    <input type="text" name="jasperQueryVO.jasperCompiledFilePath" value="" >
    <input type="text" name="jasperQueryVO.funcCode" value="" >

    <input type="submit" >
</form>


<div>
  <s:debug></s:debug>
</div>
<script>
    var para = {
        paraCorpCode:"1001" ,
        paraDate : "2018-04-16 13:23:12"
    };


</script>
</body>
</html>

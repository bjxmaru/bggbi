<%--
  Created by IntelliJ IDEA.
  User: bjx
  Date: 2018/4/22
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<html>
<head>
    <title>font.jsp</title>
</head>
<body>
    <div>
        <p>
            测试开始<s:property value="realPath" />
        </p>
    </div>


    <br/>

    <s:debug></s:debug>

    <jsp:include page="query-form.jsp"/>


</body>
</html>

<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
</head>
<body>
<center>
    <form:form modelAttribute="page" method="post" action="index_list" id="form">
        <table id="myDiv">
            <tr>
            <td>问题序号</td>
            <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td>问题内容</td>
                <td><form:input path="content" /></td>
            </tr>
            <tr>
                <td>选项1</td>
                <td><form:input path="optiona"/></td>
            </tr>
            <tr>
                <td>选项2</td>
                <td><form:input path="optionb"/></td>
            </tr>
            <tr>
                <td>选项3</td>
                <td><form:input path="optionc"/></td>
            </tr>
            <tr>
                <td>选项4</td>
                <td><form:input path="optiond"/></td>
            </tr>
            <tr>
                <td>挑一个结果写进去</td>
                <td><input type="text" name="jj" id="sss"/>
            </tr>
            <tr>
                <td>
                    <input type="button" value="上一题" onclick="next(${page.id-1},${page.trueoption})"/>
                </td>
                <td>
                    <input type="button" value="下一题" onclick="next(${page.id+1},${page.trueoption})"/>
                </td>
            </tr>
        </table>
        <!--
        <input type="button" value="上一题" onclick="previous()"/>
        <input type="button" value="下一题" onclick="next()"/>
        -->
        <!--
        <li><a href="${ctx}/index_list?problemId=${page.id+1}&&rightOption=${page.trueoption}&&ghf=<%=request.getParameter("jj") %>">下一题 »</a></li>
        <li><a href="${ctx}/index_list?problemId=${page.id-1}&&rightOption=${page.trueoption}&&ghf=<%=request.getParameter("jj") %>">上一题 »</a></li>
        -->
</form:form>
</center>
<script type="text/javascript" src="${ctx}/js/jquery-3.2.1.min.js"></script>
<script>
    function previous() {
        alert("上一题")
        $("#form").submit();
    }
    function next(id,right) {
        var onSiz = $("#sss").val();
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function (ev) {
            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST","${ctx}/index_list?problemId="+id+"&&rightOption="+right+"&&ghf="+onSiz,true);
        xmlhttp.send();
    }
    
</script>
</body>
</html>

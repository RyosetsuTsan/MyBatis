<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程表</title>
</head>
<body>
<h1>课程表</h1>
<table border="1">
    <form method="post" action="index?do=select">
        <label>课程名称 <input type="text" value="" name="name"></label>
        <label>开课时间 <input type="date" value="" name="startdate"></label>
        <label>结束时间 <input type="date" value="" name="enddate"></label>
        <label>教师姓名 <input type="text" value="" name="teacher"></label>
        <input type="submit" value="查询">
    </form>
    <tr>
        <th>编号</th>
        <th>课程名</th>
        <th>课程数</th>
        <th>开课时间</th>
        <th>结课时间</th>
        <th>教学老师</th>
    </tr>
    <!-- 多行删除方法1 form表单传递 -->
    <form method="post" action="index?do=delete">

    <c:forEach items="${courses }" var="k">
        <tr>
            <td>
                <input type="checkbox" name="id" value="${k.id}">
                <%--${k.id}--%>
            </td>
            <td>${k.name}</td>
            <td>${k.count}</td>
            <td>${k.startdate}</td>
            <td>${k.enddate}</td>
            <td>${k.teacher}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">一共 ${fn:length(courses)}门课程</td>
        <td colspan="3">
            <!-- 多行删除方法1 form表单传递 -->
            <input type="submit" value="多行删除1">

            <!-- 多行删除方法2 js函数获取checked -->
            <input type="button" id="delete" value="多行删除2">
        </td>
    </tr>
    </form>


    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("#delete").click(function () {
                //按钮点击后
                str="";
                $(":checked").each(function () {
                    str+= $(this).val()+",";
                });
                location.href="index?do=delete2&str="+str;
            });
        });
    </script>
</table>
</body>
</html>
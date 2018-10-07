<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/stu/register.action">
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name" placeholder="请输入您的姓名！"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="pwd" placeholder="请输入您的密码！"></td>
            </tr>
            <%--<tr>--%>
                <%--<td>年龄</td>--%>
                <%--<td><input type="text" name="age" placeholder="请输入您的年龄！"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>性别</td>--%>
                <%--<td><input type="text" name="sex" placeholder="请输入您的性别！"></td>--%>
            <%--</tr>--%>
            <tr>
                <td><input type="submit" value="注册"></td>
            </tr>

        </table>
    </form>
</body>
</html>


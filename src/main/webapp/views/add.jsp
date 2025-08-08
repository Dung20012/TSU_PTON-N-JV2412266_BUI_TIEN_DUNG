<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="advertisingStrategy" action="/adv/save">
    <table>
        <tr>
            <td>Tên quản lý:</td>
            <td><form:input path="managerName"/></td>
            <td class="error"><form:errors path="managerPhone"/></td>
        </tr>
        <tr>
            <td>SĐT quản lý:</td>
            <td><form:input path="managerPhone"/></td>
            <td class="error"><form:errors path="managerPhone"/></td>
        </tr>
        <tr>
            <td>Tên NV:</td>
            <td><form:input path="staffName"/></td>
            <td class="error"><form:errors path="staffName"/></td>
        </tr>
        <tr>
            <td>SĐT nhân viên:</td>
            <td><form:input path="staffPhone"/></td>
            <td class="error"><form:errors path="staffPhone"/></td>
        </tr>
        <tr>
            <td>Ngày thực hiện:</td>
            <td><form:input path="implementDate" type="date"/></td>
            <td class="error"><form:errors path="implementDate"/></td>
        </tr>
        <tr>
            <td>Ngày thời lượng:</td>
            <td><form:input path="dayDuration" /> </td>
            <td class="error"><form:errors path="dayDuration"/></td>
        </tr>
        <tr>
            <td>Ảnh:</td>
            <td><form:input path="implementDate"/> </td>
            <td class="error"><form:errors path="implementDate"/></td>
        </tr>
        <tr>
            <td>Nội dung:</td>
            <td><form:input path="content"/> </td>
            <td class="error"><form:errors path="implementDate"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Lưu</button>
                <a href="/adv">Hủy</a>
            </td>
        </tr>
    </table>
</form:form>

<a href="/adv">Quay lại</a>
</body>
</html>

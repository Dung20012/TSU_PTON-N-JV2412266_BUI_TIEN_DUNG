<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Danh sách</title>
  </head>
  <body>
  <a href="/adv/create">Thêm mới</a>
  <br> <br>
  <form action="/adv" method="get">
    <input type="text" name="keyword" placeholder="Tìm kiếm theo tên..." />
    <button type="submit">Tìm</button>
  </form>

  <table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
      <th>ID</th>
      <th>Tên quản lý</th>
      <th>SĐT quản lý</th>
      <th>Tên nhân viên</th>
      <th>SĐT nhân viên</th>
      <th>Ngày thực hiện</th>
      <th>Ngày thời lượng</th>
      <th>Ảnh</th>
      <th>Nội dung</th>
      <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${adv}">
      <tr>
        <td>${a.id}</td>
        <td>${a.managerName}</td>
        <td>${a.managerPhone}</td>
        <td>${a.staffName}</td>
        <td>${a.managerPhone}</td>
        <td>${a.implementDate}</td>
        <td>${a.dayDuration}</td>
        <td>${a.imageUrl}</td>
        <td>${a.content}</td>
        <td>
          <a href="/adv/edit/${a.id}">Sửa</a> |
          <a href="/adv/delete/${a.id}" onclick="return confirm('Xóa sản phẩm này?')">Xóa</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <!-- Phân trang -->
  <div>
    <c:forEach begin="1" end="${totalPage}" var="i">
      <a href="/adv?page=${i}">${i}</a>
    </c:forEach>
  </div>
  </body>
</html>

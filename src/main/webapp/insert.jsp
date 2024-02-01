<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student and Laptop Form</title>
</head>
<body>
    <div align="center">
        <form action="${pageContext.request.contextPath}/add" method="post">            
            <label>Name:</label>
            <input type="text" name="sname" required placeholder="Student Name" />
            
            <label>Laptop Brand:</label>
            <input type="text" name="brand" required placeholder="Laptop Brand" />
            
            <label>Laptop Model:</label>
            <input type="text" name="model" required placeholder="Laptop Model" />
            
            <input type="submit" value="Submit" name="button" />
        </form>
        
        <br><br><br>
        
        <table border="1" width="50%" style="text-align: center;">
            <caption>
                <h2>List of Students</h2>
            </caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Laptop Brand</th>
                <th>Laptop Model</th>
                <th>Action</th>
            </tr>
            
            <c:forEach items="${list}" var="student">
                <tr>
                    <td><c:out value="${student.sid}" /></td>
                    <td><c:out value="${student.sname}" /></td>
                    <td><c:out value="${student.laptops[0].brand}" /></td>
                    <td><c:out value="${student.laptops[0].model}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit?id=${student.sid}">Edit</a>
                        /
                        <a href="${pageContext.request.contextPath}/delete?id=${student.sid}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br><br><br>

        <c:if test="${not empty studentDetail}">
            <form action="${pageContext.request.contextPath}/update" method="post">
                <input type="hidden" name="id" value="${studentDetail.sid}" />
                <label>Edit Name:</label>
                <input type="text" name="sname" required placeholder="Student Name" value="${studentDetail.sname}" />
                
                <label>Edit Laptop Brand:</label>
                <input type="text" name="brand" required placeholder="Laptop Brand" value="${studentDetail.laptops[0].brand}" />
                
                <label>Edit Laptop Model:</label>
                <input type="text" name="model" required placeholder="Laptop Model" value="${studentDetail.laptops[0].model}" />
                
                <input type="submit" value="Update" name="button" />
            </form>
        </c:if>
    </div>
</body>
</html>

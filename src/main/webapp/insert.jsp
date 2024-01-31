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
            </tr>
            
            <c:forEach items="${list}" var="student">
                <tr>
                    <td><c:out value="${student.sid}" /></td>
                    <td><c:out value="${student.sname}" /></td>
                    <td><c:out value="${student.laptops[0].brand}" /></td>
                    <td><c:out value="${student.laptops[0].model}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student and Laptop Form</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            text-align: center;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
        }
    </style>
</head>
<body>
    <div align="center">
        <c:if test="${studentDetail == null }">
            <form action="${pageContext.request.contextPath}/add" method="post">
        </c:if>
        <c:if test="${studentDetail != null }">
            <form action="${pageContext.request.contextPath }/update?id=${studentDetail.sid}" method="post">
        </c:if>
            <table>
                <caption>
                    <h3>Enter Student Details</h3>
                </caption>
                <tr>
                    <td align="right">Name:</td>
                    <td><input type="text" name="sname" required placeholder="Student Name" value="${studentDetail.sname}"/></td>
                </tr>
                <tr>
                    <td align="right">Laptop Brand:</td>
                    <td><input type="text" name="brand" required placeholder="Laptop Brand" value="${studentDetail.laptops[0].brand}"/></td>
                </tr>
                <tr>
                    <td align="right">Laptop Model:</td>
                    <td><input type="text" name="model" required placeholder="Model" value="${studentDetail.laptops[0].model}"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" name="button" /></td>
                </tr>
            </table>
        </form>

        <br><br><br>

        <c:if test="${studentDetail == null }">
            <table>
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
        </c:if>
    </div>
</body>
</html>

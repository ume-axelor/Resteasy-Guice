<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laptop Features</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align: center;
            margin: 20px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            text-align: center;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
        }

        caption {
            font-size: 1.5em;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div>
        <!-- Laptop Features Table -->
        <table>
            <caption>Laptop Features</caption>
            <tr>
                <th>Laptop ID</th>
                <th>Laptop Brand</th>
                <th>Laptop Model</th>
                <th>Feature Name</th>
                <th>Feature Description</th>
            </tr>
            
            <c:forEach items="${laptopFeatures}" var="laptopFeature">
                <tr>
                    <td><c:out value="${laptopFeature.laptop.id}" /></td>
                    <td><c:out value="${laptopFeature.laptop.brand}" /></td>
                    <td><c:out value="${laptopFeature.laptop.model}" /></td>
                    <td><c:out value="${laptopFeature.feature.name}" /></td>
                    <td><c:out value="${laptopFeature.feature.description}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

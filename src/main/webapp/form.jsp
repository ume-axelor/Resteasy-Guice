<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data Display Form</title>
</head>
<body>
    <h2>Inserted Data:</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Field 1</th>
                <th>Field 2</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${entries}">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.field1}</td>
                    <td>${entry.field2}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

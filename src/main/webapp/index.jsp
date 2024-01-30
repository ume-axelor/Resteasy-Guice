<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data Insert Form</title>
</head>
<body>
    <form action="/hello/insertData" method="post" enctype="application/json">
        <label for="field1">Field 1:</label>
        <input type="text" id="field1" name="field1" required>
        <br>
        <label for="field2">Field 2:</label>
        <input type="text" id="field2" name="field2" required>
        <br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>

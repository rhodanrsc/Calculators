
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post">
            <label>First:</label>
            <input type="text" name="first_in" value="${firstIn}">
            <br>
            <label>Second:</label>
            <input type="text" name="second_in" value="${secondIn}">
            <br>
            <input type="submit" name="plus" value="+">
            <input type="submit" name="minus" value="-">
            <input type="submit" name="times" value="*">
            <input type="submit" name="remain" value="%">
            <br>
            <p>Result: ${result}</p>
            
            <a href="age">Age Calculator</a>
        </form>
    </body>
</html>

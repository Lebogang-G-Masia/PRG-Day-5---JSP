<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/validation.js"></script>
        <title>Student Registration App</title>
    </head>
    <body>
        <div class="container">
            <h1>Student Registration</h1>
            <form name="studentForm" action="studentServlet" method="post" onsubmit="return validateForm();">
                <label>First Name</label>
                <input type="text" name="firstname">
                <label>Last Name</label>
                <input type="text" name="lastname">
                <label>Email</label>
                <input type="text" name="email">
                <label>Phone</label>
                <input type="text" name="phone">
                <label>Course</label>
                <select name="firstname">
                    <option>Computer Science</option>
                    <option>Programming</option>
                </select>
            </form>
            <button type="submit">Submit</button>
            </p>
        </div>
    </body>
</html>

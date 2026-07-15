<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Student Registration App</title>
    </head>
    <body>
        <div class="container">
            <h1>Students</h1>
            <table>
                <tr>
                    <th>Student ID</th><th>Name</th>
                    <th>Surname</th><th>Email</th>
                    <th>Phone</th><th>Course</th>
                    

                </tr>
                    <%
                        List<Student> st = (List<Student>) request.getAttribute("students");
                        for (Student s: st) {
                    %>
                    <tr>
                        <td><%=s.getStudentID()%></td>
                        <td><%=s.getFirstName()%></td>
                        <td><%=s.getLastName()%></td>
                        <td><%=s.getEmail()%></td>
                        <td><%=s.getPhone()%></td>
                        <td><%=s.getCourse()%></td>
                    </tr>
                    <%
                        }
                    %>
            </table>
        </div>
    </body>
</html>

<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Welcome, <%= session.getAttribute("user") %></h2>

<a href="addEmployee.jsp">Add Employee</a><br><br>
<a href="logout">Logout</a>

</body>
</html>

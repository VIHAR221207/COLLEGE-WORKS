<html>
<body>
    <h2>Welcome <%= request.getAttribute("username") %></h2>
    <p>Login successful.</p>
    <a href="login.jsp">Logout</a>
</body>
</html>

<%--
  HOW TO RUN:
  Not opened directly. Shown by LoginServlet after a valid login (admin / password).
--%>

<html>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>

<%--
  HOW TO RUN:
  Run via Tomcat 9 (see LoginServlet.java for full steps).
  Open http://localhost:8080/myapp/login.jsp
--%>

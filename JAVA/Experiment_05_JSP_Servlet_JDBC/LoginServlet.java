package com.example;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        boolean valid = false;

        // simple check so it works without a database
        if (user.equals("admin") && pass.equals("password")) {
            valid = true;
        } else {
            // check in MySQL database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/testdb", "root", "password");
                PreparedStatement ps = con.prepareStatement(
                        "select * from users where username=? and password=?");
                ps.setString(1, user);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    valid = true;
                }
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (valid) {
            request.setAttribute("username", user);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

/*
 * HOW TO RUN:
 * SERVER NEEDED: Apache Tomcat 9.
 * 1. Folder layout: myapp/login.jsp, welcome.jsp, error.jsp
 *    myapp/WEB-INF/web.xml
 *    myapp/WEB-INF/classes/com/example/LoginServlet.class
 * 2. Compile: javac -cp <tomcat>/lib/servlet-api.jar -d WEB-INF/classes LoginServlet.java
 * 3. Copy 'myapp' into <tomcat>/webapps/ and start Tomcat (bin/startup.sh or startup.bat)
 * 4. Open http://localhost:8080/myapp/
 * 5. Login: admin / password (works without MySQL)
 * Optional MySQL: add mysql-connector jar to WEB-INF/lib, create table users(username,password) in testdb.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HttpServletDemo")
public class HttpServletDemo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");

        out.println("<html><body>");
        out.println("<h2>Hello " + name + " (HTTP Servlet)</h2>");
        out.println("<p>Method used: " + request.getMethod() + "</p>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

/*
 * HOW TO RUN:
 * SERVER NEEDED: Apache Tomcat 9 (uses javax.servlet).
 * 1. Compile: javac -cp <tomcat>/lib/servlet-api.jar -d WEB-INF/classes *.java
 * 2. Folder layout: myapp/index.html , myapp/WEB-INF/classes/*.class
 * 3. Copy 'myapp' folder into <tomcat>/webapps/
 * 4. Start Tomcat: <tomcat>/bin/startup.sh (Windows: startup.bat)
 * 5. Open http://localhost:8080/myapp/index.html
 * (In Eclipse/IntelliJ: Add Tomcat 9 server -> Run on Server)
 */

# Full Stack Java Programming Lab Experiments

**Student Name:** Makwana Vihar Mehulbhai  
**Roll No:** 30  
**Course Code:** 2013611  
**Course Name:** Full Stack Java Programming  
**Department:** Artificial Intelligence & Data Science  

---

## 📂 Experiments Directory Structure

```text
Full_Stack_Java_Lab/
├── Experiment_01_Classes_and_Objects/
│   └── StudentApp.java
├── Experiment_02_Method_Constructor_Overloading/
│   └── Calculator.java
├── Experiment_03_Inheritance_Exception_Handling/
│   └── InheritanceDemo.java
├── Experiment_04_Generic_and_HTTP_Servlet/
│   ├── index.html
│   ├── GenericServletDemo.java
│   └── HttpServletDemo.java
├── Experiment_05_JSP_Servlet_JDBC/
│   ├── login.jsp
│   ├── welcome.jsp
│   ├── error.jsp
│   ├── web.xml
│   └── LoginServlet.java
├── Experiment_06_Static_Website_HTML_CSS_JS/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── Experiment_07_JavaScript_Email_Validation/
│   ├── index.html
│   └── script.js
├── Experiment_08_DOM_Background_Color_Changer/
│   ├── index.html
│   └── script.js
├── Experiment_09_React_Single_Page_App/
│   ├── package.json
│   ├── public/index.html
│   └── src/
│       ├── index.js
│       ├── App.js
│       ├── App.css
│       └── components/
│           ├── Home.js
│           ├── About.js
│           └── Contact.js
└── Experiment_10_SpringBoot_Monolithic_App/
    ├── pom.xml
    └── src/main/
        ├── java/com/example/employeemonolith/
        │   ├── EmployeeMonolithApplication.java
        │   ├── controller/EmployeeController.java
        │   ├── entity/Employee.java
        │   ├── repository/EmployeeRepository.java
        │   └── service/EmployeeService.java
        └── resources/application.properties
```

---

## 💻 Experiment Summary

1. **Exp 1: Classes and Objects** - Student details management with `inputDetails()` and `displayDetails()`.
2. **Exp 2: Method and Constructor Overloading** - Calculator program demonstrating compile-time polymorphism.
3. **Exp 3: Inheritance & Exception Handling** - Person, Student, GraduateStudent, Teacher, Administrator demonstrating Single, Multilevel, and Hierarchical inheritance.
4. **Exp 4: Generic and HTTP Servlet** - Dynamic response generation via `GenericServlet` and `HttpServlet`.
5. **Exp 5: JSP, Servlets, and JDBC** - User authentication login app connecting JSP views with a Java Servlet and JDBC database.
6. **Exp 6: Static Website** - CineReserve Movie Reservation System (HTML5, CSS3, JavaScript).
7. **Exp 7: Email Address Validation** - JavaScript client-side email format validator.
8. **Exp 8: DOM Background Color Changer** - Dynamic background color switching every 5 seconds using `setInterval`.
9. **Exp 9: React Single Page Application** - React SPA with Hooks (`useState`), React Router v6, Props, and States.
10. **Exp 10: Spring Boot Monolithic App** - Self-contained REST application managing employees with Spring Boot, Spring Data JPA, and H2 DB.

---

## ▶️ How to Run (tested notes)

- **Exp 1–3:** `javac File.java` then `java ClassName` (Java 8+).
- **Exp 4 & 5:** need **Apache Tomcat 9** (they use `javax.servlet`; Tomcat 10+ needs `jakarta.servlet`).
  - Exp 4: put `index.html` in the webapp root and the two `.java` files compiled into `WEB-INF/classes`.
  - Exp 5: JSPs in the webapp root, `web.xml` in `WEB-INF/`, `LoginServlet` compiled into `WEB-INF/classes/com/example/`.
  - Login works with **admin / password** even without MySQL. For the DB path add the MySQL connector jar to `WEB-INF/lib` and create table `users(username, password)` in `testdb`.
- **Exp 6–8:** open `index.html` in a browser.
- **Exp 9:** `npm install` then `npm start` (Node 16+).
- **Exp 10:** needs Java 17+ and Maven: `mvn spring-boot:run`, then open `http://localhost:8080/api/employees` (H2 console: `/h2-console`, JDBC URL `jdbc:h2:mem:employeedb`).

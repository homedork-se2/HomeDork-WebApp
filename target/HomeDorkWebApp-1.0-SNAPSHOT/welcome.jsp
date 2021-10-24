<%@ page import="com.example.HomeDorkWebApp.controller.LoginServlet" %>
<%@ page import="com.example.HomeDorkWebApp.model.Lamp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.HomeDorkWebApp.model.Fan" %>
<%@ page import="com.example.HomeDorkWebApp.controller.DeviceServlet"%><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/10/2021
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="email" scope="session" type="java.lang.String"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
href="DeviceServlet"
<link href="https://unpkg.com/tailwindcss/dist/tailwind.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&display=swap" rel="stylesheet">
<style>
    .body-bg {
        background: rgb(182,93,24);
        background: radial-gradient(circle, rgba(182,93,24,0.9079832616640406) 50%, rgba(233,215,148,0.725910432532388) 100%);
    }
</style>

</head>
<body class="body-bg min-h-screen pt-12 md:pt-20 pb-6 px-2 md:px-0" style="font-family:'Lato',sans-serif;">
<header class="max-w-lg mx-auto">
    <a href="#">
        <h1 class="text-4xl font-bold text-white text-center">User Profile</h1>
    </a>
</header>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Displaying Student List</h1>
<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Student Name</b></th>
        <th><b>Student Age</b></th>
        <th><b>Course Undertaken</b></th>
    </tr>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%ArrayList<Integer> std = (ArrayList<Integer>)request.getAttribute("nr");
        for(Integer s:std){%>

    <%-- Arranging data in tabular form
    --%>
    <tr>

        <td><input type="submit" class="block w-96 border border-gray-400 rounded-full py-3 px-6 bg-yellow-500 hover:bg-yellow-400" name="b1"value="<%=s%>" id=" " onclick='f1(this)'></td>

    </tr>
    <%}%>
</table>
<hr/>


<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("index.jsp");
    }

%>

Welcome ${email}

<button onclick="lampcreate()">Create Heading</button>

<h5>
    <%
        LoginServlet.userFirebase.getLocalId();
    %>
</h5>


<script>

    function f1(objButton){
        alert(objButton.value);
    }


</script>
</body>
</html>

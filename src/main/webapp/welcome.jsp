<%@ page import="com.example.HomeDorkWebApp.controller.LoginServlet" %>
<%@ page import="com.example.HomeDorkWebApp.model.Lamp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.HomeDorkWebApp.model.Fan" %>
<%@ page import="com.example.HomeDorkWebApp.controller.DeviceServlet"%><%--

<jsp:useBean id="email" scope="session" type="java.lang.String"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@page import="java.util.ArrayList"%>
 <%--Importing all the dependent classes--%>
<%@page import="com.example.HomeDorkWebApp.controller.UserDetails"%>
<%@page import="java.util.Iterator"%>
<% ArrayList<UserDetails> employeeList = (ArrayList) request.getAttribute("EmpList"); %> <%--Assigning ArrayList object containing User data to the local object --%>

<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("index.jsp");
    }

%>

Welcome ${email}




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

<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">



        <strong><a href="<%=request.getContextPath()%>/IteratorExample?type=getDetails">Show User Details</a></strong>
        <br></br>


    <%
        // Iterating through subjectList

        if(request.getAttribute("userList") != null)  // Null check for the object
             {


        Iterator<UserDetails> iterator = employeeList.iterator();  // Iterator interface

            while(iterator.hasNext())  // iterate through all the data until the last record
            {





                UserDetails userDetails = iterator.next(); //assign individual user record to the user class object
    %>
    <tr><td><%=userDetails.getUserID()%></td>
        <td><%=userDetails.getUserDevices()%></td>
        <td><%=userDetails.getUserName()%></td>



    </tr>
    <%
            }

        }
    %>





</table>
<hr/>



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

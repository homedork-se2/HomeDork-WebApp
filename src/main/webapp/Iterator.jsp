<%--Iterator.jsp --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="com.example.HomeDorkWebApp.controller.UserDetails"%>
<%@page import="java.util.Iterator"%>

<% ArrayList<UserDetails> employeeList = (ArrayList) request.getAttribute("userList"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>



<table cellspacing="2" cellpadding="2">

    <tr><th>User ID</th><th>User Devices</th><th>User Name</th></tr>
    <%
        // Iterating through subjectList

        if(request.getAttribute("userList") != null)  // Null check for the object
        {
            Iterator<UserDetails> iterator = employeeList.iterator();  // Iterator interface

            while(iterator.hasNext())  // iterate through all the data until the last record
            {
                UserDetails empDetails = iterator.next(); //assign individual employee record to the employee class object
    %>
    <tr><td><%=empDetails.getUserID()%></td>
        <td><%=empDetails.getUserDevices()%></td>
        <td><%=empDetails.getUserName()%></td>

    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
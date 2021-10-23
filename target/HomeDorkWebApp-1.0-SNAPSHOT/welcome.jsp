<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/10/2021
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="email" scope="session" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>

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
<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("index.jsp");
    }

%>

Welcome ${email}

<button onclick="lampcreate()">Create Heading</button>
<script>
    function lampcreate() {
        var btn = document.createElement("BUTTON");
        var t = document.createTextNode("CLICK ME");

        btn.setAttribute("style","color:red;font-size:23px");
        btn.appendChild(t);
        document.body.appendChild(btn);

        btn.setAttribute("onclick", alert("clicked"));

    }
</script>


<table align="center" cellspacing="3" cellpadding="3">
    <%
        int k=1;
        for (int i = 1; i <= 10; i++) {
    %>
    <tr>
        <%
            for (int j = 1; j <= 3; j++) {
        %>

        <td><input type="submit" class="block w-96 border border-gray-400 rounded-full py-3 px-6 bg-yellow-500 hover:bg-yellow-400" name="b1"value="<%=k%>" id="" onclick='f1(this)'></td>
        <%
                k++;
            }
        %>
    </tr>
    <%
        }
    %>
</table>

<script>

    function f1(objButton){
        alert(objButton.value);
    }


</script>
</body>
</html>

<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: yubraj
  Date: 11/27/16
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Persons</title>
</head>
<body>
    <form action="showAll" method="get">
        <input type="submit" value="Show All Names">
    </form>

    <form action="person" method="post">
        <p>
            Key         = <input type="number" name="key" required> &nbsp;
            First Name  = <input type="text" name="fname"> &nbsp;
            Last Name   = <input type="text" name="lname">&nbsp;
            <input type="submit" value="Add Person">
        </p>
    </form>

    <%
        HashMap<String, String> msg = (HashMap<String, String>) request.getAttribute("message");
        if(msg != null){
            if(msg.get("error") != null){ %>
                <p style="color: red"><%=msg.get("error")%></p>
            <% }
            if(msg.get("success") != null){ %>
                <p style="color: limegreen"><%=msg.get("success")%></p>
            <% }
        }
    %>


    <form method="post" action="removenameservlet">
        <p>
            Key = <input type="number" name="personkey">
            <input type="submit" value="Remove Person">
        </p>
    </form>

    <%
        HashMap<String, String> delMsg = (HashMap<String, String>) request.getAttribute("delMsg");
        if(delMsg != null){
            if(delMsg.get("error") != null){ %>
                <p style="color: red"><%=delMsg.get("error")%></p>
            <% }
            if(delMsg.get("success") != null){ %>
                    <p style="color: limegreen"><%=delMsg.get("success")%></p>
            <% }
        }
    %>
</body>
</html>

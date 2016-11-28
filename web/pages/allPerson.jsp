<%@ page import="com.yubarj.model.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: yubraj
  Date: 11/27/16
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Person</title>
</head>
<body>
    <%
        if(request.getAttribute("persons") != null){
            List<Person> persons = (List<Person>) request.getAttribute("persons");
            if(persons.size() == 0){ %>
                <p style="color: red;">Sorry No persons has been added!</p>
            <%}else{ %>
                <ul>
                <%
                    for(Person person: persons){%>
                            <li><%=person.toString()%></li>
                <%}%>
                </ul>
             <%}
        }else{ %>
        <p style="color: red">No Persons has been added till yet! Person Repo is empty.</p>
    <%}
    %>

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
            if(msg.get("error") != null){ %>
    <p style="color: red"><%=delMsg.get("error")%></p>
    <% }
        if(delMsg.get("success") != null){ %>
    <p style="color: limegreen"><%=delMsg.get("success")%></p>
    <% }
    }
    %>
</body>
</html>

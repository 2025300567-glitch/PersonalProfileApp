<%-- 
    Document   : profile_display
    Created on : Nov 22, 2025, 1:45:57 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Profile View</title>
        <link rel="stylesheet" href="CSS/style.css">
    </head>
    <body>
        <h1>Personal Profile View</h1>
        <p>First name: ${fname}</p>
        <p>Last name: ${lname}</p>
        <p>Student ID: ${stuID}</p>
        <p>Program: ${program}</p>
        <p>Email: ${email}</p>
        <p>Hobbies: ${hobbie}</p>
        <p>Self Introduction: ${selfIntro}</p>
    </body>
</html>

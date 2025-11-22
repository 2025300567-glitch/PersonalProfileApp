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
        <div class="profile-container">
            <div class="profile-name">
                <h2 class="title">My Profile</h2>
                <p><label>Name:</label> ${name}</p>
                <p><label>Student ID:</label> ${stuID}</p>
                <p><label>Email:</label> ${email}</p>
            </div>
            <div class="profile-about">
                <h2 class="title">About Me</h2>
                <p><label>Program:</label> ${program}</p>
                <p><label>Hobbies:</label> ${hobbie}</p>
                <p><label>Self Introduction:</label><br>${selfIntro}</p>
            </div> 
        </div>
    </body>
</html>

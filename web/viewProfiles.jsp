<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>All Profiles</title>
        <link rel="stylesheet" href="CSS/style.css">
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                background: #87C0DE;
                border-color:#bcd9e5;
                border-radius: 8px;
                overflow: hidden;
            }
            th, td {
                padding: 12px;
                text-align: left;
            }
            th {
                background: #2D7AA4;
                color: white;
            }
        </style>
    </head>
    <body>

        <div class="profile-container">
            
            <form method="get">
                <input type="text" name="searchID" placeholder="Search Student ID">
                <input type="submit" value="Search">
            </form>
            
            <%
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfileDB","app","app");
                Statement stmt = con.createStatement();

                String searchID = request.getParameter("searchID");
                String sql = "SELECT * FROM PROFILE";
                if (searchID != null && !searchID.isEmpty()) {
                    sql = "SELECT * FROM PROFILE WHERE STUID = '" + searchID + "'";
                }

                ResultSet rs = stmt.executeQuery(sql);
            %>
            <h2 class="title">All Student Profiles</h2>
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Student ID</th>
                    <th>Program</th>
                    <th>Email</th>
                    <th>Hobbies</th>
                </tr>
            <%
                while (rs.next()) {
            %>
                <tr>
                    <td><%= rs.getString("NAME") %></td>
                    <td><%= rs.getString("STUID") %></td>
                    <td><%= rs.getString("PROGRAM") %></td>
                    <td><%= rs.getString("EMAIL") %></td>
                    <td><%= rs.getString("HOBBIE") %></td>
                </tr>
            <%
                }
                con.close();
            %>
            </table>
        </div>
    </body>
</html>

package controller;

import model.ProfileBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String stuID = request.getParameter("stuID");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbie = request.getParameter("hobbie");
        String selfIntro = request.getParameter("selfIntro");

        ProfileBean profile = new ProfileBean();
        profile.setName(name);
        profile.setStuID(stuID);
        profile.setProgram(program);
        profile.setEmail(email);
        profile.setHobbie(hobbie);
        profile.setSelfIntro(selfIntro);

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfileDB","app","app");
            String sql = "INSERT INTO PROFILE (name, stuID, program, email, hobbie, selfIntro) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, profile.getName());
            ps.setString(2, profile.getStuID());
            ps.setString(3, profile.getProgram());
            ps.setString(4, profile.getEmail());
            ps.setString(5, profile.getHobbie());
            ps.setString(6, profile.getSelfIntro());
            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("name", name);
        request.setAttribute("stuID", stuID);
        request.setAttribute("program", program);
        request.setAttribute("email", email);
        request.setAttribute("hobbie", hobbie);
        request.setAttribute("selfIntro", selfIntro);

        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.ProfileBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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

            String sql = "INSERT INTO PROFILE (NAME, STUID, PROGRAM, EMAIL, HOBBIE, SELFINTRO) VALUES (?,?,?,?,?,?)";
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

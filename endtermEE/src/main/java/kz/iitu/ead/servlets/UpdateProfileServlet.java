package kz.iitu.ead.servlets;



import kz.iitu.ead.db.DBManager;
import kz.iitu.ead.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateprofile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users)request.getSession().getAttribute("user");

        if(user!=null){

            String fullName = request.getParameter("full_name");
            user.setFullName(fullName);
            if(DBManager.updateUserProfile(user)){
                request.getSession().setAttribute("user", user);
            }

            response.sendRedirect("profile.jsp");

        }else{
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

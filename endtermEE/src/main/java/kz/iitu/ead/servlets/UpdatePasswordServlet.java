package kz.iitu.ead.servlets;


import kz.iitu.ead.db.DBManager;
import kz.iitu.ead.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updatepassword")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users)request.getSession().getAttribute("user");
        String redirect = "/login";

        if(user!=null){

            redirect = "/profile?oldpasserror";

            String oldPass = request.getParameter("old_password");
            String newPass = request.getParameter("new_password");
            String reNewPass = request.getParameter("re_new_password");

            if(user.getPassword().equals(oldPass)){

                redirect = "profile.jsp";

                if(newPass.equals(reNewPass)){

                    user.setPassword(newPass);

                    if(DBManager.updateUserPassword(user)){
                        request.getSession().setAttribute("user", user);
                        redirect = "profile.jsp";
                    }

                }

            }

        }

        response.sendRedirect(redirect);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

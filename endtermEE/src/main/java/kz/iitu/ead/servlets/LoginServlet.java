package kz.iitu.ead.servlets;



import kz.iitu.ead.db.DBManager;
import kz.iitu.ead.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        Users user = DBManager.getUserByEmail(email);

        if(user!=null){
            if(user.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else {
                out.print("Error password!");
                response.sendRedirect("login.jsp");
            }

        }else {
            out.print("Error email!");
            response.sendRedirect("login.jsp");}
    }
}

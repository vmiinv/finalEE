package kz.iitu.ead.servlets;

import kz.iitu.ead.db.DBManager;
import kz.iitu.ead.entities.Coffee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/allcoffee")
public class AllCoffeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Coffee> coffees = DBManager.getAllCoffee();
        request.setAttribute("coffees", coffees);
        request.getRequestDispatcher("coffee.jsp").forward(request,response);
    }
}

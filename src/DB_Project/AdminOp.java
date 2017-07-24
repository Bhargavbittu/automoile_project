package DB_Project;

import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Operator;
import entities.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vankayab on 7/20/2017.
 */
@WebServlet(name="AdminOp")
public class AdminOp extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\"> ");

        String un = (String) request.getParameter("oname");
        String password = (String) request.getParameter("opass");
        OperatorDaoImpl operator = new OperatorDaoImpl();
       boolean a= operator.addOpertor(new Operator(un, password, true));
        if(a)out.println("Operation done Successfully");
        else out.print("could not complete request try again");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" class=\"button-css\"value=\"LOGOUT\" /><p>");
        out.println("</form>");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}


package DB_Project;
import DAO.*;
import DAO.AdminDaoImpl;
import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Admin;
import entities.Operator;
import entities.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
 * Hello world!
 *
 */
@WebServlet(name="AppServlet")
public class AppServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        performTask(request, response);
    }

    private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\" >");
        String u = request.getParameter("username");
        String p = request.getParameter("password");
        int valid = 0;
        valid = login(u, p);
        if(valid == 1){
            out.println("<p align=\"center\"> Login Error or the operator is blocked</p>");
            RequestDispatcher rd=request.getRequestDispatcher("FirstPage.html");
            rd.include(request,response);

        }
        else if(valid == 2){
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" class=\"button-css\" value=\"LOGOUT\" /><p>");
            out.println("</form>");
            out.println("<p align=\"center\">Welcome "+u+"</p>");
            HttpSession session=request.getSession();
            session.setAttribute("aname",u);
            out.println("<br>");
            out.println("<table align=\"center\" border=2>");
            out.println("<th>ADMIN OPTIONS</th>");

            out.println("<tr>");
            out.println("<td>Click to Add Operator : </td>");
            out.println("<td>");
            out.println("<form action=\"SecondPage\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"log\" class=\"button-css\"value=\"Add Operator\" />");
            out.println("</form>");
            out.println("</td></tr>");

            out.println("<tr>");
            out.println("<td>Click to Block Operator : </td>");
            out.println("<td>");
            out.println("<form action=\"ThirdPage\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"log\" class=\"button-css\"value=\"Block Operator\" />");
            out.println("</form>");
            out.println("</td></tr>");

            out.println("<tr>");
            out.println("<td>Click to Place orders : </td>");
            out.println("<td>");
            out.println("<form action=\"FourthPage\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"log\"class=\"button-css\" value=\"Place Order\" />");
            out.println("</form>");
            out.println("</td></tr>");

            out.println("<tr>");
            out.println("<td>Click to search orders : </td>");
            out.println("<td>");
            out.println("<form action=\"FifthPage\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"log\" class=\"button-css\"value=\"Search Orders\" />");
            out.println("</form>");
            out.println("</td></tr>");

            out.println("<tr>");
            out.println("<td>Click to display orders : </td>");
            out.println("<td>");
            out.println("<form action=\"DisplayServlet\" method=\"post\">");
            out.println("<input type=\"submit\" class=\"button-css\"value=\"Display Orders\" />");
            out.println("</form>");
            out.println("</td></tr>");
            out.println("</table>");

        }else if(valid==3){
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" class=\"button-css\"value=\"LOGOUT\" /><p>");
            out.println("</form>");
            out.println("<p align=\"center\">Welcome "+u);
            HttpSession session=request.getSession();
            session.setAttribute("aname",u);
            out.println("<br>OPERATOR OPTIONS");
            out.println("</p>");
            out.println("<table align=\"center\" border=2");


            out.println("<tr>");
            out.println("<td>Click to Place orders : </td>");
            out.println("<td>");
            out.println("<form action=\"FourthPage\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"log\" class=\"button-css\"value=\"Place Order\" />");
            out.println("</form>");
            out.println("</td></tr>");

            out.println("<tr>");
            out.println("<td>Click to search orders : </td>");
            out.println("<td>");
            out.println("<form action=\"FifthPage\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"log\" class=\"button-css\"value=\"Search Orders\" />");
            out.println("</form>");
            out.println("</td></tr>");

            out.println("<tr>");
            out.println("<td>Click to display orders : </td>");
            out.println("<td>");
            out.println("<form action=\"DisplayServlet\" method=\"post\">");
            out.println("<input type=\"submit\"class=\"button-css\" value=\"Display Orders\" />");
            out.println("</form>");
            out.println("</td></tr>");
            out.println("</table>");


        }
    }

    private static int login(String username, String password) {
        AdminDaoImpl admin = new AdminDaoImpl();
        OperatorDaoImpl operator = new OperatorDaoImpl();
        if(admin.validate(new Admin(username, password))) {
            return 2;
        }
        else if(operator.validate(username, password)){
            return 3;
        }
        else {
            return 1;
        }
    }
}

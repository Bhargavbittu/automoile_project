package DB_Project;

import DAO.OrderDaoImpl;
import entities.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vankayab on 7/23/2017.
 */
@WebServlet(name = "AdminOp2")
public class AdminOp2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\"> ");
        try {


            String yname = (String) request.getParameter("yname");
            String id = (String) request.getParameter("id");
            String vm = (String) request.getParameter("vm");
            String op = (String) request.getParameter("op");
            String d = (String) request.getParameter("date");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date1=(Date)dateFormat.parse(d);
             int unit = Integer.parseInt(request.getParameter("unit"));
            double price = Double.parseDouble(request.getParameter("price"));
            double tax = Double.parseDouble(request.getParameter("tax"));
            String spid = (String) request.getParameter("spid");
            String spnm = (String) request.getParameter("spnm");
            OrderDaoImpl ord = new OrderDaoImpl();
            boolean a=ord.placeOrder(new Orders(yname, id, vm, spid, spnm, op, unit, price, tax, date1));
            if(a){out.println("Order placed successfully");}
            else out.println("Order not placed,due to lack of correct/complete info...");
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\"class=\"button-css\" value=\"LOGOUT\" /><p>");
            out.println("</form>");

        } catch (ParseException e) {
            out.println("Order not placed,due to lack of correct/complete info...");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

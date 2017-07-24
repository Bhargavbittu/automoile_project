package DB_Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vankayab on 7/23/2017.
 */
@WebServlet(name = "FourthPage")
public class FourthPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\"> ");
        HttpSession session=request.getSession(false);
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname"));
        out.println("</p><br>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" class=\"button-css\"value=\"LOGOUT\" /><p>");
        out.println("</form>");
        out.println("<form action=\"AdminOp2\" method=\"post\">");
        out.println("<table align=\"center\" border=1>");
        out.println("<th align=\"center\" >Place your Orders ....!!!</th>");
        out.println("<tr><td>Enter ID:<input type=\"text\" name=\"id\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter Your Name:<input type=\"text\" name=\"yname\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter Vehicle Model:<input type=\"text\" name=\"vm\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter Operation:<input type=\"text\" name=\"op\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter Date(dd/mm/yyyy):<input type=\"date\" name=\"date\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter No Units:<input type=\"number\" name=\"unit\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter Price:<input type=\"number\" name=\"price\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter Tax:<input type=\"number\" name=\"tax\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter SparePartId:<input type=\"text\" name=\"spid\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>Enter SparePartName:<input type=\"text\" name=\"spnm\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"PLACE-ORDER\"class=\"button-css\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

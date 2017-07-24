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
@WebServlet(name = "SecondPage")
public class SecondPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\"> ");
        HttpSession session=request.getSession(false);
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\"class=\"button-css\" value=\"LOGOUT\" /><p>");
        out.println("</form>");
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname")+"</p>");
        out.println("<br>");
        out.println("<form action=\"AdminOp\" method=\"post\">");
        out.println("<table align=\"center\" border=1>");
        out.println("<th><h4>Add Operators Details....!!!</h4></th>");
        out.println("<tr><td>ENTER OPERATOR USERNAME : <input type=\"text\"class=\"textbox-css\" name=\"oname\"/></td></tr>");
        out.println("<tr><td>ENTER OPERATOR PASSWORD : <input type=\"text\"class=\"textbox-css\" name=\"opass\"/></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\"class=\"button-css\" value=\"REGISTER\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

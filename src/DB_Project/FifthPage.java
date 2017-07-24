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
@WebServlet(name = "FifthPage")
public class FifthPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\"> ");
        HttpSession session=request.getSession(false);
        out.println("<p align=\"center\" >Welcome "+session.getAttribute("aname"));
        out.println("</p><br>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\"class=\"button-css\" value=\"LOGOUT\" /><p>");
        out.println("</form>");
        out.println("<form action=\"FromTo\" method=\"post\">");
        out.println("<table align=\"center\" border=1>");
        out.println("<th align=\"center\" ><h4>Search Orders....!!!</h4></th>");
        out.println("<tr><td>ENTER START DATE TO SEARCH(dd/mm/yyyy) : <input type=\"date\" name=\"d1\"class=\"textbox-css\"></td></tr>");
        out.println("<tr><td>ENTER END DATE To SEARCH(dd/mm/yyyy) : <input type=\"date\" name=\"d2\"class=\"textbox-css\"/></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"SEARCH-ORDER\"class=\"button-css\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

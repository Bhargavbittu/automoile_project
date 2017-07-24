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
@WebServlet(name = "BPage")
public class BPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        HttpSession session=request.getSession(false);
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\">");
        out.println("</script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\">");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
        out.println("</form>");
        out.println("<div class=\"container\">");

        out.println("Welcome "+session.getAttribute("aname"));
        out.println("<br>");
        out.println("<form action=\"BlockOp\" method=\"post\">");
        out.println("<div class=\"table-responsive\">");

        //out.println("<table align=\"center\" border=1");
        out.println("<table class=\"table\">");
        out.println("<thead>Block Operators ....!!!</thead>");
        out.println("<tbody>");

        out.println("<tr><td>ENTER OPERATOR USERNAME : <input type=\"text\" name=\"oname\"/></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"BLOCK\"/></td></tr>");
        out.println("</tbody>");

        out.println("</table>");
        out.println("</div>");
        out.println("</div>");

        out.println("</form>");

        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

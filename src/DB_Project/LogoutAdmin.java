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
@WebServlet(name = "LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession(false);

            out.print((String) session.getAttribute("aname") + " you have been logged out" + "<br>");
            out.println("</form method=\"get\">");
            out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\">");
            out.println("Click here to Re-Login " + "<input type=\"button\" class=\"button-css\" onclick=location.href=\"FirstPage.html\" value=\"LOGIN\"/>");
            out.println("</form>");

            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package DB_Project;

import Utilities.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by vankayab on 7/23/2017.
 */
@WebServlet(name = "DisplayServlet")
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\" ");
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
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
        out.println("</form>");
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname")+"</p>");
        out.println("<p align=\"center\"> Orders Table....!!!</p>");

        out.println("</body></html>");
        // connecting to database
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Constants.UNAME);
            con = DriverManager.getConnection
                    (Constants.URL, Constants.UID, Constants.PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM orders");
            // displaying records

            out.print("<table align=\"center\" border=1>");

            out.print("<th>Id</th><th>Done By</th><th>Vehicle Model</th><th>Operation</th><th>Date</th><th>Units</th><th>Price</th><th>tax</th><th>SparePartId</th><th>SparePartName</th>");

            while (rs.next()) {
                out.print("<tr><td>"+rs.getObject(1).toString()+"</td>");
                out.print("<td>"+rs.getObject(2).toString()+"</td>");
                out.print("<td>"+rs.getObject(3).toString()+"</td>");
                out.print("<td>"+rs.getObject(4).toString()+"</td>");
                out.print("<td>"+rs.getObject(5).toString()+"</td>");
                out.print("<td>"+rs.getObject(6).toString()+"</td>");
                out.print("<td>"+rs.getObject(7).toString()+"</td>");
                out.print("<td>"+rs.getObject(8).toString()+"</td>");
                out.print("<td>"+rs.getObject(9).toString()+"</td>");
                out.print("<td>"+rs.getObject(10).toString()+"</td></tr>");
            }
            out.print("</table>");



        } catch (SQLException e) {
            throw new ServletException("Servlet Could not display records.", e);
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

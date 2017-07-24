package DB_Project;

import Utilities.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vankayab on 7/23/2017.
 */
@WebServlet(name = "FromTo")
public class FromTo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\"> ");
        out.println("<html>");
        out.println("<head><title>FromTo</title></head>");
        out.println("<body>");
        out.println("<h3 align=\"center\" >Servlet JDBC</h3>");
        out.println("</body></html>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\"class=\"button-css\" value=\"LOGOUT\" /><p>");
        out.println("</form>");
        // connecting to database
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sd1=(String )request.getParameter("d1");
        String sd2=(String )request.getParameter("d2");
        try{
            Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(sd1);
            Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(sd2);

            Class.forName(Constants.UNAME);
            con = DriverManager.getConnection
                    (Constants.URL, Constants.UID, Constants.PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM orders");
            // displaying records
            out.print("<table align=\"center\" border=1>");

            out.print("<th align=\"center\">Id</th><th align=\"center\">Done By</th><th align=\"center\">Vehicle Model</th><th align=\"center\"" +
                    ">Operation</th><th align=\"center\">Date</th><th align=\"center\">Units</th><th align=\"center\">Price</th><th align=\"center\"" +
                    ">tax</th><th align=\"center\">SparePartId</th><th align=\"center\">SparePartName</th>");

            while (rs.next()) {
                Date tempDate = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                if (tempDate.after(d1) && tempDate.before(d2)) {
                    out.print("<tr><td>" + rs.getObject(1).toString() + "</td>");
                    out.print("<td>" + rs.getObject(2).toString() + "</td>");
                    out.print("<td>" + rs.getObject(3).toString() + "</td>");
                    out.print("<td>" + rs.getObject(4).toString() + "</td>");
                    out.print("<td>" + rs.getObject(5).toString() + "</td>");
                    out.print("<td>" + rs.getObject(6).toString() + "</td>");
                    out.print("<td>" + rs.getObject(7).toString() + "</td>");
                    out.print("<td>" + rs.getObject(8).toString() + "</td>");
                    out.print("<td>" + rs.getObject(9).toString() + "</td>");
                    out.print("<td>" + rs.getObject(10).toString() + "</td></tr>");

                }}                out.print("</table>");


        } catch(ParseException e){
            e.printStackTrace();
        }catch (SQLException e) {
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

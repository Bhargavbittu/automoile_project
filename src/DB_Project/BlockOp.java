package DB_Project;

import DAO.OperatorDaoImpl;

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
@WebServlet(name = "BlockOp")
public class BlockOp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"proj.css\">");
        String un = (String) request.getParameter("oname");
        OperatorDaoImpl operator = new OperatorDaoImpl();
        operator.blockOperator(un);
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\"class=\"button-css\" value=\"LOGOUT\" /><p>");
        out.println("</form>");
        out.println("Operater "+un+" blocked Successfully");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

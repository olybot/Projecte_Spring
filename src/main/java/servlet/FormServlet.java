package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xavi on 30/10/17.
 */
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String html = "<html>\n" +
              "   <body>\n" +
              "      <form action = \"form\" method = \"POST\">\n" +
              "         First Name: <input type = \"text\" name = \"first_name\">\n" +
              "         <br />\n" +
              "         Last Name: <input type = \"text\" name = \"last_name\" />\n" +

              "         <input type = \"checkbox\" name = \"maths\" checked = \"checked\" /> Maths <br/>" +
              "         <input type = \"checkbox\" name = \"physics\"  /> Physics <br/>" +
              "         <input type = \"checkbox\" name = \"chemistry\" checked = \"checked\" value='pollo' /> Chemistry <br/>" +
              "         <input type = \"submit\" value = \"Submit\" />\n" +
              "      </form>\n" +
              "   </body>\n" +
              "</html>";

      resp.getWriter().print(html);
      resp.setContentType("text/html");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");

        String chemistry = req.getParameter("chemistry");

        session.setAttribute("name", firstName);

        resp.setContentType("text/html");
        resp.getWriter().print(firstName + " " + lastName);
        resp.getWriter().print("<br/>");
        resp.getWriter().print(chemistry);

    }
}

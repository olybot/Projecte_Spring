package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xavi on 13/11/17.
 */
public class JSPServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder str = new StringBuilder();

        str.append("<html>\n" +
                "<body>\n" +
                "<h2>Hello World!</h2>\n" +
                "</body>\n" +
                "</html>");

        resp.getWriter().print(str.toString());
    }
}

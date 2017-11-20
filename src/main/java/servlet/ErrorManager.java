package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xavi on 6/11/17.
 */
public class ErrorManager extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().print(req.getMethod());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req,resp);

        Throwable throwable = (Throwable)
                req.getAttribute("javax.servlet.error.exception");

        resp.getWriter().print(req.getMethod());
        resp.getWriter().print(throwable.getStackTrace());
    }
}

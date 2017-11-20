package servlet;

import bean.ApplicationContextHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xavi on 10/11/17.
 */
@WebServlet("/bean")
public class BeanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        bean.HelloWorld helloWorld = (bean.HelloWorld) ApplicationContextHandler.context.getBean("pocoyo");

        resp.getWriter().print(helloWorld.getNameContainer().getName());

    }
}

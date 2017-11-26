package servlet;

import bean.ApplicationContextHandler;
import bean.UserContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertUser", urlPatterns = "/insertUser")
public class InsertUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "<html>\n" +
                "   <body>\n" +
                "      <form action = \"insertUser\" method = \"POST\">\n" +
                "         Nom: <input type = \"text\" name = \"name\">\n" +
                "         <br />\n" +
                "         Contrasenya: <input type = \"password\" name = \"password\" />\n" +
                "         <br />\n" +
                "         Email: <input type = 'text' name = 'email' />" +
                "         <br />\n" +
                "         <input type = \"submit\" value = \"Afegeix\" />\n" +
                "      </form>\n" +
                "   </body>\n" +
                "</html>";

        resp.getWriter().print(html);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(name+password+email);
        UserContainer container = (UserContainer) ApplicationContextHandler.context.getBean("UserContainer");
        container.addUser(name, password, email);
        resp.sendRedirect("/users");
    }
}

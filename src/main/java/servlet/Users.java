package servlet;

import bean.ApplicationContextHandler;
import bean.UserContainer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", urlPatterns = "/users")
public class Users extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        resp.getWriter().print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Users</title>\n" +
                "</head>\n" +
                "<body>");

        UserContainer container = (UserContainer) ApplicationContextHandler.context.getBean("UserContainer");
        List<String> allUsers = container.getAllUsers();
        int i = 0;
        for (String usr : allUsers) {
            String[] usuari = usr.split(" ");


            resp.getWriter().print("Name: "+usuari[0]+" E-Mail: "+usuari[1]+"<form action=\"/users\" method=\"POST\">\n" +
                    "        <input type=\"text\" name=\"email\" value=\""+usuari[1]+"\" style=\"display: none\">" +
                    "        <input type=\"submit\" value=\"Esborra\">\n" +
                    "    </form>");
            if(req.getParameter("Esborra") != null){
                container.deleteUser(usuari[1]);
            }
        }

        resp.getWriter().print("</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/users");
    }
}

package servlet;

import bean.Authenticator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        context = new ClassPathXmlApplicationContext("spring-beans.xml");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String html = "<html>\n" +
                "   <body>\n" +
                "      <form action = \"login\" method = \"POST\">\n" +
                "         Correu: <input type = \"text\" name = \"email\">\n" +
                "         <br />\n" +
                "         Contrasenya: <input type = \"password\" name = \"password\" />\n" +
                "         <br />\n" +
                "         <input type = \"checkbox\" name = \"remember\" /> Recorda\n" +
                "         <br />\n" +
                "         <input type = \"submit\" value = \"Entra\" />\n" +
                "      </form>\n" +
                "   </body>\n" +
                "</html>";

        resp.getWriter().print(html);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Cookie cookie = new Cookie("usuari",email);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(cookie);


        Authenticator authenticator = (Authenticator) context.getBean("Autenticator");

        if(authenticator.authentic(email, password)){
            resp.sendRedirect("/insertUser");
        }
    }
}

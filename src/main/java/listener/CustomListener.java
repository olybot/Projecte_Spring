package listener;

import bean.ApplicationContextHandler;
import bean.UserContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by xavi on 10/11/17.
 */
@WebListener
public class CustomListener implements ServletContextListener {
        @Override
        public void contextDestroyed(ServletContextEvent arg0) {
            System.out.println("##########################################################ServletContextListener destroyed");
        }

        //Run this before web application is started
        @Override
        public void contextInitialized(ServletContextEvent arg0) {
            System.out.println("#######################################################ServletContextListener started");
        }

}

package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by xavi on 10/11/17.
 */
@Component
public class ApplicationContextHandler {

    public static ApplicationContext context;

    public static PocoyoBean pocoyoBean;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    //@Autowired
    public void polloperaPocoyoBean(PocoyoBean pBean){
        pocoyoBean = pBean;
    }

}

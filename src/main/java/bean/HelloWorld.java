package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by xavi on 6/11/17.
 */
@Component(value = "pocoyo")
public class HelloWorld {

    //@Autowired
    private NameContainer nameContainer;


    public NameContainer getNameContainer() {
        return nameContainer;
    }

    public void setNameContainer(NameContainer nameContainer) {
        this.nameContainer = nameContainer;
    }
}

package bean;

import org.springframework.stereotype.Component;

/**
 * Created by xavi on 6/11/17.
 */
@Component
public class NameContainer {

    private String name = "default";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

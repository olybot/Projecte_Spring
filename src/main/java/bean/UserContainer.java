package bean;

import org.springframework.stereotype.Component;


@Component
public class UserContainer {

    private String name = "default";

    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }

}

package bean;

import bean.domain.User;
import org.springframework.stereotype.Component;

@Component(value = "Autenticator")
public class Authenticator {

    private UserContainer users;
    public Boolean authentic(String loginUser, String loginPassword){
        users = (UserContainer) ApplicationContextHandler.context.getBean("UserContainer");
        if(users.getLength() == 0){
            users.addAdmin();
        }
        if(users.searchUser(loginUser) == null){
            return false;
        }else{
            User user = users.searchUser(loginUser);
            System.out.println(loginPassword + " " + user.getPassword());
            System.out.println(user.toString());
            return loginPassword.equals(user.getPassword());
        }
    }
}

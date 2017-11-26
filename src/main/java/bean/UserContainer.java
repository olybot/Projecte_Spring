package bean;

import bean.domain.User;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component(value = "UserContainer")
public class UserContainer {

    private List<User> users = new ArrayList<User>();
    private int length;


    public User searchUser(String user){
        for(User eachUser : users){
            if(user.equals(eachUser.getEmail())) {
                return eachUser;
            }
        }
        return null;
    }

    public void addUser(String name, String password, String email){
        User newUser = (User) ApplicationContextHandler.context.getBean("User");
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmail(email);
        users.add(newUser);
        System.out.println(newUser.toString());
    }

    int getLength() {
        return this.users.size();
    }

    public List<String> getAllUsers(){
        List<String> allUsers = new ArrayList<String>();
        for(User usr : users){
            allUsers.add(usr.toString());
        }
        return allUsers;
    }

    public void deleteUser(String u){
        if(!u.equals("admin")){
            for(int i = users.size() - 1; i>=0; i--) {
                System.out.println(users.get(i));
            }
        }
    }

    void addAdmin(){
        addUser("admin", "admin", "admin@admin.com");
    }
}

package shupeyko.geekbrains.demo6;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService {
    private User currentUser;

    @PostConstruct
    public void init() {
        this.currentUser = new User("Bob");
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

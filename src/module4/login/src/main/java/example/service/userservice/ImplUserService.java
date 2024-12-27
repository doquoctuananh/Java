package example.service.userservice;

import example.model.Account;
import example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplUserService implements IUserService {
    private static List<User> users;
    static{
        users = new ArrayList<>();
        users.add(new User("tuananh","123456","do quoc tuan anh","anh@gmail.com",22));
        users.add(new User("tuananh1","123456","do quoc tuan anh2","anh@gmail.com",23));
        users.add(new User("tuananh2","123456","do quoc tuan anh3","anh@gmail.com",24));
        users.add(new User("tuananh3","123456","do quoc tuan anh4","anh@gmail.com",25));
    }
    @Override
    public User loginUser(Account account) {
        User _user = null   ;
        for(User user : users){
            if(account.getAccount().equals(user.getAccount()) && account.getPassword().equals(user.getPassword())){
                _user = user;
                break;
            }
        }
        return _user;
    }
}

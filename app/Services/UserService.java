package Services;
import Repository.UserRepository;
import com.google.inject.Inject;
import models.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Inject
    UserRepository userRepository;

    public User createUser(User user){
        try {
           return userRepository.createUser(user);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public User getUserById(String userId){

        Optional<User> user;
        try {
            user =  userRepository.getUserById(Integer.parseInt(userId));
            if(user == null){
                return null;
            }else{
                return user.get();
            }

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUsers(){
        try {
            return userRepository.getAllUsers();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}

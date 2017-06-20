package hello.service;

import hello.entities.UserData;
import hello.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by leandromaro on 20/6/17.
 */
@Component
public class UserService {
    @Autowired
    UserDataRepository userDataRepository;

    public void saveUser(UserData u){
        userDataRepository.save(u);
    }
}

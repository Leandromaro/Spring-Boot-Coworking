package hello.service.implementation;

import hello.entities.UserData;
import hello.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leandromaro on 20/6/17.
 */
@Service
public class UserService implements hello.service.interfaces.UserService {
    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public void saveUser(UserData u){
        userDataRepository.save(u);
    }
}

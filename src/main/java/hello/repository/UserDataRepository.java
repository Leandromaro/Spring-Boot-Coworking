package hello.repository;

import hello.entities.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by leandromaro on 20/6/17.
 */
@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {
}

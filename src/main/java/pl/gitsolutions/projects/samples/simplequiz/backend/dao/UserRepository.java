package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Users;

/**
 * Created by katgr on 19.11.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<Users,String> {
//    User getUserByUserNameAndPasswordAndActiveFlagTrueAndStatusTrue(String userName, String pass);
}

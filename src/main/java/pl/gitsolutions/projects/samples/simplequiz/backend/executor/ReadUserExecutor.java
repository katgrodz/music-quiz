package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.UserRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Users;


/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class ReadUserExecutor {
    UserRepository repository;

    public Users findUser (String userName, String password) {
        return null;
    }

}

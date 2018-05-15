package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadUserExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Users;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.UserService;

/**
 * Created by katgr on 19.11.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ReadUserExecutor readUserExecutor;

    @Override
    public Boolean findUser(String userName, String password) {
        Users user = readUserExecutor.findUser(userName,password);
        if (user != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}

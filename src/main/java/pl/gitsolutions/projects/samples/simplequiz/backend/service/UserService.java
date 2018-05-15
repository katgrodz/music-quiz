package pl.gitsolutions.projects.samples.simplequiz.backend.service;

/**
 * Created by katgr on 19.11.2017.
 */
public interface UserService {
    Boolean findUser(String userName, String password);
}

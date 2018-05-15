package pl.gitsolutions.projects.samples.simplequiz.backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.UserGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.UserService;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@RestController
public class UserGatewayController implements UserGateway {

    @Autowired
    private UserService userService;

    @Override
    public Boolean findUser(String userName, String password) {
        return userService.findUser(userName, password);
    }
}

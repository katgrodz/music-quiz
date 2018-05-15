package pl.gitsolutions.projects.samples.simplequiz.backend.integration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by katgr on 19.11.2017.
 */
@Controller
@RequestMapping(value = "/users")
public interface UserGateway {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    Boolean findUser(@RequestBody String userName, @RequestBody String password);
}

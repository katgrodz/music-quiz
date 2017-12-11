package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadTrackExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadUserExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.User;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ReadUserExecutor readUserExecutor;

    @Override
    public Boolean findUser(String userName, String password) {
        User user = readUserExecutor.findUser(userName,password);
        if (user != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}

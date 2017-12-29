package pl.gitsolutions.projects.samples.simplequiz.backend.endpoint;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;

import javax.servlet.annotation.WebServlet;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@RestController
@RequestMapping(value = "/answers")
public class AnswerGatewayController extends RemoteServiceServlet implements AnswerGateway {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/my-answers/{userId}", method = RequestMethod.GET)
    @Override
    public List<TrackInfoDto> findMyAnswers(@PathVariable Long userId) {
        return answerService.findMyAnswers(userId);
    }

    @Override
    public List<TrackInfoDto> findMyLastAnswers(Long userId, Long quizId) {
        return answerService.findMyLastAnswers(userId, quizId);
    }

    @Override
    public Answer findAnswerDetails(Long trackId, Long userId) {
        return answerService.findAnswerDetails(trackId, userId);
    }

    @Override
    public void saveAnswer(Answer answer) {
        answerService.saveAnswer(answer);
    }
}

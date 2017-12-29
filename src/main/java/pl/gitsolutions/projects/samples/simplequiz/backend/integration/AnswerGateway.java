package pl.gitsolutions.projects.samples.simplequiz.backend.integration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@RequestMapping(value = "/answers")
public interface AnswerGateway {

    @RequestMapping(value = "/my-answers/{userId}", method = RequestMethod.GET)
    List<TrackInfoDto> findMyAnswers(@PathVariable Long userId);

    @RequestMapping(value = "/my-last-answers/{userId}/{quizId}", method = RequestMethod.GET)
    List<TrackInfoDto> findMyLastAnswers(@PathVariable Long userId, @PathVariable Long quizId);

    @RequestMapping(value = "/answer-details/{trackId}/{userId}", method = RequestMethod.GET)
    Answer findAnswerDetails(@PathVariable Long trackId, @PathVariable Long userId);

    @RequestMapping(value = "/save/{answer}", method = RequestMethod.POST)
    void saveAnswer(@PathVariable Answer answer);
}

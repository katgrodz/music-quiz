package pl.gitsolutions.projects.samples.simplequiz.backend.integration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@RequestMapping(value = "/answers")
public interface AnswerGateway {

    @RequestMapping(value = "/my-answers/{userId}", method = RequestMethod.GET)
    List<TrackInfoDto> findMyAnswers(@PathVariable Long userId);
}

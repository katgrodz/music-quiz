package pl.gitsolutions.projects.samples.simplequiz.backend.service;

import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
public interface AnswerService {

    List<TrackInfoDto> findMyAnswers(Long userId);

    List<TrackInfoDto> findMyLastAnswers(Long userId, Long quizId);

    Answer findAnswerDetails(Long trackId, Long userId);

    void saveAnswer(Answer answer);

    void deleteAnswer(Answer answer);

}

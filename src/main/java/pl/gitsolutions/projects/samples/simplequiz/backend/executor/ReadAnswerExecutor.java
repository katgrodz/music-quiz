package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.AnswerRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class ReadAnswerExecutor{

    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> findAllAnswersForUser (Long userId) {
        return answerRepository.getAllByUserId(userId);
    }

    public Answer findAnswerDetails (Long trackId, Long userId) {
        return answerRepository.getAnswerByTrackIdAndUserId(trackId, userId);
    }
}

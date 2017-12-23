package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.AnswerRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

/**
 * Created by katgr on 20.12.2017.
 */
@Component
public class DeleteAnswerExecutor {

    @Autowired
    AnswerRepository answerRepository;

    public void deleteAnswer(Answer answer) {
        answerRepository.delete(answer);
    }

}

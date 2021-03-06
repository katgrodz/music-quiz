package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.AnswerRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class CreateAnswerExecutor{

    @Autowired
    AnswerRepository repository;

    public void saveAnswer(Answer answer) {
        repository.save(answer);
    }
}

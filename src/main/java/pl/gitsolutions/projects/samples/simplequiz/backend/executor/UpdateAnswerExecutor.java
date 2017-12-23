package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.AnswerRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class UpdateAnswerExecutor{

    @Autowired
    AnswerRepository repository;

    public void updateAnswer(Answer answer) {
        String newTitle = answer.getAnsweredTitle();
        String newArtist = answer.getAnsweredArtist();
        String newTime = answer.getAnswerTime();
        Long answerId = answer.getId();
        repository.updateAnswerById(newArtist, newTitle, newTime, answerId);
    }
}

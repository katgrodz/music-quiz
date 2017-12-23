package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.QuizRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Quiz;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class ReadQuizExecutor{

    @Autowired
    QuizRepository quizRepository;

    public Quiz getQuizDetails(Long quizId) {
        return quizRepository.getQuizById(quizId);
    }

    public List<Quiz> getAllQuizes() {
        return quizRepository.getAll();
    }

}

package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Quiz;

/**
 * Created by katgr on 23.12.2017.
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

    Quiz getQuizById(Long quizId);
}

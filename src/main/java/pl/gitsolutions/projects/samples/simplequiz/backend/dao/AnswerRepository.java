package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer,String> {

    List<Answer> getAllByTrackId(Long trackId);

    Answer getAnswerByTrackIdAndUserId(Long trackId, Long userId);

    List<Answer> getAllByUserId(Long userId);
}

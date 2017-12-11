package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
public interface TrackRepository extends JpaRepository<Track,String>, TrackRepositoryCustom {

    Track getTrackById(Long id);

    List<Track> getAllByQuizId(Long quizId);

    List<Track> getAllByQuizIdAndTaskId(Long quizId, Long taskId);
}

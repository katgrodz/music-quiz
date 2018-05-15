package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Answer ans SET ans.answeredArtist = ?1, ans.answeredTitle = ?2, ans.answerTime = ?3 WHERE ans.id = ?4")
    void updateAnswerById(String artist, String title, String time, Long answerId);
}

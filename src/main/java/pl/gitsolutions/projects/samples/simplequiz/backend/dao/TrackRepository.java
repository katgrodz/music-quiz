package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Repository
public interface TrackRepository extends JpaRepository<Track,String> {

    Track getTrackById(Long id);

    List<Track> getAllByQuizId(Long quizId);

    List<Track> getAllByQuizIdAndTaskId(Long quizId, Long taskId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Track t SET t.trackTitle = ?1, t.trackArtist = ?2, t.albumTitle = ?3, t.year = ?4 WHERE t.id = ?5 ")
    void updateTrackInfo(String title, String artist, String album, int year, Long trackId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Track t SET t.lyricsStart = ?1, t.tipOne = ?2, t.tipTwo = ?3 WHERE t.id = ?4 ")
    void updateTrackTips(String lyrics, String tipOne, String tipTwo, Long trackId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Track t SET t.trackUrl = ?1, t.wikiUrl = ?2 WHERE t.id = ?3")
    void updateTrackUrls(String trackUrl, String wikiUrl, Long trackId);
}

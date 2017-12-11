package pl.gitsolutions.projects.samples.simplequiz.backend.dao.impl;

import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepositoryCustom;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.intValue;
import static org.aspectj.runtime.internal.Conversions.longValue;

/**
 * Created by katgr on 19.11.2017.
 */
@Repository
public class TrackRepositoryImpl implements TrackRepositoryCustom {

    @PersistenceContext()
    private EntityManager entityManager;

    public static final String GET_TRACK_DETAILS = " SELECT TRACK_ID, TRACK_TITLE, TRACK_ARTIST, ALBUM_NAME, YEAR, TIP_ONE, TIP_TWO, LYRICS_START, " +
            " TRACK_URL, WIKI_URL, QUIZ_ID, TASK_ID FROM TRACK WHERE TRACK_ID = :trackId ";

    @Override
    public Track getTrackDetails(Long trackId) {
        Query query = entityManager.createNativeQuery(GET_TRACK_DETAILS);
        query.setParameter("trackId", trackId);
        Object[] resultObject = (Object[]) query.getSingleResult();
        Track result = new Track();
        result.setId(longValue(resultObject[0]));
        result.setTrackTitle(resultObject[1].toString());
        result.setTrackArtist(resultObject[2].toString());
        result.setAlbumTitle(resultObject[3].toString());
        result.setYear(intValue(resultObject[4]));
        result.setTipOne(resultObject[5].toString());
        result.setTipTwo(resultObject[6].toString());
        result.setLyricsStart(resultObject[7].toString());
        result.setTrackUrl(resultObject[8].toString());
        result.setWikiUrl(resultObject[9].toString());
        result.setQuizId(longValue(resultObject[10]));
        result.setTaskId(longValue(resultObject[11]));

        return result;
    }

}

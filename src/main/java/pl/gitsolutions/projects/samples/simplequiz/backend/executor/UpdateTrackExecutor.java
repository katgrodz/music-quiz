package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

/**
 * Created by katgr on 20.12.2017.
 */
@Component
public class UpdateTrackExecutor {

    @Autowired
    TrackRepository repository;

    public void updateTrackInfo(Track track) {
        String newTitle = track.getTrackTitle();
        String newArtist = track.getTrackArtist();
        String newAlbum = track.getAlbumTitle();
        int newYear = track.getYear();
        Long trackId = track.getId();
        repository.updateTrackInfo(newTitle, newArtist, newAlbum, newYear, trackId);
    }

    public void updateTrackTips(Track track) {
        String lyricsStart = track.getLyricsStart();
        String newTipOne = track.getTipOne();
        String newTipTwo = track.getTipTwo();
        Long trackId = track.getId();
        repository.updateTrackTips(lyricsStart, newTipOne, newTipTwo, trackId);
    }

    public void updateTrackUrls(Track track) {
        String newTrackUrl = track.getTrackUrl();
        String newWikiUrl = track.getWikiUrl();
        Long trackId = track.getId();
        repository.updateTrackUrls(newTrackUrl, newWikiUrl, trackId);
    }
}

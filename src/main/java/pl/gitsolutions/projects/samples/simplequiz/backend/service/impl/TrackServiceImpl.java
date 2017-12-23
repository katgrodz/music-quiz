package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadTrackExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.UpdateTrackExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.TrackService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    ReadAnswerExecutor readAnswerExecutor;

    @Autowired
    ReadTrackExecutor readTrackExecutor;

    @Autowired
    UpdateTrackExecutor updateTrackExecutor;

    @Override
    public List<Track> tracksInQuiz(Long quizId) {
        return readTrackExecutor.getTracksInQuiz(quizId);
    }

    @Override
    public Track trackDetails(Long trackId) {
        return readTrackExecutor.getTrackDetails(trackId);
    }

    @Override
    public List<Track> tracksInTask(Long quizId, Long taskId) {
        return readTrackExecutor.getTracksInTask(quizId, taskId);
    }

    @Override
    public void updateTrack(Track track) {
        Long trackId = track.getId();
        Track oldTrack = readTrackExecutor.getTrackDetails(trackId);

        if(track.getTrackTitle() != oldTrack.getTrackTitle() || track.getTrackArtist() != oldTrack.getTrackArtist() ||
                track.getAlbumTitle() != oldTrack.getAlbumTitle() || track.getYear() != oldTrack.getYear()) {
            updateTrackExecutor.updateTrackInfo(track);
        }

        if(track.getLyricsStart() != oldTrack.getLyricsStart() || track.getTipOne() != oldTrack.getTipOne() ||
                track.getTipTwo() != oldTrack.getTipTwo()) {
            updateTrackExecutor.updateTrackTips(track);
        }

        if(track.getTrackUrl() != oldTrack.getTrackUrl() || track.getWikiUrl() != oldTrack.getWikiUrl()) {
            updateTrackExecutor.updateTrackUrls(track);
        }
    }

}
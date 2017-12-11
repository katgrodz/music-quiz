package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadTrackExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    ReadAnswerExecutor readAnswerExecutor;

    @Autowired
    ReadTrackExecutor readTrackExecutor;

    @Override
    public List<TrackInfoDto> findMyAnswers(Long userId) {
        List<TrackInfoDto> resultList = new ArrayList<>();

        List<Track> tracks = readTrackExecutor.getTracksInQuiz(1L);
        for(Track track : tracks) {
            TrackInfoDto singleResult = new TrackInfoDto();
            Long trackId = track.getId();
            singleResult.setId(track.getId());
            singleResult.setQuizId(track.getQuizId());
            singleResult.setTaskId(track.getTaskId());
            singleResult.setTrackId(track.getId());
            singleResult.setTitle(track.getTrackTitle());
            singleResult.setArtist(track.getTrackArtist());
            singleResult.setAlbum(track.getAlbumTitle());
            singleResult.setYear(track.getYear());
            singleResult.setTipOne(track.getTipOne());
            singleResult.setTipTwo(track.getTipTwo());
            singleResult.setLyricsStart(track.getLyricsStart());
            singleResult.setTrackUrl(track.getTrackUrl());
            singleResult.setWikiUrl(track.getWikiUrl());

            Answer answerDetails = readAnswerExecutor.findAnswerDetails(trackId, 1L);
            if (answerDetails != null) {
                singleResult.setAnsweredArtist(answerDetails.getAnsweredArtist());
                singleResult.setAnsweredTitle(answerDetails.getAnsweredTitle());
                singleResult.setAnswerTime(answerDetails.getAnswerTime());
            }

            resultList.add(singleResult);
        }

        return resultList;
    }

    @Override
    public List<TrackInfoDto> findMyLastAnswers(Long userId, Long quizId) {
        return null;
    }
}

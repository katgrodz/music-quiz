package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.CreateAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.DeleteAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadTrackExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.UpdateAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    ReadAnswerExecutor readAnswerExecutor;

    @Autowired
    ReadTrackExecutor readTrackExecutor;

    @Autowired
    CreateAnswerExecutor createAnswerExecutor;

    @Autowired
    UpdateAnswerExecutor updateAnswerExecutor;

    @Autowired
    DeleteAnswerExecutor deleteAnswerExecutor;

    @Override
    public List<TrackInfoDto> findMyAnswers(Long userId) {
        List<TrackInfoDto> resultList = new ArrayList<>();

        List<Answer> answerList = readAnswerExecutor.findAllAnswersForUser(userId);

        for (Answer answer : answerList) {
            TrackInfoDto singleResult = new TrackInfoDto();

            singleResult.setAnsweredArtist(answer.getAnsweredArtist());
            singleResult.setAnsweredTitle(answer.getAnsweredTitle());
//            singleResult.setAnswerTime(answer.getAnswerTime());
            singleResult.setId(answer.getId());
            singleResult.setTrackId(answer.getTrackId());

            Long trackId = answer.getTrackId();

            Track trackDetails = readTrackExecutor.getTrackDetails(trackId);

//            singleResult.setQuizId(trackDetails.getQuizId());
            singleResult.setTaskId(trackDetails.getTaskId());
            singleResult.setTitle(trackDetails.getTrackTitle());
            singleResult.setArtist(trackDetails.getTrackArtist());
            singleResult.setAlbum(trackDetails.getAlbumTitle());
            singleResult.setYear(trackDetails.getYear());
//            singleResult.setTipOne(trackDetails.getTipOne());
//            singleResult.setTipTwo(trackDetails.getTipTwo());
//            singleResult.setLyricsStart(trackDetails.getLyricsStart());
//            singleResult.setTrackUrl(trackDetails.getTrackUrl());
//            singleResult.setWikiUrl(trackDetails.getWikiUrl());

            resultList.add(singleResult);

        }
        return resultList;
    }

    @Override
    public List<TrackInfoDto> findMyLastAnswers(Long userId, Long quizId) {
        List<TrackInfoDto> resultList = new ArrayList<>();

        List<TrackInfoDto> allAnswers = findMyAnswers(userId);

        for (TrackInfoDto answer : allAnswers) {
            if (answer.getQuizId() == quizId) {
                resultList.add(answer);
            }
        }

        return resultList;
    }

    @Override
    @Transactional
    public Answer findAnswerDetails(Long trackId, Long userId) {
        Answer result = readAnswerExecutor.findAnswerDetails(trackId, userId);
        return result;
    }

    @Override
    public void saveAnswer(Answer answer) {

        Answer savedAnswer = readAnswerExecutor.findAnswerDetails(answer.getTrackId(), answer.getUserId());

        if(savedAnswer != null) {
            answer.setId(savedAnswer.getId());
            updateAnswerExecutor.updateAnswer(answer);
        } else {
            createAnswerExecutor.saveAnswer(answer);
        }
    }


    @Override
    public void deleteAnswer(Answer answer) {
        deleteAnswerExecutor.deleteAnswer(answer);
    }
}

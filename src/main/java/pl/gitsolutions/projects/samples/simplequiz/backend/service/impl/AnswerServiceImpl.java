package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.*;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

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
            Long trackId = answer.getTrackId();

            Track trackDetails = readTrackExecutor.getTrackDetails(trackId);

            TrackInfoDto singleResult = TrackInfoDto.builder()
                    .answeredArtist(answer.getAnsweredArtist())
                    .answeredTitle(answer.getAnsweredTitle())
                    .answerTime(answer.getAnswerTime())
                    .id(answer.getId())
                    .trackId(answer.getTrackId())
//                    .quizId()
                    .taskId(trackDetails.getTaskId())
                    .title(trackDetails.getTrackTitle())
                    .artist(trackDetails.getTrackArtist())
                    .album(trackDetails.getAlbumTitle())
                    .year(trackDetails.getYear())
//                    .tipOne(trackDetails.getTipOne())
//                    .tipTwo(trackDetails.getTipTwo())
//                    .lyricsStart(trackDetails.getLyricsStart())
//                    .trackUrl(trackDetails.getTrackUrl())
//                    .wikiUrl(trackDetails.getWikiUrl())
                    .isTipUsed(answer.getTipUsed())
                    .build();

            resultList.add(singleResult);

        } 
        return resultList.stream()
                .sorted(Comparator.comparing(TrackInfoDto::getTrackId))
                .collect(Collectors.toList());
    }

    @Override
    public List<TrackInfoDto> findMyLastAnswers(Long userId, Long quizId) {
        List<TrackInfoDto> resultList = new ArrayList<>();

        List<TrackInfoDto> allAnswers = findMyAnswers(userId);

        for (TrackInfoDto answer : allAnswers) {
            if (quizId.equals(answer.getQuizId())) {
                resultList.add(answer);
            }
        }

        return resultList;
    }

    @Override
    @Transactional
    public Answer findAnswerDetails(Long trackId, Long userId) {
        return readAnswerExecutor.findAnswerDetails(trackId, userId);
    }

    @Override
    public void saveAnswer(Answer answer) {

        Answer savedAnswer = readAnswerExecutor.findAnswerDetails(answer.getTrackId(), answer.getUserId());

        if (nonNull(savedAnswer)) {
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

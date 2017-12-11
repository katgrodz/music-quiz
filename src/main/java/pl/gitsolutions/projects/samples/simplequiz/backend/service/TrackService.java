package pl.gitsolutions.projects.samples.simplequiz.backend.service;

import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
public interface TrackService {


    List<Track> tracksInQuiz(Long quizId);

    Track trackDetails(Long trackId);

    List<Track> tracksInTask(Long quizId, Long taskId);
}

package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class ReadTrackExecutor{

    @Autowired
    TrackRepository repository;

    public Track getTrackDetails (Long trackId) {
        return repository.getTrackById(trackId);
    }

    public List<Track> getTracksInQuiz (Long quizId) {
        return repository.getAllByQuizId(quizId);
    }

    public List<Track> getTracksInTask (Long quizId, Long taskId) {
        return repository.getAllByQuizIdAndTaskId(quizId, taskId);
    }
}

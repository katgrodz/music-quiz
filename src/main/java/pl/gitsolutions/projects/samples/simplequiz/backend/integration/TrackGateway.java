package pl.gitsolutions.projects.samples.simplequiz.backend.integration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@RequestMapping(value = "/tracks")
public interface TrackGateway {

    @RequestMapping(value = "/track-details/{trackId}", method = RequestMethod.GET)
    Track getTrackDetails(@PathVariable Long trackId);

    @RequestMapping(value = "/quiz/{quizId}", method = RequestMethod.GET)
    List<Track> tracksInQuiz(@PathVariable Long quizId);

    @RequestMapping(value = "quiz/{quizId}/{taskId}", method = RequestMethod.GET)
    List<Track> tracksInTask(@PathVariable Long quizId, @PathVariable Long taskId);
}

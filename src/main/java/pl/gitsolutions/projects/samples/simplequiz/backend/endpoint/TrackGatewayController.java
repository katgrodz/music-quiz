package pl.gitsolutions.projects.samples.simplequiz.backend.endpoint;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.TrackService;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@RestController
@RequestMapping(value = "/tracks")
public class TrackGatewayController extends RemoteServiceServlet implements TrackGateway {

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/track-details/{trackId}", method = RequestMethod.GET)
    @Override
    public Track getTrackDetails(@PathVariable Long trackId) {
        return trackService.trackDetails(trackId);
    }

    @RequestMapping(value = "/quiz/{quizId}", method = RequestMethod.GET)
    @Override
    public List<Track> tracksInQuiz(@PathVariable Long quizId) {
        return trackService.tracksInQuiz(quizId);
    }

    @RequestMapping(value = "quiz/{quizId}/{taskId}", method = RequestMethod.GET)
    @Override
    public List<Track> tracksInTask(@PathVariable Long quizId, @PathVariable Long taskId) {
        return trackService.tracksInTask(quizId, taskId);
    }
}

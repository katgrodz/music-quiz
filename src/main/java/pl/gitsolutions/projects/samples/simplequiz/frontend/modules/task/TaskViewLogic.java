package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.task;

import org.springframework.beans.factory.annotation.Autowired;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

/**
 * Created by katgr on 15.11.2017.
 */
public class TaskViewLogic {

    @Autowired
    private TrackGateway trackGateway;

    public void saveAnswer(TrackInfoDto inBag){

    }

    public Track nextTrack(){
        return trackGateway.getTrackDetails(10L);
    }

    public void previousTrack() {}

    public void getFirstTip() {}

    public void getSecondTip() {}
}

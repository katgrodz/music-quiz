package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class CreateTrackExecutor{

    @Autowired
    TrackRepository repository;

    public void saveTrack(Track track){
        repository.save(track);
    }
}

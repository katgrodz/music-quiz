package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
public interface TrackRepositoryCustom  {

    Track getTrackDetails(Long trackId);
}

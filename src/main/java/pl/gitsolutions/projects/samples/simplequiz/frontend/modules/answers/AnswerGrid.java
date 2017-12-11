package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers;

import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.NumberRenderer;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;

/**
 * Created by katgr on 15.11.2017.
 */
public class AnswerGrid extends Grid<TrackInfoDto>{

    public AnswerGrid() {
        setSizeFull();


        addColumn(TrackInfoDto::getId, new NumberRenderer()).setCaption("Id").setMaximumWidth(60.0);
        addColumn(TrackInfoDto::getTaskId, new NumberRenderer()).setCaption("Task no").setMaximumWidth(50.0);
        addColumn(TrackInfoDto::getTrackId, new NumberRenderer()).setCaption("Track no").setMaximumWidth(50.0);
        addColumn(TrackInfoDto::getAnsweredArtist).setCaption("Answered artist");
        addColumn(TrackInfoDto::getAnsweredTitle).setCaption("Answered title");
        addColumn(TrackInfoDto::getArtist).setCaption("Correct artist");
        addColumn(TrackInfoDto::getTitle).setCaption("Correct title");
        addColumn(TrackInfoDto::getYear, new NumberRenderer()).setCaption("Year");
        addColumn(TrackInfoDto::getAlbum).setCaption("Album name");
    }

    public TrackInfoDto getSelectedRow() {
        return asSingleSelect().getValue();
    }

    public void refresh(TrackInfoDto trackInfo) {
        getDataCommunicator().refresh(trackInfo);
    }
}

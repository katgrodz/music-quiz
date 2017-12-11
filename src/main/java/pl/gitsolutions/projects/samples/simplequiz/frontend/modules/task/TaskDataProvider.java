package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.task;

import com.vaadin.data.provider.AbstractDataProvider;
import com.vaadin.data.provider.Query;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by katgr on 26.11.2017.
 */
public class TaskDataProvider extends AbstractDataProvider<Track,String> {

    @Autowired
    TrackGateway trackGateway;

//    List<Track> tracksInQuiz (long quizId) {
//
//    }

    @Override
    public boolean isInMemory() {
        return false;
    }

    @Override
    public int size(Query<Track, String> query) {
        return 0;
    }

    @Override
    public Stream<Track> fetch(Query<Track, String> query) {
        return null;
    }
}

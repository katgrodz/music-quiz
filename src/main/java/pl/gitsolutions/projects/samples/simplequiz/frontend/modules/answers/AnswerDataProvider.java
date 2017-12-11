package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers;

import com.vaadin.data.provider.AbstractDataProvider;
import com.vaadin.data.provider.Query;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gitsolutions.projects.samples.simplequiz.backend.DataProvider;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.endpoint.AnswerGatewayController;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by katgr on 15.11.2017.
 */
public class AnswerDataProvider extends AbstractDataProvider<TrackInfoDto,String> {

    @Autowired
    AnswerGateway dataProvider;

    @Override
    public boolean isInMemory() {
        return false;
    }

    @Override
    public int size(Query<TrackInfoDto, String> query) {
        return 0;
    }

    @Override
    public Stream<TrackInfoDto> fetch(Query<TrackInfoDto, String> query) {
//        List<TrackInfoDto> result = dataProvider.findMyAnswers(1L);
//        return result.stream();
        return null;
    }
}

package pl.gitsolutions.projects.samples.simplequiz.backend.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.gitsolutions.projects.samples.simplequiz.backend.SimpleQuizTestContext;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.impl.TrackServiceImpl;

import java.util.List;

/**
 * Created by katgr on 11.12.2017.
 */
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/InsertTracks.sql")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SimpleQuizTestContext.class})
@DataJpaTest
public class TrackServiceTest {

    @Autowired
    private TrackService trackService;

    @Test
    public void tracksInQuizReturnList() {
        List<Track> result = trackService.tracksInQuiz(10L);
        int expectedSize = 5;

        Assert.assertEquals(expectedSize, result.size());
    }

    @Test
    public void tracksInTaskReturnList() {
        List<Track> result = trackService.tracksInTask(10L,1L);
        int expectedSize = 3;

        Assert.assertEquals(expectedSize, result.size());
    }

    @Test
    public void trackDetails() {
        Track result = trackService.trackDetails(1003L);
        String expectedTitle = "Enter Sandman";

        Assert.assertEquals(expectedTitle, result.getTrackTitle());
    }


}

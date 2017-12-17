package pl.gitsolutions.projects.samples.simplequiz.backend.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.gitsolutions.projects.samples.simplequiz.backend.SimpleQuizTestContext;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;

import java.util.List;

/**
 * Created by katgr on 11.12.2017.
 */
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/InsertTracks.sql")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SimpleQuizTestContext.class})
@DataJpaTest
public class AnswerServiceTest {

    @Autowired
    private AnswerService answerService;

    @Test
    public void findMyAnswersShouldReturnList() {
        List<TrackInfoDto> result = answerService.findMyAnswers(1L);
        int expectedSize = 10;

        Assert.assertEquals(expectedSize, result.size());
    }

    @Test
    public void findMyAnswersInQuizShouldReturnList() {
        List<TrackInfoDto> result = answerService.findMyLastAnswers(1L, 10L);
        int expectedSize = 5;

        Assert.assertEquals(expectedSize, result.size());
    }
}

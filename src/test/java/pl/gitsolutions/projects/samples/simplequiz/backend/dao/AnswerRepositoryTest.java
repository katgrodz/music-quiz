package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;

import java.util.List;

/**
 * Created by katgr on 11.12.2017.
 */
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/InsertTracks.sql")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SimpleQuizTestContext.class})
@DataJpaTest
public class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository repository;

    @Test
    public void getAllByTrackIdShouldReturnList() {
        List<Answer> result = repository.getAllByTrackId(101L);
        int expectedSize = 3;

        Assert.assertEquals(expectedSize, result.size());
    }

    @Test
    public void getAllByTrackIdShouldReturnEmptyList() {
        List<Answer> result = repository.getAllByTrackId(100L);
        int expectedSize = 0;

        Assert.assertEquals(expectedSize, result.size());
    }

    @Test
    public void getAnswerByTrackIdAndUserIdShouldReturnSingleResult() {
        Answer result = repository.getAnswerByTrackIdAndUserId(101L,1L);

        Assert.assertNotNull(result);
    }

    @Test
    public void getAnswerByTrackIdAndUserIdShouldReturnNothing() {
        Answer result = repository.getAnswerByTrackIdAndUserId(100L,1L);

        Assert.assertNull(result);
    }

    @Test
    public void getAllByUserIdShouldReturnUserAnswerList() {
        List<Answer> result1 = repository.getAllByUserId(1L);
        List<Answer> result2 = repository.getAllByUserId(2L);
        List<Answer> result3 = repository.getAllByUserId(3L);

        Assert.assertEquals(10, result1.size());
        Assert.assertEquals(10, result2.size());
        Assert.assertEquals(3, result3.size());
    }

    @Test
    public void getAllByUserIdShouldReturnEmptyList() {
        List<Answer> result = repository.getAllByUserId(4L);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void updateAnswer(){
        Answer oldAnswer = repository.getAnswerByTrackIdAndUserId(101L, 1L);
        Assert.assertEquals("title", oldAnswer.getAnsweredTitle());
        Assert.assertEquals("artist", oldAnswer.getAnsweredArtist());
        Assert.assertEquals("00:24:124", oldAnswer.getAnswerTime());

        Answer newAnswer = new Answer();
        newAnswer.setAnsweredTitle("new title");
        newAnswer.setAnsweredArtist("new artist");
        newAnswer.setAnswerTime("00:00:100");
        newAnswer.setId(oldAnswer.getId());

        repository.updateAnswerById(newAnswer.getAnsweredArtist(), newAnswer.getAnsweredTitle(), newAnswer.getAnswerTime(), newAnswer.getId());

        Answer updatedAnswer = repository.getAnswerByTrackIdAndUserId(101L, 1L);
        Assert.assertEquals(newAnswer.getAnsweredArtist(),updatedAnswer.getAnsweredArtist());
        Assert.assertEquals(newAnswer.getAnsweredTitle(),updatedAnswer.getAnsweredTitle());
        Assert.assertEquals(newAnswer.getAnswerTime(),updatedAnswer.getAnswerTime());

    }
}

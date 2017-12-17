package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.gitsolutions.projects.samples.simplequiz.backend.SimpleQuizTestContext;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 11.12.2017.
 */
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/InsertTracks.sql")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SimpleQuizTestContext.class})
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository repository;

    @Test
    public void getTrackByIdShouldReturnOneResult() {
        Track result = repository.getTrackById(101L);

        Long actualTrackId = result.getId();
        Long actualQuizId = result.getQuizId();
        Long actualTaskId = result.getTaskId();

        Assert.assertEquals("101", result.getId().toString());
        Assert.assertEquals("Heart Shaped Box", result.getTrackTitle());
        Assert.assertEquals("Nirvana", result.getTrackArtist());
        Assert.assertEquals("In Utero", result.getAlbumTitle());
        Assert.assertEquals(1993, result.getYear());
        Assert.assertEquals("First Tip", result.getTipOne());
        Assert.assertEquals("Second Tip", result.getTipTwo());
        Assert.assertEquals("00:24:125", result.getLyricsStart());
        Assert.assertEquals("track url", result.getTrackUrl());
        Assert.assertEquals("wikipedia url", result.getWikiUrl());
        Assert.assertEquals("10", result.getQuizId().toString());
        Assert.assertEquals("1", result.getTaskId().toString());

    }

    @Test
    public void getTrackByIdShouldReturnNull() {
        Track result = repository.getTrackById(112L);

        Assert.assertNull(result);
    }

    @Test
    public void getAllByQuizIdShouldReturnListOfTracks() {

        List<Track> resultList = repository.getAllByQuizId(11L);

        Assert.assertEquals(5,resultList.size());

    }

    @Test
    public void getAllByQuizIdShouldReturnEmptyList() {

        List<Track> resultList = repository.getAllByQuizId(12L);

        Assert.assertEquals(0,resultList.size());


    }

}
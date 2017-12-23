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

    @Test
    public void updateTrackInfo(){

        String newTitle = "new title";
        String newArtist = "new artist";
        String newAlbum = "new album";
        int newYear = 1999;

        repository.updateTrackInfo(newTitle, newArtist, newAlbum, newYear,110L);

        Track updatedTrack = repository.getTrackById(110L);

        Assert.assertEquals(newTitle, updatedTrack.getTrackTitle());
        Assert.assertEquals(newArtist, updatedTrack.getTrackArtist());
        Assert.assertEquals(newAlbum, updatedTrack.getAlbumTitle());
        Assert.assertEquals(newYear, updatedTrack.getYear());
        Assert.assertEquals("First Tip", updatedTrack.getTipOne());
        Assert.assertEquals("track url", updatedTrack.getTrackUrl());
    }

    @Test
    public void updateTrackUrls(){

        String newTrackUrl = "new track url";
        String newWikiUrl = "new wiki url";

        repository.updateTrackUrls(newTrackUrl, newWikiUrl, 110L);

        Track updatedTrack = repository.getTrackById(110L);

        Assert.assertEquals("Rainbow in the Dark", updatedTrack.getTrackTitle());
        Assert.assertEquals(newTrackUrl, updatedTrack.getTrackUrl());
        Assert.assertEquals(newWikiUrl, updatedTrack.getWikiUrl());
        Assert.assertEquals("First Tip", updatedTrack.getTipOne());
    }

    @Test
    public void updateTrackTips(){

        String newLyricsStart = "00:20:001";
        String newTipOne = "new track url";
        String newTipTwo = "new wiki url";

        repository.updateTrackTips(newLyricsStart,newTipOne,newTipTwo,110L);

        Track updatedTrack = repository.getTrackById(110L);

        Assert.assertEquals("Rainbow in the Dark", updatedTrack.getTrackTitle());
        Assert.assertEquals("track url", updatedTrack.getTrackUrl());
        Assert.assertEquals(newLyricsStart, updatedTrack.getLyricsStart());
        Assert.assertEquals(newTipOne, updatedTrack.getTipOne());
        Assert.assertEquals(newTipTwo, updatedTrack.getTipTwo());
    }

}
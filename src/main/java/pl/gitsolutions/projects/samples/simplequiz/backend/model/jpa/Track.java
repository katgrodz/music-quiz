package pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by katgr on 19.11.2017.
 */
@Table(name = "TRACK")
@Entity(name = "Track")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Track extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TRACK_ID", nullable = false)
    private Long id;

    @Column(name = "TRACK_TITLE")
    private String trackTitle;

    @Column(name = "TRACK_ARTIST")
    private String trackArtist;

    @Column(name = "ALBUM_NAME")
    private String albumTitle;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "TIP_ONE")
    private String tipOne;

    @Column(name = "TIP_TWO")
    private String tipTwo;

    @Column(name = "LYRICS_START")
    private String lyricsStart;

    @Column(name = "TRACK_URL")
    private String trackUrl;

    @Column(name = "WIKI_URL")
    private String wikiUrl;

//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "QUIZ_ID")
    private Long quizId;

//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "TASK_ID")
    private Long taskId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTipOne() {
        return tipOne;
    }

    public void setTipOne(String tipOne) {
        this.tipOne = tipOne;
    }

    public String getTipTwo() {
        return tipTwo;
    }

    public void setTipTwo(String tipTwo) {
        this.tipTwo = tipTwo;
    }

    public String getLyricsStart() {
        return lyricsStart;
    }

    public void setLyricsStart(String lyricsStart) {
        this.lyricsStart = lyricsStart;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}

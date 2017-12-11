package pl.gitsolutions.projects.samples.simplequiz.backend.dto;

/**
 * Created by katgr on 15.11.2017.
 */

public class TrackInfoDto {

    private Long id;
    private Long quizId;
    private Long taskId;
    private Long trackId;
    private String title;
    private String artist;
    private String album;
    private int year;
    private String tipOne;
    private String tipTwo;
    private String lyricsStart;
    private String trackUrl;
    private String wikiUrl;
    private String answeredArtist;
    private String answeredTitle;
    private String answerTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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

    public String getAnsweredArtist() {
        return answeredArtist;
    }

    public void setAnsweredArtist(String answeredArtist) {
        this.answeredArtist = answeredArtist;
    }

    public String getAnsweredTitle() {
        return answeredTitle;
    }

    public void setAnsweredTitle(String answeredTitle) {
        this.answeredTitle = answeredTitle;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }
}

package pl.gitsolutions.projects.samples.simplequiz.backend.dto;

import lombok.Builder;
import lombok.Value;

/**
 * Created by katgr on 15.11.2017.
 */

@Value
@Builder(toBuilder = true)
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
    private Boolean isTipUsed;

}

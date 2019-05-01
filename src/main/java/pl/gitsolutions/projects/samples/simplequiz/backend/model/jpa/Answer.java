package pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by katgr on 19.11.2017.
 */
@Table(name = "ANSWER")
@Entity(name = "Answer")
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ANSWER_ID", nullable = false)
    private Long id;

    @Column(name = "ANSWERED_TITLE")
    private String answeredTitle;

    @Column(name = "ANSWERED_ARTIST")
    private String answeredArtist;

    @Column(name = "ANSWER_TIME")
    private String answerTime;

    @Column(name = "TRACK_ID")
    private Long trackId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "TIP_USED")
    private Boolean tipUsed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnsweredTitle() {
        return answeredTitle;
    }

    public void setAnsweredTitle(String answeredTitle) {
        this.answeredTitle = answeredTitle;
    }

    public String getAnsweredArtist() {
        return answeredArtist;
    }

    public void setAnsweredArtist(String answeredArtist) {
        this.answeredArtist = answeredArtist;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getTipUsed() {
        return tipUsed;
    }

    public void setTipUsed(Boolean tipUsed) {
        this.tipUsed = tipUsed;
    }
}

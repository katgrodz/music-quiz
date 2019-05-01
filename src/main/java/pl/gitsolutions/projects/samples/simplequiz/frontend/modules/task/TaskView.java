package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.task;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Answer;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * Created by katgr on 12.11.2017.
 */
public class TaskView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "taskView";

    private Integer currentTrack;
    private String taskDescription = "  Quess the song and artist.";
    private String trackUrl = "";

    private Button tipFirstBtn = new Button("first letters");
    private Label tipFirstText = new Label();
    private Button tipSecondBtn = new Button("different tip");
    private Label tipSecondText = new Label();
    private TextField artistField = new TextField();
    private TextField titleField = new TextField();
    private Label countLbl = new Label();
    private Button sendBtn = new Button("Save");
    private Button prevBtn = new Button("Previous");
    private Button nextBtn = new Button("Next");

    private TrackInfoDto trackInfo = TrackInfoDto.builder().build();

    private StopWatch stopwatch = new StopWatch();

    private DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("mm:ss.SSS");

    public TaskView(TrackGateway trackGateway, AnswerGateway answerGateway) {

        if (isNull(currentTrack)) {
            currentTrack = 0;
        }

        List<Track> tracks = trackGateway.tracksInQuiz(1L);
        int tracksCount = tracks.size();

        CustomLayout taskContent = new CustomLayout("taskView");
        taskContent.setStyleName("about-content");

        taskContent.addComponent(
                new Label(VaadinIcons.INFO_CIRCLE.getHtml()
                        + taskDescription, ContentMode.HTML), "task-description");

        setSizeFull();
        setMargin(false);

        countLbl.setValue("1 /  " + tracksCount);
        taskContent.addComponent(countLbl, "task-counter");

        Audio sample = new Audio();
        trackUrl = tracks.get(currentTrack).getTrackUrl();
        final Resource audioResource = new ExternalResource(trackUrl);
        sample.setSource(audioResource);
        sample.setHtmlContentAllowed(true);
        sample.setAutoplay(true);
        sample.setAltText("Can't play media");
        taskContent.addComponent(sample, "task-player");

        taskContent.addComponent(new Label("Artist"), "task-artist-label");
        artistField.setWidth(100, Unit.PERCENTAGE);
        taskContent.addComponent(artistField, "task-artist-field");
        taskContent.addComponent(new Label("Title"), "task-title-label");
        titleField.setWidth(100, Unit.PERCENTAGE);
        taskContent.addComponent(titleField, "task-title-field");
        taskContent.addComponent(new Label("Answer"), "task-answer");

        prevBtn.setWidth("100");
        sendBtn.setWidth("130");
        nextBtn.setWidth("100");

        taskContent.addComponent(prevBtn, "task-button-prev");
        taskContent.addComponent(sendBtn, "task-button-save");
        taskContent.addComponent(nextBtn, "task-button-next");

        tipFirstBtn.setWidth("100");

        taskContent.addComponent(tipFirstBtn, "task-button-tip1");
        taskContent.addComponent(tipFirstText, "task-button-tip1-text");

        HorizontalLayout tipTwoPanel = new HorizontalLayout();
        tipSecondBtn.setWidth("100");
        tipSecondBtn.setVisible(false);
        tipSecondBtn.setDescription("ex. year, similarity, etc.");
        taskContent.addComponent(tipSecondBtn, "task-button-tip2");
        taskContent.addComponent(tipSecondBtn, "task-button-tip2-text");


        setStyleName("about-view");
        addComponent(taskContent);
        setComponentAlignment(taskContent, Alignment.TOP_CENTER);

        stopwatch.start();

        Answer alreadySavedAnswer = answerGateway.findAnswerDetails(tracks.get(currentTrack).getId(), 1L);

        if (alreadySavedAnswer != null && alreadySavedAnswer.getId() != null) {
            titleField.setValue(alreadySavedAnswer.getAnsweredTitle());
            artistField.setValue(alreadySavedAnswer.getAnsweredArtist());
        }

        sendBtn.addClickListener(
                (Button.ClickListener) clickEvent -> {

                    stopwatch.stop();
                    Answer answer = new Answer();

                    answer.setAnsweredTitle(titleField.getValue());
                    answer.setAnsweredArtist(artistField.getValue());
                    Timestamp answerTime = new Timestamp(stopwatch.getLastTaskTimeMillis());
                    answer.setAnswerTime(answerTime.toLocalDateTime().format(TIME_FORMAT));

//                    if (!StringUtils.isEmpty(tipFirstText.getValue())) {
//                        answer.setAnswerTime(String.valueOf(stopwatch.getLastTaskTimeMillis() + 10000));
//                    }
                    answer.setTrackId(tracks.get(currentTrack).getId());
                    answer.setUserId(1L);
                    answer.setTipUsed(!StringUtils.isEmpty(tipFirstText.getValue()));

                    answerGateway.saveAnswer(answer);
                    sendBtn.setCaption("Update answer");
                    stopwatch.start();
                }
        );

        prevBtn.addClickListener(
                (Button.ClickListener) clickEvent -> {

                    if (stopwatch.isRunning()) {
                        stopwatch.stop();
                    }
                    stopwatch.start();
                    if (currentTrack == 0) {
                        currentTrack = currentTrack;
                    } else {
                        currentTrack = currentTrack - 1;

                        trackUrl = tracks.get(currentTrack).getTrackUrl();
                        final Resource audioResource12 = new ExternalResource(trackUrl);
                        sample.setSource(audioResource12);
                        sample.setHtmlContentAllowed(true);
                        sample.setAltText("Can't play media");
                        taskContent.addComponent(sample, "task-player");

                        tipFirstText.setValue(tracks.get(currentTrack).getTipOne());
                        tipSecondText.setValue(tracks.get(currentTrack).getTipTwo());

                        clearTips();
                        clearForm();

                        Answer alreadySavedAnswer12 = answerGateway.findAnswerDetails(tracks.get(currentTrack).getId(), 1L);

                        if (alreadySavedAnswer12 != null && alreadySavedAnswer12.getId() != null) {
                            titleField.setValue(alreadySavedAnswer12.getAnsweredTitle());
                            artistField.setValue(alreadySavedAnswer12.getAnsweredArtist());
                        }

                        countLbl.setValue((currentTrack + 1) + " / " + tracksCount);
                    }
                }
        );

        nextBtn.addClickListener(
                (Button.ClickListener) clickEvent -> {
                    if (stopwatch.isRunning()) {
                        stopwatch.stop();
                    }
                    stopwatch.start();
                    if (currentTrack == tracks.size() - 1) {
                        currentTrack = currentTrack;
                    } else {
                        taskContent.removeComponent("task-player");
                        currentTrack = currentTrack + 1;

                        trackUrl = tracks.get(currentTrack).getTrackUrl();
                        final Resource audioResource1 = new ExternalResource(trackUrl);
                        sample.setSource(audioResource1);
                        sample.setHtmlContentAllowed(true);
                        sample.setAltText("Can't play media");
                        taskContent.addComponent(sample, "task-player");

                        tipFirstText.setValue(tracks.get(currentTrack).getTipOne());
                        tipSecondText.setValue(tracks.get(currentTrack).getTipTwo());

                        clearTips();
                        clearForm();

                        Answer alreadySavedAnswer1 = answerGateway.findAnswerDetails(tracks.get(currentTrack).getId(), 1L);

                        if (alreadySavedAnswer1 != null && alreadySavedAnswer1.getId() != null) {
                            titleField.setValue(alreadySavedAnswer1.getAnsweredTitle());
                            artistField.setValue(alreadySavedAnswer1.getAnsweredArtist());
                        }

                        countLbl.setValue((currentTrack + 1) + " / " + tracksCount);
                    }
                }
        );

        tipFirstBtn.addClickListener(
                (Button.ClickListener) clickEvent -> {
                    tipFirstText.setValue(tracks.get(currentTrack).getTipOne());
//                        artistField.setValue(tracks.get(currentTrack).getTipOne());
//                        tipSecondBtn.setVisible(true);
                }
        );

        tipSecondBtn.addClickListener(
                (Button.ClickListener) clickEvent ->
                        tipSecondText.setValue(tracks.get(currentTrack).getTipTwo())
        );
    }

    private void clearTips() {
        tipSecondBtn.setVisible(false);
        tipSecondText.setValue("");
        tipSecondText.setVisible(false);

        tipFirstText.setValue("");
    }

    private void clearForm() {
        titleField.setValue("");
        artistField.setValue("");
        sendBtn.setCaption("Save");
    }
}

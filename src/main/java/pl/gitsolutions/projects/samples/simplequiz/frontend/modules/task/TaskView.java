package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.task;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Audio;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 12.11.2017.
 */
public class TaskView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "taskView";

    private String taskDescription;
    private String trackUrl = "";

    private TextField artistField;
    private TextField titleField;

    @Autowired
    TaskViewLogic viewLogic;

    private TaskDataProvider taskDataProvider = new TaskDataProvider();

    private TrackInfoDto trackInfo = new TrackInfoDto();

    public TaskView() {



//        List<Track> tracks = taskDataProvider.tracksInQuiz(1);

        CustomLayout taskContent = new CustomLayout("taskView");
        taskContent.setStyleName("about-content");

//        taskCount = dataProvider.getContest().getTaskList().size();

        taskContent.addComponent(
                new Label(VaadinIcons.INFO_CIRCLE.getHtml()
                        + taskDescription, ContentMode.HTML),"task-description");

        setSizeFull();
        setMargin(false);

        Audio sample = new Audio();
        final Resource audioResource = new ExternalResource(trackUrl);
        sample.setSource(audioResource);
        sample.setHtmlContentAllowed(true);
        sample.setAltText("Can't play media");
        taskContent.addComponent(sample,"task-player");

        taskContent.addComponent(new Label("Artist"), "task-artist-label");
        taskContent.addComponent(artistField = new TextField(),"task-artist-field");
        taskContent.addComponent(new Label("Title"), "task-title-label");
        taskContent.addComponent(titleField = new TextField(),"task-title-field");
        taskContent.addComponent(new Label("Answer"), "task-answer");
        Button sendBtn = new Button("Save");
        taskContent.addComponent(sendBtn,"task-button1");

        HorizontalLayout navigationPanel = new HorizontalLayout();
        Button prevBtn = new Button("prev");
        Button nextBtn = new Button("next");
        navigationPanel.addComponent(prevBtn);
        navigationPanel.addComponent(nextBtn);
        taskContent.addComponent(navigationPanel,"task-button2");

        HorizontalLayout tipOnePanel = new HorizontalLayout();
        Button tipFirstBtn = new Button("first letters");
        Label tipFirstText = new Label();
        tipOnePanel.addComponent(tipFirstBtn);
        tipOnePanel.addComponent(tipFirstText);
        taskContent.addComponent(tipOnePanel,"task-button3");

        HorizontalLayout tipTwoPanel = new HorizontalLayout();

        Button tipSecondBtn = new Button("different tip");
        Label tipSecondText = new Label();
        tipSecondBtn.setVisible(false);
        tipSecondBtn.setDescription("ex. year, similarity, etc.");
        tipTwoPanel.addComponent(tipSecondBtn);
        tipTwoPanel.addComponent(tipSecondText);
        taskContent.addComponent(tipTwoPanel,"task-button4");


        setStyleName("about-view");
        addComponent(taskContent);
        setComponentAlignment(taskContent, Alignment.TOP_CENTER);


//      TODO dodac akcje do buttonow
        sendBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });

//        sendBtn.addClickListener(clickEvent -> viewLogic.saveAnswer(trackInfo));

        prevBtn.addClickListener(clickEvent -> viewLogic.previousTrack());

//        nextBtn.addClickListener(clickEvent -> viewLogic.nextTrack());

        nextBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
//                Track nextTrack = viewLogic.nextTrack();
//
//                final Resource audioResource = new ExternalResource(nextTrack.getTrackUrl());
//                sample.setSource(audioResource);
//                tipFirstText.setValue(nextTrack.getTipOne());
//                tipSecondText.setValue(nextTrack.getTipTwo());
            }
        });

        tipFirstBtn.addClickListener(clickEvent -> viewLogic.getFirstTip());

        tipSecondBtn.addClickListener(clickEvent -> viewLogic.getSecondTip());
    }
}

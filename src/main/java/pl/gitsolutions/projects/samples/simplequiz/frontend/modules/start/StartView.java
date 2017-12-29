package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.start;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.gitsolutions.projects.samples.simplequiz.MyUI;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.task.TaskView;

/**
 * Created by katgr on 12.11.2017.
 */
public class StartView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "startView";

    private String quizDescription = "";

    public StartView(MyUI ui) {
        CustomLayout startContent = new CustomLayout("startView");
        startContent.setStyleName("about-content");

        startContent.addComponent(
                new Label(VaadinIcons.INFO_CIRCLE_O.getHtml()
                        + quizDescription, ContentMode.HTML), "info");

        Button startBtn = new Button();
        startBtn.setCaption("START");
        startContent.addComponent(startBtn,"buttons");

        setSizeFull();
        setMargin(false);
        setStyleName("about-view");
        addComponent(startContent);
        setComponentAlignment(startContent, Alignment.TOP_CENTER);

//        TODO dodac akcje do buttona - przejscie na ekran z zagadkami
        startBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ui.getNavigator().navigateTo(TaskView.VIEW_NAME);
            }
        });
    }

}

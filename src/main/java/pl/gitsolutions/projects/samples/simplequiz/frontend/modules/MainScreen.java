package pl.gitsolutions.projects.samples.simplequiz.frontend.modules;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import pl.gitsolutions.projects.samples.simplequiz.MyUI;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.about.AboutView;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers.AnswerView;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.start.StartView;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.task.TaskView;

/**
 * Created by katgr on 12.11.2017.
 */
public class MainScreen extends HorizontalLayout {

    private Menu menu;

    public MainScreen(MyUI ui) {

        setSpacing(false);
        setStyleName("main-screen");

        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(ui, viewContainer);
        navigator.setErrorView(ErrorView.class);
        menu = new Menu(navigator);
        menu.addView(new StartView(), StartView.VIEW_NAME, "Start", VaadinIcons.STAR_O);
        menu.addView(new TaskView(), TaskView.VIEW_NAME, "Tasks",VaadinIcons.MUSIC);
//        TODO switch to inactive and set active when answered all questions
        menu.addView(new AnswerView(), AnswerView.VIEW_NAME,"Answers", VaadinIcons.EDIT);
//        menu.addInactiveView(new AnswerView(), AnswerView.VIEW_NAME,AnswerView.VIEW_NAME, VaadinIcons.EDIT);
        menu.addView(new AboutView(), AboutView.VIEW_NAME, "About",VaadinIcons.INFO_CIRCLE);

        navigator.addViewChangeListener(viewChangeListener);
        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
    }

    ViewChangeListener viewChangeListener = new ViewChangeListener() {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {
            menu.setActiveView(event.getViewName());
        }

    };
}

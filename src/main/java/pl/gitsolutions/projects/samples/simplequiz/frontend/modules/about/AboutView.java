package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.about;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by katgr on 12.11.2017.
 */
public class AboutView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "aboutView";

    public AboutView() {
        CustomLayout aboutContent = new CustomLayout("aboutView");
        aboutContent.setStyleName("about-content");

        aboutContent.addComponent(
                new Label(VaadinIcons.SMILEY_O.getHtml()
                        + "   ", ContentMode.HTML), "info");

        setSizeFull();
        setMargin(false);
        setStyleName("about-view");
        addComponent(aboutContent);
        setComponentAlignment(aboutContent, Alignment.TOP_CENTER);

    }
}

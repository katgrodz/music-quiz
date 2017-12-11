package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers;

import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

/**
 * Created by katgr on 15.11.2017.
 */
public class AnswerFormDesign extends CssLayout {
    protected TextField artist;
    protected TextField title;
    protected TextField album;
    protected TextField year;
    protected Button close;
    protected Button wiki;
//    protected Audio player;

    public AnswerFormDesign() {
        Design.read(this);
    }
}
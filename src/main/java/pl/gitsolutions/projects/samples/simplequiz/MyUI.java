package pl.gitsolutions.projects.samples.simplequiz;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.MainScreen;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.authentication.AccessControl;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.authentication.BasicAccessControl;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.authentication.LoginScreen;
import pl.gitsolutions.projects.samples.simplequiz.frontend.modules.start.StartView;

import javax.servlet.annotation.WebServlet;

/**
 * Created by katgr on 12.11.2017.
 */
@SpringUI
@Theme("mytheme")
@PreserveOnRefresh
public class MyUI extends UI {

    private AccessControl accessControl = new BasicAccessControl();

    @Autowired
    TrackGateway trackGateway;

    @Autowired
    AnswerGateway answerGateway;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Music Quiz");
        if (!accessControl.isUserSignedIn()) {
            setContent(new LoginScreen(accessControl, new LoginScreen.LoginListener() {
                @Override
                public void loginSuccessful() {
                    showMainView();
                }
            }));
        } else {
            showMainView();
        }
    }

    protected void showMainView() {
        addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new MainScreen(MyUI.this, trackGateway, answerGateway));
//        getNavigator().navigateTo(getNavigator().getState());
        getNavigator().navigateTo(StartView.VIEW_NAME);
    }

    public static MyUI get() {
        return (MyUI) UI.getCurrent();
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

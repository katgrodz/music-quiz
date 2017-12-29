package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;

/**
 * Created by katgr on 12.11.2017.
 */
public class AnswerView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "answerView";

    private AnswerGrid grid;
    private AnswerForm form;

    private AnswerViewLogic viewLogic = new AnswerViewLogic(this);

//    TODO: do dodania trackform - boczny panel z info o utworze

    public AnswerView(AnswerGateway answerGateway) {

        setSizeFull();
        addStyleName("crud-view");
//        HorizontalLayout topLayout = createTopBar();

        grid = new AnswerGrid();
//        grid.setDataProvider((sortOrders, offset, limit) -> answerGateway.findMyAnswers(1L).stream(),() -> answerGateway.count(1L));
        grid.setDataProvider((sortOrders, offset, limit) -> answerGateway.findMyAnswers(1L).stream(),() -> answerGateway.findMyAnswers(1L).size());
        grid.getDataProvider().refreshAll();
        grid.asSingleSelect().addValueChangeListener(
                event -> viewLogic.rowSelected(event.getValue()));

//        form = new TrackForm(viewLogic,grid);

        VerticalLayout barAndGridLayout = new VerticalLayout();
//        barAndGridLayout.addComponent(topLayout);
        barAndGridLayout.addComponent(grid);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.setExpandRatio(grid, 1);
        barAndGridLayout.setStyleName("crud-main-layout");

        addComponent(barAndGridLayout);
//        addComponent(form);

        viewLogic.init();

    }

    public HorizontalLayout createTopBar(){
        return  null;
    }

    public void editAnswer(TrackInfoDto trackInfoDto) {
        if (trackInfoDto != null) {
//            form.addStyleName("visible");
//            form.setEnabled(true);
        } else {
//            form.removeStyleName("visible");
//            form.setEnabled(false);
        }
//        form.editAnswer(trackInfoDto);
    }
}

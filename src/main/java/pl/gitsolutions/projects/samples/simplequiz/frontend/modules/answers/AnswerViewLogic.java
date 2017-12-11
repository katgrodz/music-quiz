package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers;

import pl.gitsolutions.projects.samples.simplequiz.MyUI;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;

/**
 * Created by katgr on 15.11.2017.
 */
public class AnswerViewLogic {

    private AnswerView view;

    public AnswerViewLogic(AnswerView answerView) {
        view = answerView;
    }

    public void init() {
        editAnswer(null);
        // Hide and disable if not admin
        if (!MyUI.get().getAccessControl().isUserInRole("admin")) {
//            view.setNewAnswerEnabled(false);
        }
    }

    public void rowSelected(TrackInfoDto trackInfoDto) {
        if (MyUI.get().getAccessControl().isUserInRole("admin")) {
            view.editAnswer(trackInfoDto);
        }
    }

    public void editAnswer(TrackInfoDto trackInfoDto) {
        if (trackInfoDto == null) {
//            setFragmentParameter("");
        } else {
//            setFragmentParameter(trackInfoDto.getId() + "");
        }
        view.editAnswer(trackInfoDto);
    }
}

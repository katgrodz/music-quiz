package pl.gitsolutions.projects.samples.simplequiz.frontend.modules.answers;

import com.vaadin.server.Page;
import pl.gitsolutions.projects.samples.simplequiz.backend.dto.TrackInfoDto;

/**
 * Created by katgr on 15.11.2017.
 */
public class AnswerForm extends AnswerFormDesign {
    private AnswerViewLogic viewLogic;
    private TrackInfoDto currentTrack;


    public AnswerForm(AnswerViewLogic answerViewLogic, AnswerGrid grid) {
        super();
        addStyleName("product-form");
        viewLogic = answerViewLogic;

        if (grid.getSelectedRow() != null) {
            artist.setValue(grid.getSelectedRow().getArtist());
            title.setValue(grid.getSelectedRow().getTitle());
            album.setValue(grid.getSelectedRow().getAlbum());
            year.setValue(String.valueOf(grid.getSelectedRow().getYear()));
        }

//        artist.setValue(sampleCrudLogic.rowSelected());

        // Mark the stock count field as numeric.
        // This affects the virtual keyboard shown on mobile devices.
//        AttributeExtension stockFieldExtension = new AttributeExtension();
//        stockFieldExtension.setAttribute("type", "number");
    }

    public void editAnswer(TrackInfoDto trackInfoDto) {
        if (trackInfoDto == null) {
            trackInfoDto = new TrackInfoDto();
        }
        currentTrack = trackInfoDto;

        // Scroll to the top
        // As this is not a Panel, using JavaScript
        String scrollScript = "window.document.getElementById('" + getId()
                + "').scrollTop = 0;";
        Page.getCurrent().getJavaScript().execute(scrollScript);
    }

//    public void editProduct(Product product) {
//        if (product == null) {
//            product = new Product();
//        }
//        currentProduct = product;
//        binder.readBean(product);
//
//        // Scroll to the top
//        // As this is not a Panel, using JavaScript
//        String scrollScript = "window.document.getElementById('" + getId()
//                + "').scrollTop = 0;";
//        Page.getCurrent().getJavaScript().execute(scrollScript);
//    }
}

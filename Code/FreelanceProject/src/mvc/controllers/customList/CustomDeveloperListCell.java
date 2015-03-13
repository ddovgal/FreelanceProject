package mvc.controllers.customList;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import mvc.GlobalIntro;
import tables.User;
import util.MessageDialogs;

import java.io.IOException;

/**
 * Created by Error_404 on 12.03.2015.
 */
public class CustomDeveloperListCell extends ListCell<User> {

    private GlobalIntro globalIntro;

    @Override
    protected void updateItem(User item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            FXMLLoader loader = globalIntro.getLoaderWithLocation("views/customListCellForms/CustomDeveloperListCell.fxml");
            HBox hBox = new HBox();
            DeveloperCell developerCell = new DeveloperCell();
            try {
                hBox = loader.load();
                developerCell = loader.getController();
            } catch (IOException e) {
                MessageDialogs.exceptionDialog(e, "Setting developer list cells exception", "Error at setting developer list cells");
            }

            developerCell.setData(item);
            developerCell.init();
            setGraphic(hBox);
        }
    }

    public CustomDeveloperListCell(GlobalIntro globalIntro){
        this.globalIntro = globalIntro;
    }

}

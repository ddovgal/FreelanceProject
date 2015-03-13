package mvc.controllers.customList;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import mvc.GlobalIntro;
import tables.Order;
import util.MessageDialogs;

import java.io.IOException;

/**
 * Created by Error_404 on 08.03.2015.
 */
public class CustomOrderListCell extends ListCell<Order> {

    private GlobalIntro globalIntro;

    @Override
    protected void updateItem(Order item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            FXMLLoader loader = globalIntro.getLoaderWithLocation("views/customListCellForms/CustomOrderListCell.fxml");
            HBox hBox = new HBox();
            OrderCell orderCell = new OrderCell();
            try {
                hBox = loader.load();
                orderCell = loader.getController();
            } catch (IOException e) {
                MessageDialogs.exceptionDialog(e, "Setting order list cells exception", "Error at setting order list cells");
            }

            orderCell.setData(item);
            orderCell.init();
            setGraphic(hBox);
        }
    }

    public CustomOrderListCell(GlobalIntro globalIntro){
        this.globalIntro = globalIntro;
    }

}

package mvc.controllers.customList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tables.Order;
import tables.User;

/**
 * Created by Error_404 on 08.03.2015.
 */
public class OrderCell {

    @FXML
    private Label orderTitleLabel;
    @FXML
    private ImageView isDoneImage;
    @FXML
    private Label deadlineLabel;
    @FXML
    private ImageView devImage;
    @FXML
    private Label devSnfLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label priceLabel;

    private Order currentOrder;

    public void init(){
        orderTitleLabel.setText(currentOrder.getTitle());
        deadlineLabel.setText(currentOrder.getDeadline());
        descriptionLabel.setText(currentOrder.getDescription());
        priceLabel.setText(Double.toString(currentOrder.getPrice()));

        if (currentOrder.getDeveloperId()==0) {
            isDoneImage.setImage(new Image("mvc/views/images/noDev.png"));
            devSnfLabel.setText("No developer");
        } else {
            devImage.setImage(User.findById(currentOrder.getDeveloperId()).getImage());
            String[] tmpMas = User.findById(currentOrder.getDeveloperId()).getSnf().split(" ");
            devSnfLabel.setText(tmpMas[0]+ " "+ tmpMas[1]);
            if (currentOrder.getFinished()) isDoneImage.setImage(new Image("mvc/views/images/done.png"));
            else isDoneImage.setImage(new Image("mvc/views/images/notYet.png"));
        }
    }

    public void setData(Order currentOrder){
        this.currentOrder = currentOrder;
    }

}

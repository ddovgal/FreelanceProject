package mvc.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by Error_404 on 07.03.2015.
 */
public class NewOrderController {

    @FXML
    private TextField nameField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField priceField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private TextArea agreementArea;
    @FXML
    private Button button;

    private int customerId;

    public void init(int customerId){
        this.customerId = customerId;
    }

    @FXML
    private boolean onClick(){ //TODO: change
        return true;
    }

}

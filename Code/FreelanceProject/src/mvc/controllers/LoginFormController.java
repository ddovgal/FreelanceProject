package mvc.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import mvc.GlobalIntro;
import org.javalite.activejdbc.Base;
import tables.User;
import util.MessageDialogs;


/**
 * Created by Error_404 on 03.03.2015.
 */
public class LoginFormController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;
    @FXML
    private ImageView image;
    @FXML
    private CheckBox ipCheckbox;
    @FXML
    private TextField ipField;

    private GlobalIntro globalIntro;

    public void setGlobalIntro(GlobalIntro globalIntro){
        this.globalIntro = globalIntro;
    }

    @FXML
    private void onClick(){
        String dbHost = "localhost";
        String login = loginField.getText();
        String password = passwordField.getText();
        boolean connectByIp = ipCheckbox.isSelected();

        if (connectByIp){
            if (ipField.getText().equals("")){
                messageLabel.setText("Enter correct ip address.");
                return;
            }
            dbHost = ipField.getText();
        }

        try {
            if (!Base.hasConnection())
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://"+ dbHost+ ":3306/freelancedb", "admin", "1111");
        } catch (Exception e){
            MessageDialogs.exceptionDialog(e, "Connection Exception", "Error at connection to current database");
        }

        User tmpUser = User.findByLogin(login);
        if (tmpUser==null) messageLabel.setText("No such user. Check user name.");
        else if (tmpUser.getTypeOfUserId()!=2) messageLabel.setText("Its not a customer. Please enter a customer login.");
        else if (!tmpUser.getPassword().equals(password)) messageLabel.setText("Wrong password.");
        else {
            messageLabel.setText("Welcome back, "+ tmpUser.getSnf().split(" ")[1]);
            globalIntro.initMainIntro((Integer) tmpUser.getId());
        }
    }

    @FXML
    private void cbAction(){
        ipField.setDisable(!ipCheckbox.isSelected());
    }

    @FXML
    private void onMouseInImage(){
        image.setOpacity(0.5);
    }

    @FXML
    private void onMouseOutImage(){
        image.setOpacity(1);
    }

}

package mvc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import mvc.GlobalIntro;
import tables.User;
import util.MessageDialogs;

import java.io.IOException;

/**
 * Created by Error_404 on 04.03.2015.
 */
public class MainIntroFormController {

    private GlobalIntro globalIntro;
    private Stage primaryStage;
    private int userId;

    @FXML
    private ImageView userImage;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Button editProfileButton;
    @FXML
    private Button newOrderButton;
    @FXML
    private Button myMessagesButton;
    @FXML
    private Button signOutButtom;
    @FXML
    private ListView<BorderPane> orderList;
    @FXML
    private ListView<BorderPane> workingDevelopersList;

    public void initStage(GlobalIntro globalIntro){
        this.globalIntro = globalIntro;
        primaryStage = globalIntro.getPrimaryStage();
        userId = globalIntro.getCurrentUserId();

        User currentUser = User.findById(userId);

        Image userLogo = currentUser.getImage();
        if (userLogo!=null) userImage.setImage(userLogo);
        else userImage.setImage(new Image("mvc/views/user.jpg"));

        String[] tmpMas = currentUser.getSnf().split(" ");
        nameLabel.setText(tmpMas[0]+ " "+ tmpMas[1]);

        emailLabel.setText(currentUser.getEmail());
        //orderList TODO: change
        //workingDevelopersList TODO: change
    }

    @FXML
    private void showNewOrderStage(){
        globalIntro.showNewOrderStage();
        /*Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/NewOrederFrame.fxml"));

        try {
            FlowPane root = loader.load();
            //MainIntroFormController controller = loader.getController();

            primaryStage.setTitle("Add nw order");
            primaryStage.setScene(new Scene(root));
            primaryStage.getIcons().add(new Image("mvc/views/favicon.png"));

            //controller.initStage(this); TODO: change

            //this.primaryStage = primaryStage;
            primaryStage.showAndWait();
        } catch (IOException e) {
            MessageDialogs.exceptionDialog(e, "Creating Add new order form exception", "Error at creating Add new order form");
        }*/
    }

}

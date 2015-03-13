package mvc.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.GlobalIntro;
import mvc.controllers.customList.CustomDeveloperListCell;
import mvc.controllers.customList.CustomOrderListCell;
import tables.Order;
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
    private ListView<Order> orderList;
    @FXML
    private ListView<User> workingDevelopersList;

    private ObservableList<Order> orders;
    private ObservableList<User> developers = FXCollections.observableArrayList();


    public void initStage(GlobalIntro globalIntro){
        this.globalIntro = globalIntro;
        primaryStage = globalIntro.getPrimaryStage();
        userId = globalIntro.getCurrentUserId();
        orders = FXCollections.observableArrayList(Order.findByCustomerId(userId));
        for (Order order : orders){
            User developer = User.findById(order.getDeveloperId());
            if (developer!=null) developers.add(developer);
        }

        User currentUser = User.findById(userId);

        userImage.setImage(currentUser.getImage());
        String[] tmpMas = currentUser.getSnf().split(" ");
        nameLabel.setText(tmpMas[0]+ " "+ tmpMas[1]);
        emailLabel.setText(currentUser.getEmail());

        orderList.setItems(orders);
        orderList.setCellFactory(param -> new CustomOrderListCell(globalIntro));

        workingDevelopersList.setItems(developers);
        workingDevelopersList.setCellFactory(param -> new CustomDeveloperListCell(globalIntro));
        //Disabling items selection
        workingDevelopersList.getSelectionModel().selectedIndexProperty().addListener((observable, oldvalue, newValue) -> {
            Platform.runLater(() -> workingDevelopersList.getSelectionModel().select(-1));
        });

    }

    @FXML
    private void showEditProfileStage(){
        System.out.println("showEditProfileStage");
    } //TODO: change

    @FXML
    private void showNewOrderStage(){
        Stage newOrderStage = new Stage();
        FXMLLoader loader = globalIntro.getLoaderWithLocation("views/NewOrederFrame.fxml");

        try {
            VBox root = loader.load();
            NewOrderController controller = loader.getController();

            newOrderStage.setTitle("Add new order");
            newOrderStage.setScene(new Scene(root));
            newOrderStage.getIcons().add(new Image("mvc/views/images/favicon.png"));

            controller.init(userId);

            newOrderStage.showAndWait(); //TODO: (maybe !!!!) change
        } catch (IOException e) {
            MessageDialogs.exceptionDialog(e, "Creating Add new order form exception", "Error at creating Add new order form");
        }
    }

    @FXML
    private void showMyMessagesStage(){
        System.out.println("showMyMessagesStage");
    } //TODO: change

    @FXML
    private void signOut(){
        System.out.println("signOut");
    } //TODO: change

    @FXML
    private void onCellClick(){
        System.out.println("onCellClick"+ orderList.getSelectionModel().getSelectedIndex());
    } //TODO: change

}

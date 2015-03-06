package mvc;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import mvc.controllers.LoginFormController;
import mvc.controllers.MainIntroFormController;
import org.javalite.activejdbc.Base;
import util.MessageDialogs;

import java.io.IOException;

/**
 * Created by Error_404 on 03.03.2015.
 */
public class GlobalIntro extends Application{

    private Stage primaryStage;
    private int currentUserId;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/loginForm/LoginForm.fxml"));
        Parent root = loader.load();
        LoginFormController controller = loader.getController();
        controller.setGlobalIntro(this);

        primaryStage.setTitle("Login form");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("mvc/views/loginForm/loginIcon.png"));
        primaryStage.setMinHeight(390);
        primaryStage.setMaxHeight(500);
        primaryStage.setMinWidth(250);
        primaryStage.setMaxWidth(500);

        this.primaryStage = primaryStage;
        primaryStage.show();
    }

    public void initMainIntro(int userId){

        currentUserId = userId;

        PauseTransition delay = new PauseTransition(Duration.seconds(1.75));
        delay.setOnFinished( event -> {
            primaryStage.close();
            startMainIntro(new Stage());
        } );
        delay.play();
    }

    private void startMainIntro(Stage primaryStage){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/MainIntroForm.fxml"));

        try {
            SplitPane root = loader.load();
            MainIntroFormController controller = loader.getController();

            primaryStage.setTitle("Freelance System");
            primaryStage.setScene(new Scene(root));
            primaryStage.getIcons().add(new Image("mvc/views/favicon.png"));

            controller.initStage(this);

            this.primaryStage = primaryStage;
            primaryStage.show();
        } catch (IOException e) {
            MessageDialogs.exceptionDialog(e, "Creating Main form exception", "Error at creating Main form");
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

    @Override
    public void stop() throws Exception {
        if (Base.hasConnection()) Base.close();
        System.out.println("GlobalIntro stop method");
        super.stop();
    }
}

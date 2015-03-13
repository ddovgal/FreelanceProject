package mvc.controllers.customList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import tables.User;

/**
 * Created by Error_404 on 12.03.2015.
 */
public class DeveloperCell {

    @FXML
    private ImageView devImage;
    @FXML
    private Label devSnfLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private ProgressBar ratingBar;
    @FXML
    private Button ordersButton;
    @FXML
    private Button rateHimButton;
    @FXML
    private Button messageHimButton;
    @FXML
    private Button smthElseButton;

    private User currentDeveloper;

    public void init(){
        devImage.setImage(currentDeveloper.getImage());
        String[] tmpMas = currentDeveloper.getSnf().split(" ");
        devSnfLabel.setText(tmpMas[0]+ " "+ tmpMas[1]);
        emailLabel.setText(currentDeveloper.getEmail());
        ratingBar.setProgress(currentDeveloper.getRating()/100);
    }

    public void setData(User currentDeveloper){
        this.currentDeveloper = currentDeveloper;
    }

    @FXML
    private void ordersAction(){
        int index =  ((CustomDeveloperListCell)ordersButton.getParent().getParent().getParent()).getIndex();
        System.out.println("ordersAction"+ index);
    }

    @FXML
    private void rateAction(){
        int index =  ((CustomDeveloperListCell)rateHimButton.getParent().getParent().getParent()).getIndex();
        System.out.println("rateAction"+ index);
    }

    @FXML
    private void messageAction(){
        int index =  ((CustomDeveloperListCell)messageHimButton.getParent().getParent().getParent()).getIndex();
        System.out.println("messageAction"+ index);
    }

    @FXML
    private void smthAction(){
        int index =  ((CustomDeveloperListCell)smthElseButton.getParent().getParent().getParent()).getIndex();
    }

}

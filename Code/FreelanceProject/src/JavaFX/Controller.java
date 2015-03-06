package JavaFX;

import tables.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.InitException;

public class Controller {

    @FXML
    Button ok;
    @FXML
    TextField loginF;
    @FXML
    TextField passF;
    @FXML
    TextField ipF;
    String login = "";
    String pass = "";

    public void onClick(){
        try {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://"+ ipF.getText()+ ":3306/freelancedb", "admin", "1111");
            login = loginF.getText();
            pass = passF.getText();
            User user = User.findByLogin(login);
            if (user.getPassword().equals(pass)){
                loginF.setText(user.getSnf());
            } else loginF.setText("Uncorrect login or password");
        } catch (InitException initE){
            loginF.setText("Error in connection");
        }
        catch (Exception e) {
            loginF.setText("Some error ;(");
            e.printStackTrace();}
        finally {
            Base.close();
        }
    }

}

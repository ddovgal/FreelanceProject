package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("user")
public class User extends Model {

    public void setTypeOfUserId(int id){
        setInteger("type_of_user_id", id);
    }

    public int getTypeOfUserId(){
        return getInteger("type_of_user_id");
    }

    public void setLogin(String login){
        setString("login", login);
    }

    public String getLogin(){
        return getString("login");
    }

    public void setPassword(String password){
        setString("password", password);
    }

    public String getPassword(){
        return getString("password");
    }

    public void setSnf(String snf){
        setString("snf", snf);
    }

    public String getSnf(){
        return getString("snf");
    }

    public void setBirthday(String birthday){
        setDate("birthday", birthday);
    }

    public String getBirthday(){
        return getDate("birthday").toString();
    }

    public void setEmail(String email){
        setString("email", email);
    }

    public String getEmail(){
        return getString("email");
    }

    public void setRating(double rating){
        setInteger("rating", rating);
    }

    public double getRating(){
        return getDouble("rating");
    }

}

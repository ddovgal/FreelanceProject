package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("user")
public class User extends Model {

    private static Object justCreatedRowId;

    public User(){}

    private User(int type, String login, String password, String snf){
        User tmp = new User();
        tmp.setTypeOfUserId(type);
        tmp.setLogin(login);
        tmp.setPassword(password);
        tmp.setSnf(snf);
        tmp.setRating(0);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static User newInstance(int type, String login, String password, String snf){
        new User(type, login, password, snf);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static User findById(int id){
        return findById(new Integer(id));
    }

    public static List<User> findByTypeOfUserId(int id){
        return where("type_of_user_id = ?", id);
    }

    public static User findByLogin(String login){
        return findFirst("login = ?", login);
    }

    public static User findByPassword(String password){
        return findFirst("password = ?", password);
    }

    public static User findBySnf(String snf){
        return findFirst("snf = ?", snf);
    }

    public static List<User> findByBirthday(String birthday){
        return where("birthday = ?", birthday);
    }

    public static List<User> findByEmail(String email){
        return where("email = ?", email);
    }

    public static List<User> findByRating(double rating){
        return where("rating = ?", rating);
    }

    //----------------------------------------------Setters and getters-------------------------------------------------

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

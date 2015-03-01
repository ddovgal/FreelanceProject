package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("response")
public class Response extends Model {

    private static Object justCreatedRowId;

    public Response(){}

    private Response(int userId, int userType, String text, String date, double mark){
        Response tmp = new Response();
        tmp.setUserId(userId);
        tmp.setUserType(userType);
        tmp.setText(text);
        tmp.setDate(date);
        tmp.setMark(mark);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static Response newInstance(int userId, int userType, String text, String date, double mark){
        new Response(userId, userType, text, date, mark);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static Response findById(int id){
        return findById(new Integer(id));
    }

    public static List<Response> findByUserId(int id){
        return where("user_id = ?", id);
    }

    public static List<Response> findByUserType(int userType){
        return where("user_type = ?", userType);
    }

    public static Response findByText(String text){
        return findFirst("text = ?", text);
    }

    public static Response findByDate(String date){
        return findFirst("date = ?", date);
    }

    public static List<Response> findByMark(double mark){
        return where("mark = ?", mark);
    }

    //----------------------------------------------Setters and getters-------------------------------------------------

    public void setUserId(int id){
        setInteger("user_id", id);
    }

    public int getUserId(){
        return getInteger("user_id");
    }

    public void setUserType(int userType){
        setInteger("user_type", userType);
    }

    public int getUserType(){
        return getInteger("user_type");
    }

    public void setText(String text){
        setString("text", text);
    }

    public String getText(){
        return getString("text");
    }

    public void setDate(String date){
        setDate("date", date);
    }

    public String getDate(){
        return getDate("date").toString();
    }

    public void setMark(double mark){
        setDouble("mark", mark);
    }

    public double getMark(){
        return getDouble("mark");
    }

}

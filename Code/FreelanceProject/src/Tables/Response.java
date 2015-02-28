package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("response")
public class Response extends Model {

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
        setInteger("mark", mark);
    }

    public double getMark(){
        return getDouble("mark");
    }

}

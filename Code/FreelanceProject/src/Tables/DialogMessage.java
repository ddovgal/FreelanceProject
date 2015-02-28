package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("dialog_message")
public class DialogMessage extends Model {

    public void setSenderId(int id){
        setInteger("sender_id", id);
    }

    public int getSenderId(){
        return getInteger("sender_id");
    }

    public void setSenderType(int userType){
        setInteger("sender_type", userType);
    }

    public int getSenderType(){
        return getInteger("sender_type");
    }

    public void setReceiverId(int id){
        setInteger("receiver_id", id);
    }

    public int getReceiverId(){
        return getInteger("receiver_id");
    }

    public void setText(String text){
        setString("text", text);
    }

    public String getText(){
        return getString("text");
    }

    public void setTime(String time){
        setDate("time", time);
    }

    public String getTime(){
        return getDate("time").toString();
    }

}

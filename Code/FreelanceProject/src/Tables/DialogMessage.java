package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("dialog_message")
public class DialogMessage extends Model {

    private static Object justCreatedRowId;

    public DialogMessage(){}

    private DialogMessage(int senderId, int userType, int receiverId, String text, String time){
        DialogMessage tmp = new DialogMessage();
        tmp.setSenderId(senderId);
        tmp.setSenderType(userType);
        tmp.setReceiverId(receiverId);
        tmp.setText(text);
        tmp.setTime(time);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static DialogMessage newInstance(int senderId, int userType, int receiverId, String text, String time){
        new DialogMessage(senderId, userType, receiverId, text, time);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static DialogMessage findById(int id){
        return findById(new Integer(id));
    }

    public static List<DialogMessage> findBySenderId(int id){
        return where("sender_id = ?", id);
    }

    public static List<DialogMessage> findBySenderType(int userType){
        return where("sender_type = ?", userType);
    }

    public static List<DialogMessage> findByReceiverId(int id){
        return where("receiver_id = ?", id);
    }

    public static DialogMessage findByText(String text){
        return findFirst("text = ?", text);
    }

    public static DialogMessage findByTime(String time){
        return findFirst("time = ?", time);
    }

    //----------------------------------------------Setters and getters-------------------------------------------------

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

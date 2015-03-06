package tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("complaint")
public class Complaint extends Model {

    private static Object justCreatedRowId;

    public Complaint(){}

    private Complaint(int userId, int userType, String text,int problemOrderId){
        Complaint tmp = new Complaint();
        tmp.setUserId(userId);
        tmp.setUserType(userType);
        tmp.setText(text);
        tmp.setProblemOrderId(problemOrderId);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static Complaint newInstance(int userId, int userType, String text,int problemOrderId){
        new Complaint(userId, userType, text, problemOrderId);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static Complaint findById(int id){
        return findById(new Integer(id));
    }

    public static List<Complaint> findByUserId(int id){
        return where("user_id = ?", id);
    }

    public static List<Complaint> findByUserType(int userType){
        return where("user_type = ?", userType);
    }

    public static Complaint findByText(String text){
        return findFirst("text = ?", text);
    }

    public static List<Complaint> findByProblemOrderId(int problemOrderId){
        return where("problem_order_id = ?", problemOrderId);
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

    public void setProblemOrderId(int problemOrderId){
        setInteger("problem_order_id", problemOrderId);
    }

    public int getProblemOrderId(){
        return getInteger("problem_order_id");
    }

}

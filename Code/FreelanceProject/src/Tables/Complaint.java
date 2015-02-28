package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("complaint")
public class Complaint extends Model {

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

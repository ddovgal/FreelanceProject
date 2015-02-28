package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("service_message")
public class ServiceMessage extends Model {

    public void setAdminId(int id){
        setInteger("admin_id", id);
    }

    public int getAdminId(){
        return getInteger("admin_id");
    }

    public void setProblemOrder_Id(int id){
        setInteger("problem_order_id", id);
    }

    public int getProblemOrder_Id(){
        return getInteger("problem_order_id");
    }

    public void setVictimId(int id){
        setInteger("victim_id", id);
    }

    public int getVictimId(){
        return getInteger("victim_id");
    }

    public void setVictimType(int victimType){
        setInteger("victim_type", victimType);
    }

    public int getVictimType(){
        return getInteger("victim_type");
    }

    public void setGuiltyId(int id){
        setInteger("guilty_id", id);
    }

    public int getGuiltyId(){
        return getInteger("guilty_id");
    }

    public void setText(String text){
        setString("text", text);
    }

    public String getText(){
        return getString("text");
    }

}

package tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("service_message")
public class ServiceMessage extends Model {

    private static Object justCreatedRowId;

    public ServiceMessage(){}

    private ServiceMessage(int adminId, int problemOrderId, int victimId, int victimType, int guiltyId, String text, boolean readed){
        ServiceMessage tmp = new ServiceMessage();
        tmp.setAdminId(adminId);
        tmp.setProblemOrderId(problemOrderId);
        tmp.setVictimId(victimId);
        tmp.setVictimType(victimType);
        tmp.setGuiltyId(guiltyId);
        tmp.setText(text);
        tmp.setReaded(readed);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static ServiceMessage newInstance(int adminId, int problemOrderId, int victimId, int victimType, int guiltyId, String text, boolean readed){
        new ServiceMessage(adminId, problemOrderId, victimId, victimType, guiltyId, text, readed);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static ServiceMessage findById(int id){
        return findById(new Integer(id));
    }

    public static List<ServiceMessage> findByAdminId(int id){
        return where("admin_id = ?", id);
    }

    public static List<ServiceMessage> findByProblemOrderId(int id){
        return where("problem_order_id = ?", id);
    }

    public static List<ServiceMessage> findByVictimId(int id){
        return where("victim_id = ?", id);
    }

    public static List<ServiceMessage> findByVictimType(int victimType){
        return where("victim_type = ?", victimType);
    }

    public static List<ServiceMessage> findByGuiltyId(int id){
        return where("guilty_id = ?", id);
    }

    public static ServiceMessage findByText(String text){
        return findFirst("text = ?", text);
    }

    public static List<ServiceMessage> findByReaded(boolean readed){
        return where("readed = ?", readed);
    }

    //----------------------------------------------Setters and getters-------------------------------------------------

    public void setAdminId(int id){
        setInteger("admin_id", id);
    }

    public int getAdminId(){
        return getInteger("admin_id");
    }

    public void setProblemOrderId(int id){
        setInteger("problem_order_id", id);
    }

    public int getProblemOrderId(){
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

    public void setReaded(boolean readed){
        setBoolean("readed", readed);
    }

    public boolean getReaded(){
        return getBoolean("readed");
    }

}

package tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 06.03.2015.
 */
@Table("applicant_to_order")
public class ApplicantToOrder extends Model {
    
    private static Object justCreatedRowId;
    
    public ApplicantToOrder(){}

    private ApplicantToOrder(int orderId, int developerId){
        ApplicantToOrder tmp = new ApplicantToOrder();
        tmp.setOrderId(orderId);
        tmp.setDeveloperId(developerId);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static ApplicantToOrder newInstance(int orderId, int developerId){
        new ApplicantToOrder(orderId, developerId);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static ApplicantToOrder findById(int id){
        return findById(new Integer(id));
    }

    public static List<ApplicantToOrder> findByOrderId(int id){
        return where("order_id = ?", id);
    }

    public static List<ApplicantToOrder> findByDeveloperId(int id){
        return where("developer_id = ?", id);
    }

    //----------------------------------------------Setters and getters-------------------------------------------------

    public void setOrderId(int id){
        setInteger("order_id", id);
    }

    public int getOrderId(){
        return getInteger("order_id");
    }

    public void setDeveloperId(int id){
        setInteger("developer_id", id);
    }

    public int getDeveloperId(){
        return getInteger("developer_id");
    }

}

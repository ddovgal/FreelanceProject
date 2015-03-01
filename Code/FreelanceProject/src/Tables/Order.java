package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("`order`")
public class Order extends Model {

    private static Object justCreatedRowId;

    public Order(){}

    private Order(String description, String deadline, double price, int customerId, String agreement){
        Order tmp = new Order();
        tmp.setDescription(description);
        tmp.setDeadline(deadline);
        tmp.setPrice(price);
        tmp.setFinished(false);
        tmp.setCustomerId(customerId);
        tmp.setAgreement(agreement);
        tmp.saveIt();
        justCreatedRowId = tmp.getId();
    }

    public static Order newInstance(String description, String deadline, double price, int customerId, String agreement){
        new Order(description, deadline, price, customerId, agreement);
        return findById(justCreatedRowId);
    }

    //------------------------------------------------------Find--------------------------------------------------------

    public static Order findById(int id){
        return findById(new Integer(id));
    }

    public static Order findByDescription(String description){
        return findFirst("description = ?", description);
    }

    public static List<Order> findByDeadline(String deadline){
        return where("deadline = ?", deadline);
    }

    public static List<Order> findByPrice(double price){
        return where("price = ?", price);
    }

    public static List<Order> findByFinished(boolean finished){
        return where("finished = ?", finished);
    }

    public static List<Order> findByCustomerId(int id){
        return where("customer_id = ?", id);
    }

    public static List<Order> findByDeveloperId(int id){
        return where("developer_id = ?", id);
    }

    public static Order findByAgreement(String agreement){
        return findFirst("agreement = ?", agreement);
    }

    //----------------------------------------------Setters and getters-------------------------------------------------

    public void setDescription(String description){
        setString("description", description);
    }

    public String getDescription(){
        return getString("description");
    }

    public void setDeadline(String deadline){
        setDate("deadline", deadline);
    }

    public String getDeadline(){
        return getDate("deadline").toString();
    }

    public void setPrice(double price){
        setDouble("price", price);
    }

    public double getPrice(){
        return getDouble("price");
    }

    public void setFinished(boolean finished){
        setBoolean("finished", finished);
    }

    public boolean getFinished(){
        return getBoolean("finished");
    }

    public void setCustomerId(int id){
        setInteger("customer_id", id);
    }

    public int getCustomerId(){
        return getInteger("customer_id");
    }

    public void setDeveloperId(int id){
        setInteger("developer_id", id);
    }

    public int getDeveloperId(){
        return getInteger("developer_id");
    }

    public void setAgreement(String agreement){
        setString("agreement", agreement);
    }

    public String getAgreement(){
        return getString("agreement");
    }

}

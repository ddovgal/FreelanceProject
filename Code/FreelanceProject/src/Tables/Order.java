package Tables;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by Error_404 on 27.02.2015.
 */
@Table("`order`")
public class Order extends Model {

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

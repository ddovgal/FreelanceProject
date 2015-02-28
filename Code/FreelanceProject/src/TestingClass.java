import Tables.*;
import org.javalite.activejdbc.Base;

public class TestingClass {
    public static void main(String[] args) {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/freelancedb", "root", "1111");
        System.out.println(User.findFirst("login = ?", "admin").get("snf"));
        System.out.println(Order.findFirst("description = ?", "do nothing").get("agreement"));
        System.out.println(Complaint.findById(1).get("text"));
        System.out.println(ServiceMessage.findFirst("id = ?", "1").get("text"));
        System.out.println(DialogMessage.findFirst("id = ?", "1").get("text"));
        System.out.println(UserType.findFirst("id = ?", "1").get("name"));

        System.out.println();
        Order order = Order.findFirst("description = ?", "do nothing");
        System.out.println(order.getAgreement());
        System.out.println();

        User user = User.findById(2);
        System.out.println(UserType.findById(user.getTypeOfUserId()).get("name"));

        Base.close();

    }
}

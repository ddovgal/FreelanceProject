import Tables.Complaint;
import Tables.DialogMessage;
import org.javalite.activejdbc.Base;

public class TestingClass {
    public static void main(String[] args) {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/freelancedb", "root", "1111");


        /*System.out.println(User.findFirst("login = ?", "admin").get("snf"));
        System.out.println(Order.findFirst("description = ?", "do nothing").get("agreement"));
        System.out.println(Complaint.findById(1).get("text"));
        System.out.println(ServiceMessage.findFirst("id = ?", "1").get("text"));
        System.out.println(DialogMessage.findFirst("id = ?", "1").get("text"));
        System.out.println(UserType.findFirst("id = ?", "1").get("name"));

        System.out.println();
        Order order = Order.findFirst("description = ?", "do nothing");
        System.out.println(order.getAgreement());
        System.out.println();

        System.out.println();
        Complaint.findByProblemOrderId(1).get(0).getText();
        System.out.println(Complaint.findByUserId(2).get(0).getText());
        System.out.println();

        User user = User.findById(2);
        System.out.println(UserType.findById(user.getTypeOfUserId()).get("name"));

        System.out.println(Order.findById(1).getAgreement());
        //new Order("sd", "1990-11-11", 12.44, 2, "dsd");*/


        Complaint complaint = Complaint.newInstance(3, 3, "Плохо себя вел", 1);
        complaint.setText("Not true");
        complaint.saveIt();

        DialogMessage dialogMessage = DialogMessage.newInstance(3, 3, 2, "Hello", "1111-11-11");
        System.out.println(dialogMessage.getText());
        dialogMessage.setText("Text 2");
        System.out.println(dialogMessage.getText());
        dialogMessage.saveIt();
        System.out.println(dialogMessage.getText());

        Base.close();

    }
}

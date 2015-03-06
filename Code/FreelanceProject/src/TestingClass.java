import org.javalite.activejdbc.Base;
import org.javalite.test.jspec.TestException;
import tables.User;

import java.io.File;


public class TestingClass {
    public static void main(String[] args) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/freelancedb", "root", "1111");

        User user = User.findByLogin("test");

        user.setImage(new File("My avatar.jpg"));
        user.saveIt();

        //Image image = user.getImage();
        //System.out.println();
        /*//-------------
        FileInputStream fileInputStream=null;

        File file = new File("My avatar.jpg");

        byte[] imageBytes = new byte[(int) file.length()];

        try {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageBytes);
            fileInputStream.close();
            System.out.println("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
        user.set("image", imageBytes);
        user.saveIt();
        //-------------

        //-------------
        byte[] image1Bytes = user.getBytes("image");

        FileOutputStream stream = new FileOutputStream("lol.png");
        try {
            stream.write(image1Bytes);
        } finally {
            stream.close();
        }
        //-------------

        assertEqual(imageBytes, image1Bytes);*/

        Base.close();
    }

    private static void assertEqual(byte[] igor, byte[] igor1) {
        if(igor.length != igor1.length) throw new TestException("arrays not equal");
        for(int i = 0 ; i < igor.length ; i++){
            if(igor[i] != igor1[i])
                throw new TestException("arrays not equal");
        }
    }
}

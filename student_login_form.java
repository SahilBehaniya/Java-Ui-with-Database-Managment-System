import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import Exception;


public class student_login_form extends JFrame{
    public JPanel MAIN;

    public JTextField name;
    public JTextField addr;
    public JButton SUBMITButton;
    public JTextField dob;
    public JTextField num1;
    private JTextField n;
    private JButton Del;
    private JButton update;

    public student_login_form() {
    SUBMITButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String Customer_name =name.getText();
            String add= addr.getText();
            String mobno= student_login_form.this.num1.getText();
            double r =Double.parseDouble(mobno);
            String dob= student_login_form.this.dob.getText();
            String n= student_login_form.this.n.getText();
            Integer id = Integer.parseInt(n);
      try {


    Statement s = getConnection().createStatement();
    String Sahil = "insert into Customer  values('" + Customer_name + "','" + add + "','" + mobno + "','" + dob + "','" + id + "');";
    s.executeUpdate(Sahil);
    s.close();

    JOptionPane.showMessageDialog(SUBMITButton, name.getText() + " Thank you");
    }
   catch(Exception y){

            }
        }
    });
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String Customer_name =name.getText();
//                String add= addr.getText();
//                String mobno= student_login_form.this.num1.getText();
//                double r =Double.parseDouble(mobno);
//                String dob= student_login_form.this.dob.getText();
                String n= student_login_form.this.n.getText();
                Integer id = Integer.parseInt(n);
                try {


                    Statement st = getConnection().createStatement();
                    String S = "delete from  Customer  where res_id='"+ id +"';";
                    st.executeUpdate(S);
                    st.close();

                    JOptionPane.showMessageDialog(SUBMITButton, "Thank You " + name.getText() + " For visiting our cafe\nvisit again...");
                }catch(Exception k){}
            }

        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Customer_name =name.getText();
                String add= addr.getText();

                String mobno= student_login_form.this.num1.getText();
                double r =Double.parseDouble(num1.getText());
                String dob= student_login_form.this.dob.getText();
                String n= student_login_form.this.n.getText();
                Integer id = Integer.parseInt(n);
                try {


                    Statement t = getConnection().createStatement();
                    String up = "update customer set name='"+Customer_name+"',addr='"+add+"',mobno='"+mobno+"',Resdate='"+dob+"' where res_id ='"+id+ "';";
                    t.executeUpdate(up);
                    t.close();

                    JOptionPane.showMessageDialog(SUBMITButton, "Thank You " + name.getText() + " For visiting our cafe\nvisit again...");
                }
                catch(Exception y){

                }
            }
        });
    }

    public static void main(String[] args) {

        student_login_form h = new student_login_form();
        h.setContentPane(h.MAIN);
        h.setTitle("STUDENT FORM");
        h.setSize(1300, 700);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public static Connection getConnection()
    {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String databaseUrl = "jdbc:mysql://localhost:3306/sahil";
                String user = "root";
                String pass = "sahil@123";
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(databaseUrl, user, pass);
                System.out.println("DATABASE CONNECTED");
                return conn;

            }
            catch (Exception e){
                System.out.println("NOT CONNECTED");
            }
            return null;

        }

}



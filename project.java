import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
public class project {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/sahil";
            String user="root";
            String passs="sahil@123";
            Connection con=DriverManager.getConnection(url,user,passs);

            if(con.isClosed())
            {
                System.out.println("not connected");
            }
            else
            {
                System.out.println("connetec");
            }


            JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,300);

            JPanel panel=new JPanel();
            panel.setLayout(new GridLayout(1,1));



            JButton create=new JButton("create");
            create.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        String dd="create table practi(id int, name varchar(255))";
                        Statement s= con.createStatement();
                        s.executeUpdate(dd);
                    }
                    catch (Exception r)
                    {
                        r.printStackTrace();
                    }

                }
            });

            panel.add(create);
            frame.add(panel);
            frame.setVisible(true);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

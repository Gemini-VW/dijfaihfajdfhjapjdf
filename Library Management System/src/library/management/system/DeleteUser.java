
package library.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteUser extends JFrame implements ActionListener
{
    JLabel userNameLabel,textMessage;
    JTextField userNameTxt;
    JButton deleteUser,back;
    
    String un;
   
    public DeleteUser(String un)
    {
        this.un = un;
        
        userNameLabel = new JLabel("User Name: ");
        userNameLabel.setBounds(100,50,150,30);
        add(userNameLabel);
        
        userNameTxt = new JTextField();
        userNameTxt.setBounds(180,55,150,20);
        add(userNameTxt);
        
        textMessage = new JLabel(">> User name field must be filled up <<");
        textMessage.setBounds(120,85,300,30);
        add(textMessage);
        
        deleteUser = new JButton("Delete User");
        deleteUser.setBounds(60,150,150,30);
        deleteUser.setBackground(Color.white);
        deleteUser.setForeground(Color.red);
        add(deleteUser);
        
        back = new JButton("Back");
        back.setBounds(260,150,150,30);
        back.setBackground(Color.white);
        add(back);
        
        back.addActionListener(this);
        deleteUser.addActionListener(this);
        
        setLayout(null);
        setVisible(true);
        setSize(480,320);
        setResizable(false);
        setLocation(480,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String u = userNameTxt.getText();
        
        if(ae.getSource()==deleteUser)
        {
            if(u.length()==0)
            {
                JOptionPane.showMessageDialog(null,"You must provide a user name");
            }
            else
            {
                try
                {
                    String query = "DELETE FROM `user_information` WHERE User_Name = "+'"'+u+'"';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"User deleted...");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                    System.out.println("User not deleted for connection problem");
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new AdminView(this.un);
        }
    }
}


package library.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LibrarianLogIn extends JFrame implements ActionListener
{
    JLabel pleaseLogInLabel;
    JLabel userNameLabel;
    JLabel passwordLabel;
    
    JButton logIn;
    JButton cancel;
    
    JTextField txtUserName;
    JPasswordField txtPassword;
    
    String un;
    char[] pw;
    
    public LibrarianLogIn()
    {
        super("Library Management System Log In Pannel");
        
        pleaseLogInLabel = new JLabel("Please Log in");
        pleaseLogInLabel.setBounds(180,10,100,30);
        add(pleaseLogInLabel);
        
        userNameLabel = new JLabel("User Name: ");
        userNameLabel.setBounds(110,50,150,30);
        add(userNameLabel);
        
        txtUserName = new JTextField();
        txtUserName.setBounds(200,55,150,20);
        add(txtUserName);
        
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(115,80,150,30);
        add(passwordLabel);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(200,85,150,20);
        add(txtPassword);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(100,150,100,30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.red);
        add(cancel);
        
        logIn = new JButton("Log in");
        logIn.setBounds(300,150,100,30);
        logIn.setBackground(Color.white);
        logIn.setForeground(Color.red);
        add(logIn);
        
        
        logIn.addActionListener(this);
        cancel.addActionListener(this);
        
        setLayout(null);
        setBackground(Color.red);
        setResizable(false);
        setSize(480,320);
        setLocation(480,220);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        un = txtUserName.getText();
        pw = txtPassword.getPassword();
        
        if(ae.getSource()==logIn)
        {
            try{
                String query = "Select * from librarian_information where user_name = "+"'"+un+"'"+" and password = "+"'"+new String(pw)+"'";
		Connection c = DatabaseConnection.dbConnector();
		Statement st = c.createStatement();
		ResultSet r = st.executeQuery(query);
                
                int count =0;
                while(r.next())
                {
                    count = count+1;
                }
                if(count>=1)
                {
                    System.out.println(un+" "+new String(pw));
                    JOptionPane.showMessageDialog(null,"Login Successfull");
                    new LibrarianView(un);
                    dispose();
                }
                else
                {
                    System.out.println(un+" "+new String(pw));
                    JOptionPane.showMessageDialog(null,"Username or Password is incorrect!");
                }
                r.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
                System.out.println("Error");
            }
        }
        
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new LibraryManagementSystem();
        }
    }
}

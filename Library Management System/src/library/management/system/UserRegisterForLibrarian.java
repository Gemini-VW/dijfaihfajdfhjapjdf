package library.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UserRegisterForLibrarian extends JFrame implements ActionListener
{
    JLabel firstName,lastName,userName,password,confirmPassword,emailId,contactNo;
    JTextField firstNameTxt,lastNameTxt,userNameTxt,passwordTxt,confirmPasswordTxt,emailIdTxt,contactNoTxt;
    JButton cancel,done;
    
    String un;
    
    public UserRegisterForLibrarian(String un)
    {
        super("Library Management System Registration Panel");
        
        this.un = un;
        
	firstName = new JLabel("First Name:");
	firstName.setBounds(80,30,80,20);
	add(firstName);
        
	firstNameTxt = new JTextField();
	firstNameTxt.setBounds(200,30,150,20);
	firstNameTxt.setBackground(Color.white);
	add(firstNameTxt);
        
        lastName = new JLabel("Last Name:");
	lastName.setBounds(80,60,80,20);
	add(lastName);
		
	lastNameTxt = new JTextField();
	lastNameTxt.setBounds(200,60,150,20);
	lastNameTxt.setBackground(Color.white);
	add(lastNameTxt);	
		
	userName = new JLabel("User Name:");
	userName.setBounds(80,90,150,20);
	add(userName);
		
	userNameTxt = new JTextField();
	userNameTxt.setBounds(200,90,150,20);
	userNameTxt.setBackground(Color.white);
	add(userNameTxt);
		
	password = new JLabel("Passward:");
	password.setBounds(80,120,80,20);
	add(password);
		
	passwordTxt = new JTextField();
	passwordTxt.setBounds(200,120,150,20);
	passwordTxt.setBackground(Color.white);
	add(passwordTxt);
		
	confirmPassword = new JLabel("Confirm Passward:");
	confirmPassword.setBounds(80,150,110,20);
	add(confirmPassword);
		
	confirmPasswordTxt = new JTextField();
	confirmPasswordTxt.setBounds(200,150,150,20);
	confirmPasswordTxt.setBackground(Color.white);
	add(confirmPasswordTxt);
		
	emailId = new JLabel("Email Id:");
	emailId.setBounds(80,180,80,20);
	add(emailId);
		
	emailIdTxt = new JTextField();
	emailIdTxt.setBounds(200,180,150,20);
	emailIdTxt.setBackground(Color.white);
	add(emailIdTxt);
		
	contactNo = new JLabel("Contact No:");
	contactNo.setBounds(80,210,80,20);
	add(contactNo);
		
	contactNoTxt = new JTextField();
	contactNoTxt.setBounds(200,210,150,20);
	contactNoTxt.setBackground(Color.white);
	add(contactNoTxt);
	
	cancel = new JButton("Cancel"); 
	cancel.setBounds(100,240,100,30);
	cancel.setBackground(Color.white);
	add(cancel);
	
        done = new JButton("Done");
	done.setBounds(280,240,100,30);
	done.setBackground(Color.green);
	add(done);
        setLayout(null);
        
        setSize(480,320);
        setLocation(480,220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancel.addActionListener(this);
        done.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String s1 = firstNameTxt.getText();
        String s2 = lastNameTxt.getText();
        String s3 = userNameTxt.getText();
        String s4 = passwordTxt.getText();
        String s5 = confirmPasswordTxt.getText();
        String s6 = emailIdTxt.getText();
        String s7 = contactNoTxt.getText();
        
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            new LibrarianView(this.un);
        }
        
        else if(ae.getSource()==done)
        {
            if(s1.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please insert First name");
            }
            else if(s2.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please insert Last name");
            }
            else if(s3.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please insert User Name");
            }
            else if(s4.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please insert Password");
            }
            else if(s5.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please Confirm Password your password");
            }
            else if(s6.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please insert your Email id");
            }
            else if(s7.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Please give your Contact no");
            }
            else if(s4.length()!=s5.length())
            {
                JOptionPane.showMessageDialog(null,"Password doesn't match!!");
            }
            else
            {
                try
                {
                    String query = "INSERT INTO `user_information`(`First_Name`, `Last_Name`, `User_Name`, `Password`, `Confirm_Password`, `Email_ID`, `Contact_No`) VALUES ("+'"'+s1+'"'+','+'"'+s2+'"'+','+'"'+s3+'"'+','+'"'+s4+'"'+','+'"'+s5+'"'+','+'"'+s6+'"'+','+'"'+s7+'"'+')';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    st.executeUpdate(query);
                    
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"User Created...");
                    new LibrarianView(this.un);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }
}
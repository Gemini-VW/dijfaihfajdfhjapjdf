
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
import javax.swing.JTextField;

public class UpdateUser extends JFrame implements ActionListener
{
    JLabel firstName,lastName,userName,password,confirmPassword,emailId,contactNo;
    JTextField firstNameTxt,lastNameTxt,userNameTxt,passwordTxt,confirmPasswordTxt,emailIdTxt,contactNoTxt;
    JButton updateUser,find,back;
    
    String un;
    
    public UpdateUser(String un)
    {
        this.un = un;
        
        firstName = new JLabel("First Name:");
	firstName.setBounds(80,30,80,20);
        firstName.setVisible(false);
	add(firstName);
        
	firstNameTxt = new JTextField();
	firstNameTxt.setBounds(200,30,150,20);
	firstNameTxt.setBackground(Color.white);
        firstNameTxt.setVisible(false);
	add(firstNameTxt);
        
        lastName = new JLabel("Last Name:");
	lastName.setBounds(80,60,80,20);
        lastName.setVisible(false);
	add(lastName);
		
	lastNameTxt = new JTextField();
	lastNameTxt.setBounds(200,60,150,20);
	lastNameTxt.setBackground(Color.white);
        lastNameTxt.setVisible(false);
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
        password.setVisible(false);
	add(password);
		
	passwordTxt = new JTextField();
	passwordTxt.setBounds(200,120,150,20);
	passwordTxt.setBackground(Color.white);
        passwordTxt.setVisible(false);
	add(passwordTxt);
		
	confirmPassword = new JLabel("Confirm Passward:");
	confirmPassword.setBounds(80,150,110,20);
        confirmPassword.setVisible(false);
	add(confirmPassword);
		
	confirmPasswordTxt = new JTextField();
	confirmPasswordTxt.setBounds(200,150,150,20);
	confirmPasswordTxt.setBackground(Color.white);
        confirmPasswordTxt.setVisible(false);
	add(confirmPasswordTxt);
		
	emailId = new JLabel("Email Id:");
	emailId.setBounds(80,180,80,20);
        emailId.setVisible(false);
	add(emailId);
		
	emailIdTxt = new JTextField();
	emailIdTxt.setBounds(200,180,150,20);
	emailIdTxt.setBackground(Color.white);
        emailIdTxt.setVisible(false);
	add(emailIdTxt);
		
	contactNo = new JLabel("Contact No:");
	contactNo.setBounds(80,210,80,20);
        contactNo.setVisible(false);
	add(contactNo);
		
	contactNoTxt = new JTextField();
	contactNoTxt.setBounds(200,210,150,20);
	contactNoTxt.setBackground(Color.white);
        contactNoTxt.setVisible(false);
	add(contactNoTxt);
        
        updateUser = new JButton("Update User"); 
	updateUser.setBounds(100,240,120,30);
	updateUser.setBackground(Color.white);
        updateUser.setVisible(false);
	add(updateUser);
	
        find = new JButton("Find");
	find.setBounds(280,240,120,30);
	find.setBackground(Color.green);
	add(find);
        
        back = new JButton("Back");
        back.setBounds(370,10,80,25);
        back.setBackground(Color.white);
        back.setForeground(Color.red);
        add(back);
        
        updateUser.addActionListener(this);
        find.addActionListener(this);
        back.addActionListener(this);
        
        setLayout(null);
        setSize(480,320);
        setLocation(480,220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String s1 = firstNameTxt.getText();
        String s2 = lastNameTxt.getText();
        String s3 = userNameTxt.getText();
        String s4 = passwordTxt.getText();
        String s5 = confirmPasswordTxt.getText();
        String s6 = emailIdTxt.getText();
        String s7 = contactNoTxt.getText();
        
        if(ae.getSource()==updateUser)
        {
            try
            {
                String query = "UPDATE `user_information` SET `First_Name`="+'"'+s1+'"'+','+"`Last_Name`="+'"'+s2+'"'+','+"`Password`="+'"'+s4+'"'+','+"`Confirm_Password`="+'"'+s5+'"'+','+"`Email_ID`="+'"'+s6+'"'+','+"`Contact_No`="+'"'+s7+'"'+" WHERE User_Name= "+'"'+s3+'"';
                Connection c = DatabaseConnection.dbConnector();
                Statement st = c.createStatement();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"User information updated");
                System.out.println("User information updated");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"User information not updated");
                System.out.println("User information not updated");
            }
        }
        else if(ae.getSource()==find)
        {
            try
            {
                String query = "SELECT * FROM `user_information` WHERE user_Name ="+'"'+s3+'"';
                Connection c = DatabaseConnection.dbConnector();
                Statement st = c.createStatement();
                ResultSet r = st.executeQuery(query);
                
                firstName.setVisible(true);
                firstNameTxt.setVisible(true);
                lastName.setVisible(true);
                lastNameTxt.setVisible(true);
                password.setVisible(true);
                passwordTxt.setVisible(true);
                confirmPassword.setVisible(true);
                confirmPasswordTxt.setVisible(true);
                emailId.setVisible(true);
                emailIdTxt.setVisible(true);
                contactNo.setVisible(true);
                contactNoTxt.setVisible(true);
                
                int count = 0;
                
                while(r.next())
                {
                    count = count+1;
                    if(count>=1)
                    {
                        firstNameTxt.setText(r.getString("First_Name"));
                        lastNameTxt.setText(r.getString("Last_Name"));
                        passwordTxt.setText(r.getString("Password"));
                        confirmPasswordTxt.setText(r.getString("Confirm_Password"));
                        emailIdTxt.setText(r.getString("Email_ID"));
                        contactNoTxt.setText(r.getString("Contact_No"));
                        updateUser.setVisible(true);
                        JOptionPane.showMessageDialog(null,"User found");
                        
                        s1 = firstNameTxt.getText();
                        s2 = lastNameTxt.getText();
                        s4 = passwordTxt.getText();
                        s5 = confirmPasswordTxt.getText();
                        s6 = emailIdTxt.getText();
                        s7 = contactNoTxt.getText();
                    }
                }
                if(count<=0)
                {
                    JOptionPane.showMessageDialog(null,"User not found");
                    firstName.setVisible(false);
                    firstNameTxt.setVisible(false);
                    lastName.setVisible(false);
                    lastNameTxt.setVisible(false);
                    password.setVisible(false);
                    passwordTxt.setVisible(false);
                    confirmPassword.setVisible(false);
                    confirmPasswordTxt.setVisible(false);
                    emailId.setVisible(false);
                    emailIdTxt.setVisible(false);
                    contactNo.setVisible(false);
                    contactNoTxt.setVisible(false);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"User not found");
                System.out.println("User not found");
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new LibrarianView(this.un);
        }
    }
}

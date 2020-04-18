
package library.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminView extends JFrame implements ActionListener
{
    JButton bookShelf,logout,createUser,createLibrarian,profile,deleteLibrarian,deleteUser;
    String un;
    public AdminView(String un)
    {
        super("~Admin~");
        
	this.un = un;
        
        logout = new JButton("Logout");
        logout.setBounds(350,10,80,25);
        logout.setBackground(Color.white);
        logout.setForeground(Color.red);
        add(logout);
        
        createUser = new JButton("Create User");
	createUser.setBounds(10,90,130,30);
        createUser.setBackground(Color.white);
	add(createUser);
	
        bookShelf = new JButton("Bookshelf");
	bookShelf.setBounds(150,90,130,30);
	bookShelf.setBackground(Color.green);
	add(bookShelf);
        setLayout(null);
        
        profile = new JButton("Profile");
        profile.setBounds(300,90,130,30);
        profile.setBackground(Color.red);
        profile.setForeground(Color.white);
        add(profile);
        
        createLibrarian = new JButton("Create Librarian");
        createLibrarian.setBounds(10,140,130,30);
        createLibrarian.setBackground(Color.red);
        createLibrarian.setForeground(Color.white);
	add(createLibrarian);
        
        deleteLibrarian = new JButton("Delete Librarian");
        deleteLibrarian.setBounds(150,140,130,30);
        deleteLibrarian.setBackground(Color.green);
	add(deleteLibrarian);

        deleteUser = new JButton("Delete User");
        deleteUser.setBounds(300,140,130,30);
        deleteUser.setBackground(Color.white);
	add(deleteUser);
        
        bookShelf.addActionListener(this);
        createUser.addActionListener(this);
        logout.addActionListener(this);
        profile.addActionListener(this);
        createLibrarian.addActionListener(this);
        deleteLibrarian.addActionListener(this);
        deleteUser.addActionListener(this);
        
        setResizable(false);
        setSize(480,320);
        setLocation(480,220);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bookShelf)
        {
            setVisible(false);
            new BookShelf(this.un);
        }
        else if(ae.getSource()==createUser)
        {
            setVisible(false);
            new UserRegister(this.un);
        }
        else if(ae.getSource()==createLibrarian)
        {
            setVisible(false);
            new LibrarianRegister(this.un);
        }
        else if(ae.getSource()==deleteLibrarian)
        {
            setVisible(false);
            new DeleteLibrarian(this.un);
        }
        else if(ae.getSource()==deleteUser)
        {
            setVisible(false);
            new DeleteUser(this.un);
        }
        else if(ae.getSource()==logout)
        {
            setVisible(false);
            new LibraryManagementSystem();
        }
        else if(ae.getSource()==profile)
        {
            setVisible(false);
            AdminProfile p = new AdminProfile(this.un);
            try
            {
                String query = "Select * from admin_information where User_Name = "+'"'+this.un+'"';
                Connection c = DatabaseConnection.dbConnector();
		Statement st = c.createStatement();
		ResultSet r = st.executeQuery(query);
                
                while(r.next())
                {
                    p.firstNameTxt.setText(r.getString("First_Name"));
                    p.lastNameTxt.setText(r.getString("Last_Name"));
                    p.userNameTxt.setText(r.getString("User_Name"));
                    p.passwordTxt.setText(r.getString("Password"));
                    p.confirmPasswordTxt.setText(r.getString("Confirm_Password"));
                    p.emailIdTxt.setText(r.getString("Email_ID"));
                    p.contactNoTxt.setText(r.getString("Contact_No"));
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
}

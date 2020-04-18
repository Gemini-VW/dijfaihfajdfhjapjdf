
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

public class LibrarianView extends JFrame implements ActionListener
{
    JButton viewBooks,issueBooks,viewIssuedBooks,returnBooks,profile,logout,bookShelf,createUser,updateUser;
    String un;
    public LibrarianView(String un)
    {
        super("~Librarian View~");
        
        this.un = un;
        
        logout = new JButton("Logout");
        logout.setBounds(350,10,80,25);
        logout.setBackground(Color.white);
        logout.setForeground(Color.red);
        add(logout);
        
        viewBooks = new JButton("View Books");
        viewBooks.setBounds(30,25,150,30);
        viewBooks.setBackground(Color.white);
        viewBooks.setForeground(Color.red);
        add(viewBooks);
        
        issueBooks = new JButton("Issue Book");
        issueBooks.setBounds(30,75,150,30);
        issueBooks.setBackground(Color.white);
        issueBooks.setForeground(Color.red);
        add(issueBooks);
        
        viewIssuedBooks = new JButton("View Issued Book");
        viewIssuedBooks.setBounds(30,125,150,30);
        viewIssuedBooks.setBackground(Color.white);
        viewIssuedBooks.setForeground(Color.red);
        add(viewIssuedBooks);
        
        returnBooks = new JButton("Return Book");
        returnBooks.setBounds(30,175,150,30);
        returnBooks.setBackground(Color.white);
        returnBooks.setForeground(Color.red);
        add(returnBooks);
        
        profile = new JButton("Profile");
        profile.setBounds(30,225,150,30);
        profile.setBackground(Color.white);
        profile.setForeground(Color.red);
        add(profile);
        
        bookShelf = new JButton("Book Shelf");
        bookShelf.setBounds(190,25,150,30);
        bookShelf.setBackground(Color.white);
        bookShelf.setForeground(Color.red);
        add(bookShelf);
        
        createUser = new JButton("Create User");
        createUser.setBounds(190,75,150,30);
        createUser.setBackground(Color.white);
        createUser.setForeground(Color.red);
        add(createUser);
        
        updateUser = new JButton("Update User");
        updateUser.setBounds(190,125,150,30);
        updateUser.setBackground(Color.white);
        updateUser.setForeground(Color.red);
        add(updateUser);
        
        profile.addActionListener(this);
        logout.addActionListener(this);
        viewBooks.addActionListener(this);
        issueBooks.addActionListener(this);
        viewIssuedBooks.addActionListener(this);
        returnBooks.addActionListener(this);
        bookShelf.addActionListener(this);
        createUser.addActionListener(this);
        updateUser.addActionListener(this);

        setLayout(null);
        setBackground(Color.red);
        setVisible(true);
        setSize(480,320);
        setResizable(false);
        setLocation(480,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==profile)
        {
            setVisible(false);
            LibrarianProfile lp = new LibrarianProfile(this.un);
            
            try
            {
                String query = "Select * from librarian_information where User_Name = "+'"'+this.un+'"';
                Connection c = DatabaseConnection.dbConnector();
		Statement st = c.createStatement();
		ResultSet r = st.executeQuery(query);
                
                while(r.next())
                {
                    lp.firstNameTxt.setText(r.getString("First_Name"));
                    lp.lastNameTxt.setText(r.getString("Last_Name"));
                    lp.userNameTxt.setText(r.getString("User_Name"));
                    lp.passwordTxt.setText(r.getString("Password"));
                    lp.confirmPasswordTxt.setText(r.getString("Confirm_Password"));
                    lp.emailIdTxt.setText(r.getString("Email_ID"));
                    lp.contactNoTxt.setText(r.getString("Contact_No"));
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else if(ae.getSource()==issueBooks)
        {
            setVisible(false);
            new IssueBooks(this.un);
        }
        else if(ae.getSource()==viewBooks)
        {
            setVisible(false);
            new ViewBooks(this.un);
        }
        else if(ae.getSource()==viewIssuedBooks)
        {
            setVisible(false);
            new ViewIssueBooks(this.un);
        }
        else if(ae.getSource()==returnBooks)
        {
            setVisible(false);
            new ReturnBooks(this.un);
        }
        else if(ae.getSource()==bookShelf)
        {
            setVisible(false);
            new ForLibrarianBookShelf(this.un);
        }
        else if(ae.getSource()==createUser)
        {
            setVisible(false);
            new UserRegisterForLibrarian(this.un);
        }
        else if(ae.getSource()==logout)
        {
            setVisible(false);
            new LibraryManagementSystem();
        }
        else if(ae.getSource()==updateUser)
        {
            setVisible(false);
            new UpdateUser(this.un);
        }
    }
}

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

public class IssueBooks extends JFrame implements ActionListener
{
    JLabel userNameLabel,bookId;
    JTextField userNameTxt,bookIdTxt;
    JButton issue,back;
    
    String un;
    
    public IssueBooks(String un)
    {
        super("Issue Books");
        
        this.un = un;
        
        userNameLabel = new JLabel("User Name: ");
        userNameLabel.setBounds(100,50,100,30);
        add(userNameLabel);
        
        userNameTxt = new JTextField();
        userNameTxt.setBounds(180,55,150,20);
        add(userNameTxt);
        
        bookId = new JLabel("Book id: ");
        bookId.setBounds(120,85,100,30);
        add(bookId);
        
        bookIdTxt = new JTextField();
        bookIdTxt.setBounds(180,90,150,20);
        add(bookIdTxt);
        
        issue = new JButton("Issue");
        issue.setBounds(100,150,100,30);
        issue.setBackground(Color.white);
        issue.setForeground(Color.red);
        add(issue);
        
        back = new JButton("Back");
        back.setBounds(260,150,100,30);
        back.setBackground(Color.white);
        back.setForeground(Color.red);
        add(back);
        
        back.addActionListener(this);
        issue.addActionListener(this);
        
        setLayout(null);
        setVisible(true);
        setSize(480,320);
        setResizable(false);
        setLocation(480,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s1 = userNameTxt.getText();
        String s2 = bookIdTxt.getText();
        String s3 = new String();
        String s4 = new String();
        String availabeCopy = new String();
        String availabeCopyAfter = new String();
        

        if(ae.getSource()==back)
        {
            setVisible(false);
            new LibrarianView(this.un);
        }
        else if(ae.getSource()==issue)
        {
            if(s1.length()==0 || s2.length()==0)
            {
                JOptionPane.showMessageDialog(null,"Field is empty");
            }
            else
            {
                try
                {
                    String query = "SELECT `Available_Copy` FROM `bookshelf` WHERE Book_ID = "+'"'+s2+'"';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(query);
                
                    while(r.next())
                    {
                        availabeCopy = r.getString("Available_Copy");
                        System.out.println("Total Books: "+availabeCopy);
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                    System.out.println("Book not copy availabe");
                }
                try
                {
                    availabeCopyAfter = availabeCopy + "-1";
                    String query = "UPDATE `bookshelf` SET `Available_Copy`= "+availabeCopyAfter+" WHERE Book_ID = "+'"'+s2+'"';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    st.executeUpdate(query);
                
                    System.out.println("Available copy effected");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                    System.out.println("Available copy not effected");
                }
                try
                {
                    String query = "SELECT CURDATE()";
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(query);
                
                    while(r.next())
                    {
                        s3 = r.getString("CURDATE()");
                        System.out.println("Curent date working");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Current date not working");
                    JOptionPane.showMessageDialog(null,e);
                }
                try
                {
                    String query2 = "SELECT CURDATE() + INTERVAL 7 DAY";
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    ResultSet r2 = st.executeQuery(query2);
                
                    while(r2.next())
                    {
                        s4 = r2.getString("CURDATE() + INTERVAL 7 DAY");
                        System.out.println("Return date working");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Return date not working");
                    JOptionPane.showMessageDialog(null,e);
                }
                try
                {
                    String query = "INSERT INTO `issue_books`(`User_Name`, `Book_ID`, `Borrow_Date`, `Return_Date`) VALUES ("+'"'+s1+'"'+','+'"'+s2+'"'+','+'"'+s3+'"'+','+'"'+s4+'"'+')';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    st.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null,"Book Issued");
                    System.out.println("Book Issued");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                    System.out.println("Book not Issued");
                }
            }
        }   
        
    }
}

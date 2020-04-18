
package library.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewBorrowHistory extends JFrame implements ActionListener
{
    JTable viewBorrowHistory;
    JButton back;
    String un;
    String book_ID1,borrowDate1,returnDate1;
    String book_ID2,borrowDate2,returnDate2;
    String book_ID3,borrowDate3,returnDate3;
    String book_ID4,borrowDate4,returnDate4;
    String book_ID5,borrowDate5,returnDate5;
    
    
    public ViewBorrowHistory(String un)
    {
        super("View Books");
        
        this.un = un;
        
        String[] columnNames = {"Book ID","Borrow Date","Return Date"};
        
        try
        {
            String query = "SELECT * FROM `issue_books`  WHERE User_Name ="+'"'+this.un+'"'+" LIMIT 1 OFFSET 0";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID1 = r.getString("Book_ID");
                borrowDate1 = r.getString("Borrow_Date");
                returnDate1 = r.getString("Return_Date");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Borrow History not working");
        }
        
        try
        {
            String query = "SELECT * FROM `issue_books`  WHERE User_Name ="+'"'+this.un+'"'+" LIMIT 1 OFFSET 1";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID2 = r.getString("Book_ID");
                borrowDate2 = r.getString("Borrow_Date");
                returnDate2 = r.getString("Return_Date");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Borrow History not working");
        }
        
        try
        {
            String query = "SELECT * FROM `issue_books`  WHERE User_Name ="+'"'+this.un+'"'+" LIMIT 1 OFFSET 2";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID3 = r.getString("Book_ID");
                borrowDate3 = r.getString("Borrow_Date");
                returnDate3 = r.getString("Return_Date");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Borrow History not working");
        }
        
        try
        {
            String query = "SELECT * FROM `issue_books`  WHERE User_Name ="+'"'+this.un+'"'+" LIMIT 1 OFFSET 3";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID4 = r.getString("Book_ID");
                borrowDate4 = r.getString("Borrow_Date");
                returnDate4 = r.getString("Return_Date");;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Borrow History not working");
        }
        
        try
        {
            String query = "SELECT * FROM `issue_books`  WHERE User_Name ="+'"'+this.un+'"'+" LIMIT 1 OFFSET 4";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID5 = r.getString("Book_ID");
                borrowDate5 = r.getString("Borrow_Date");
                returnDate5 = r.getString("Return_Date");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Borrow History not working");
        }

        Object[][] data = {
            {book_ID1,borrowDate1,returnDate1},
            {book_ID2,borrowDate2,returnDate2},
            {book_ID3,borrowDate3,returnDate3},
            {book_ID4,borrowDate4,returnDate4},
            {book_ID5,borrowDate5,returnDate5},
        };
        
        viewBorrowHistory = new JTable(data, columnNames);
        viewBorrowHistory.setPreferredScrollableViewportSize(new Dimension(500,200));
        viewBorrowHistory.setFillsViewportHeight(true);
        
        JScrollPane scrollePane = new JScrollPane(viewBorrowHistory);
        add(scrollePane);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        add(back);
        
        back.addActionListener(this);
        
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(550,320);
        setLocation(480,220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new UserView(this.un);
        }
    }
}

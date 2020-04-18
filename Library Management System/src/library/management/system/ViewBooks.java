
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


public class ViewBooks extends JFrame implements ActionListener
{
    JTable viewBooks;
    JButton back;
    String un;
    String book_ID1,book_Name1,author_Name1,shelf_No1,total_Copy1,available_Copy1;
    String book_ID2,book_Name2,author_Name2,shelf_No2,total_Copy2,available_Copy2;
    String book_ID3,book_Name3,author_Name3,shelf_No3,total_Copy3,available_Copy3;
    String book_ID4,book_Name4,author_Name4,shelf_No4,total_Copy4,available_Copy4;
    String book_ID5,book_Name5,author_Name5,shelf_No5,total_Copy5,available_Copy5;
    String book_ID6,book_Name6,author_Name6,shelf_No6,total_Copy6,available_Copy6;
    String book_ID7,book_Name7,author_Name7,shelf_No7,total_Copy7,available_Copy7;
    String book_ID8,book_Name8,author_Name8,shelf_No8,total_Copy8,available_Copy8;
    String book_ID9,book_Name9,author_Name9,shelf_No9,total_Copy9,available_Copy9;
    String book_ID10,book_Name10,author_Name10,shelf_No10,total_Copy10,available_Copy10;
    String book_ID11,book_Name11,author_Name11,shelf_No11,total_Copy11,available_Copy11;
    String book_ID12,book_Name12,author_Name12,shelf_No12,total_Copy12,available_Copy12;
    String book_ID13,book_Name13,author_Name13,shelf_No13,total_Copy13,available_Copy13;
    String book_ID14,book_Name14,author_Name14,shelf_No14,total_Copy14,available_Copy14;
    
    public ViewBooks(String un)
    {
        super("View Books");
        
        this.un = un;
        
        String[] columnNames = {"Book ID","Book Name","Author Name","Shelf No","Total Copy","Available Copy"};
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 0";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID1 = r.getString("Book_ID");
                book_Name1 = r.getString("Book_Name");
                author_Name1 = r.getString("Author_Name");
                shelf_No1 = r.getString("Shelf_No");
                total_Copy1 = r.getString("Total_Copy");
                available_Copy1 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 1";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID2 = r.getString("Book_ID");
                book_Name2 = r.getString("Book_Name");
                author_Name2 = r.getString("Author_Name");
                shelf_No2 = r.getString("Shelf_No");
                total_Copy2 = r.getString("Total_Copy");
                available_Copy2 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 2";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID3 = r.getString("Book_ID");
                book_Name3 = r.getString("Book_Name");
                author_Name3 = r.getString("Author_Name");
                shelf_No3 = r.getString("Shelf_No");
                total_Copy3 = r.getString("Total_Copy");
                available_Copy3 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 3";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID4 = r.getString("Book_ID");
                book_Name4 = r.getString("Book_Name");
                author_Name4 = r.getString("Author_Name");
                shelf_No4 = r.getString("Shelf_No");
                total_Copy4 = r.getString("Total_Copy");
                available_Copy4 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 4";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID5 = r.getString("Book_ID");
                book_Name5 = r.getString("Book_Name");
                author_Name5 = r.getString("Author_Name");
                shelf_No5 = r.getString("Shelf_No");
                total_Copy5 = r.getString("Total_Copy");
                available_Copy5 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 5";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID6 = r.getString("Book_ID");
                book_Name6 = r.getString("Book_Name");
                author_Name6 = r.getString("Author_Name");
                shelf_No6 = r.getString("Shelf_No");
                total_Copy6 = r.getString("Total_Copy");
                available_Copy6 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 6";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID7 = r.getString("Book_ID");
                book_Name7 = r.getString("Book_Name");
                author_Name7 = r.getString("Author_Name");
                shelf_No7 = r.getString("Shelf_No");
                total_Copy7 = r.getString("Total_Copy");
                available_Copy7 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 7";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID8 = r.getString("Book_ID");
                book_Name8 = r.getString("Book_Name");
                author_Name8 = r.getString("Author_Name");
                shelf_No8 = r.getString("Shelf_No");
                total_Copy8 = r.getString("Total_Copy");
                available_Copy8 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 8";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID9 = r.getString("Book_ID");
                book_Name9 = r.getString("Book_Name");
                author_Name9 = r.getString("Author_Name");
                shelf_No9 = r.getString("Shelf_No");
                total_Copy9 = r.getString("Total_Copy");
                available_Copy9 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 9";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID10 = r.getString("Book_ID");
                book_Name10 = r.getString("Book_Name");
                author_Name10 = r.getString("Author_Name");
                shelf_No10 = r.getString("Shelf_No");
                total_Copy10 = r.getString("Total_Copy");
                available_Copy10 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 10";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID11 = r.getString("Book_ID");
                book_Name11 = r.getString("Book_Name");
                author_Name11 = r.getString("Author_Name");
                shelf_No11 = r.getString("Shelf_No");
                total_Copy11 = r.getString("Total_Copy");
                available_Copy11 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 11";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID12 = r.getString("Book_ID");
                book_Name12 = r.getString("Book_Name");
                author_Name12 = r.getString("Author_Name");
                shelf_No12 = r.getString("Shelf_No");
                total_Copy12 = r.getString("Total_Copy");
                available_Copy12 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 12";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID13 = r.getString("Book_ID");
                book_Name13 = r.getString("Book_Name");
                author_Name13 = r.getString("Author_Name");
                shelf_No13 = r.getString("Shelf_No");
                total_Copy13 = r.getString("Total_Copy");
                available_Copy13 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        try
        {
            String query = "SELECT * FROM `bookshelf` LIMIT 1 OFFSET 13";
            Connection c = DatabaseConnection.dbConnector();
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            
            while(r.next())
            {
                book_ID14 = r.getString("Book_ID");
                book_Name14 = r.getString("Book_Name");
                author_Name14 = r.getString("Author_Name");
                shelf_No14 = r.getString("Shelf_No");
                total_Copy14 = r.getString("Total_Copy");
                available_Copy14 = r.getString("Available_Copy");
                //System.out.println("View Books working");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("View Books exception e working");
        }
        
        
        Object[][] data = {
            {book_ID1,book_Name1,author_Name1,shelf_No1,total_Copy1,available_Copy1},
            {book_ID2,book_Name2,author_Name2,shelf_No2,total_Copy2,available_Copy2},
            {book_ID3,book_Name3,author_Name3,shelf_No3,total_Copy3,available_Copy3},
            {book_ID4,book_Name4,author_Name4,shelf_No4,total_Copy4,available_Copy4},
            {book_ID5,book_Name5,author_Name5,shelf_No5,total_Copy5,available_Copy5},
            {book_ID6,book_Name6,author_Name6,shelf_No6,total_Copy6,available_Copy6},
            {book_ID7,book_Name7,author_Name7,shelf_No7,total_Copy7,available_Copy7},
            {book_ID8,book_Name8,author_Name8,shelf_No8,total_Copy8,available_Copy8},
            {book_ID9,book_Name9,author_Name9,shelf_No9,total_Copy9,available_Copy9},
            {book_ID10,book_Name10,author_Name10,shelf_No10,total_Copy10,available_Copy10},
            {book_ID11,book_Name11,author_Name11,shelf_No11,total_Copy11,available_Copy11},
            {book_ID12,book_Name12,author_Name12,shelf_No12,total_Copy12,available_Copy12},
            {book_ID13,book_Name13,author_Name13,shelf_No13,total_Copy13,available_Copy13},
            {book_ID14,book_Name14,author_Name14,shelf_No14,total_Copy14,available_Copy14}
        };
        
        viewBooks = new JTable(data, columnNames);
        viewBooks.setPreferredScrollableViewportSize(new Dimension(500,200));
        viewBooks.setFillsViewportHeight(true);
        
        JScrollPane scrollePane = new JScrollPane(viewBooks);
        add(scrollePane);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        add(back);
        
        back.addActionListener(this);
        
        setLayout(new FlowLayout());
        setVisible(true);
        setResizable(false);
        setSize(550,320);
        setLocation(480,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new LibrarianView(this.un);
        }
    }
}

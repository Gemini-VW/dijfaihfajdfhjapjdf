
package library.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class BookShelf extends JFrame implements ActionListener
{
    JLabel serach,bookId,bookName,authorName,shelfNo,addCopy;
    JTextField serachTxt,bookIdTxt,bookNameTxt,authorNameTxt,shelfNoTxt,addCopyTxt;
    JButton find,insert,delete,back;
    JComboBox <String> bookShelfNo;
    
    String un;
    
    public BookShelf(String un)
    {
        super("Bookshelf");
        
        this.un = un;
        
        serach = new JLabel("Find~Insert~Delete Books Criteria");
	serach.setBounds(80,10,200,20);
	add(serach);
        
        find = new JButton("Find book");
        find.setBounds(30,200,120,25);
        find.setForeground(Color.red);
        find.setBackground(Color.white);
        add(find);
        
        insert = new JButton("Insert book");
        insert.setBounds(170,200,120,25);
        insert.setForeground(Color.red);
        insert.setBackground(Color.white);
        add(insert);
        
        delete = new JButton("Delete book");
        delete.setBounds(310,200,120,25);
        delete.setForeground(Color.red);
        delete.setBackground(Color.white);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(350,10,80,25);
        back.setBackground(Color.white);
        back.setForeground(Color.red);
        add(back);
        
        bookId = new JLabel("Book ID: ");
	bookId.setBounds(80,50,80,20);
	add(bookId);
		
	bookIdTxt = new JTextField();
	bookIdTxt.setBounds(200,50,150,20);
	bookIdTxt.setBackground(Color.white);
	add(bookIdTxt);	
		
	bookName = new JLabel("Book Name: ");
	bookName.setBounds(80,80,150,20);
	add(bookName);
		
	bookNameTxt = new JTextField();
	bookNameTxt.setBounds(200,80,150,20);
	bookNameTxt.setBackground(Color.white);
	add(bookNameTxt);
        
        authorName = new JLabel("Author name(s): ");
	authorName.setBounds(80,110,150,20);
	add(authorName);
		
	authorNameTxt=new JTextField();
	authorNameTxt.setBounds(200,110,150,20);
	authorNameTxt.setBackground(Color.white);
	add(authorNameTxt);
        
        shelfNo = new JLabel("Shelf(s): ");
	shelfNo.setBounds(80,140,150,20);
	add(shelfNo);
		
	bookShelfNo = new JComboBox<String>();
        bookShelfNo.addItem("1A");
        bookShelfNo.addItem("2B");
        bookShelfNo.addItem("3C");
        bookShelfNo.addItem("4D");
        bookShelfNo.addItem("5E");
        bookShelfNo.setBounds(200,140,150,20);
        bookShelfNo.setBackground(Color.white);
        add(bookShelfNo);
        
        addCopy = new JLabel("Add Copy: ");
        addCopy.setBounds(80,170,150,20);
        add(addCopy);
        
        addCopyTxt = new JTextField();
        addCopyTxt.setBounds(200,170,150,20);
        add(addCopyTxt);
        
        setLayout(null);
        
        insert.addActionListener(this);
        delete.addActionListener(this);
        find.addActionListener(this);
        back.addActionListener(this);
        
        setSize(480,320);
        setLocation(480,220);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String s1 = bookIdTxt.getText();
        String s2 = bookNameTxt.getText();
        String s3 = authorNameTxt.getText();
        String s4 = String.valueOf(bookShelfNo.getSelectedItem());
        String s5 = addCopyTxt.getText();
        
        if(ae.getSource()==insert)
        {
            try{
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"You must provide a book id.");
                }
                else if(s2.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"You must provide a book name.");
                }
                else if(s3.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"You must provide an author name.");
                }
                else if(s5.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please give number of copies");
                }
                else
                {
                    String query = "INSERT INTO `bookshelf`(`Book_ID`, `Book_Name`, `Author_Name`, `Shelf_No` , `Total_Copy`, `Available_Copy`) VALUES ("+'"'+s1+'"'+','+'"'+s2+'"'+','+'"'+s3+'"'+','+'"'+s4+'"'+','+'"'+s5+'"'+','+'"'+s5+'"'+')';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    st.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"Book inserted");
                    c.close();
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Book already inserted!!");
            }
        }
        
        
        else if(ae.getSource()==delete)
        {
            if(s1.length()==0)
            {
                JOptionPane.showMessageDialog(null,"You must provide a book id.");
            }
            else
            {
                try
                {
                    String query = "DELETE FROM `bookshelf` WHERE book_id = "+'"'+s1+'"';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Book deleted");
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
        
        else if(ae.getSource()==find)
        {
            if(s1.length()==0)
            {
                JOptionPane.showMessageDialog(null,"You must provide a book id");
            }
            else
            {
                try
                {
                    String query = "SELECT * FROM `bookshelf` WHERE book_id = "+'"'+s1+'"';
                    Connection c = DatabaseConnection.dbConnector();
                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(query);
                    
                    int count = 0;
                    while(r.next())
                    {
                        count = count+1;
                        if(count>=1)
                        {
                            bookNameTxt.setText(r.getString("Book_Name"));
                            authorNameTxt.setText(r.getString("Author_Name"));
                            bookShelfNo.setSelectedItem(r.getString("Shelf_No"));
                            
                            addCopy.setVisible(false);
                            
                            addCopy = new JLabel("Available Copy");
                            addCopy.setBounds(80,170,150,20);
                            this.add(addCopy);
                            addCopy.setLayout(null);
                            addCopyTxt.setText(r.getString("Available_Copy"));
                        }
                    }
                    if(count<1)
                    {
                        JOptionPane.showMessageDialog(null,"Book not found..");
                        bookNameTxt.setText(null);
                        authorNameTxt.setText(null);
                        bookShelfNo.setSelectedItem("1A");
                        addCopyTxt.setText(null);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Book found..");
                        r.close();
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
        
        else if(ae.getSource()==back)
        {
            new AdminView(this.un);
            setVisible(false);
        }
    }
}
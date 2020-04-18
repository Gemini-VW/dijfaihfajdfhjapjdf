
package library.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LibraryManagementSystem extends JFrame implements ActionListener
{
    JFrame frame;
    JLabel Label;
    JButton adminLogin,librarianLogin,userLogIn,exit;
    ImageIcon image;
    
    public LibraryManagementSystem()
    {
        super("Library Management System");
        
        image = new ImageIcon(getClass().getResource("Library.gif"));
        Label = new JLabel(image);
        
        adminLogin = new JButton("Admin login");
        adminLogin.setBounds(0,11,100,30);
        adminLogin.setBackground(Color.RED);
        add(adminLogin);
        
        librarianLogin = new JButton("Librarian Login");
        librarianLogin.setBounds(340,11,150,30);
        librarianLogin.setBackground(Color.GREEN);
        add(librarianLogin);
        
        userLogIn = new JButton("User Log In");
        userLogIn.setBounds(340,41,150,30);
        userLogIn.setBackground(Color.LIGHT_GRAY);
        userLogIn.setForeground(Color.white);
        add(userLogIn);
        
        exit = new JButton("Exit");
        exit.setBounds(394,251,80,30);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.red);
        add(exit);
        
        add(Label);
        pack();
        
        adminLogin.addActionListener(this);
        librarianLogin.addActionListener(this);
        exit.addActionListener(this);
        userLogIn.addActionListener(this);
        
        setSize(480,320);
        setLocation(480,220);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==adminLogin)
        {
            setVisible(false);
            new AdminLogIn();
        }
        else if(ae.getSource()==librarianLogin)
        {
            setVisible(false);
            new LibrarianLogIn();
        }
        else if(ae.getSource()==userLogIn)
        {
            setVisible(false);
            new UserLogIn();
        }
        else if(ae.getSource()==exit)
        {
            System.exit(0);
        }
    }
}
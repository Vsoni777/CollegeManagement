package Program;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class Mark extends JFrame implements ActionListener{
	String rollno;
	JLabel head,l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b2;
	public Mark(String rollno) {
		this.rollno=rollno;
		setSize(500,600);
		setLocation(500,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
        
        head=new JLabel("Jawaharlal Institue of Technology");
        head.setBounds(100,10,500,25);
		head.setFont(new Font("serif",Font.ITALIC,20));
		add(head);
		 
		l1=new JLabel("  Examination Result 2024");
	    l1.setBounds(120,50,500,20);
		l1.setFont(new Font("serif",Font.ITALIC,18));
		add(l1);
		
		l2=new JLabel("Roll no "+rollno);
        l2.setBounds(60,100,500,25);
		l2.setFont(new Font("serif",Font.ITALIC,20));
		add(l2);
		 
		l3=new JLabel();
	    l3.setBounds(60,130,500,20);
		l3.setFont(new Font("serif",Font.PLAIN,18));
		add(l3);
		
		l4=new JLabel();
	    l4.setBounds(100,200,500,20);
		l4.setFont(new Font("serif",Font.PLAIN,18));
		add(l4);
		
		l5=new JLabel();
	    l5.setBounds(100,230,500,20);
		l5.setFont(new Font("serif",Font.PLAIN,18));
		add(l5);
		
		l6=new JLabel();
	    l6.setBounds(100,260,500,20);
		l6.setFont(new Font("serif",Font.PLAIN,18));
		add(l6);
		
		l7=new JLabel();
	    l7.setBounds(100,290,500,20);
		l7.setFont(new Font("serif",Font.PLAIN,18));
		add(l7);
		
		l8=new JLabel();
	    l8.setBounds(100,320,500,20);
		l8.setFont(new Font("serif",Font.PLAIN,18));
		add(l8);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery("select *from Subject where rollno='"+rollno+"'");
			while(rs1.next()) {
				l4.setText(rs1.getString("sub1"));
				l5.setText(rs1.getString("sub2"));
				l6.setText(rs1.getString("sub3"));
				l7.setText(rs1.getString("sub4"));
				l8.setText(rs1.getString("sub5"));
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs2=stmt.executeQuery("select *from Mark where rollno='"+rollno+"'");
			
			while(rs2.next()) {
				l4.setText(l4.getText()+"--------------"+rs2.getString("mark1"));
				l5.setText(l5.getText()+"--------------"+rs2.getString("mark2"));
				l6.setText(l6.getText()+"--------------"+rs2.getString("mark3"));
				l7.setText(l7.getText()+"--------------"+rs2.getString("makr4"));
				l8.setText(l8.getText()+"--------------"+rs2.getString("mark5"));
				l3.setText("semester   "+rs2.getString("semester"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		b2=new JButton("Back");
		b2.setBounds(250,500,120,25);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif",Font.BOLD,20));
		add(b2);
		
		b2.addActionListener(this);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Mark("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
	}

}

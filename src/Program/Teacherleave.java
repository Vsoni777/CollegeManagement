package Program;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser.*;


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Teacherleave extends JFrame implements ActionListener {
	JLabel head,l1,l2,l3;
	Choice empid,tdur;
	JDateChooser date;
	JButton b1,b2;
	Teacherleave(){
		setLayout(null);
		getContentPane().setBackground(Color.cyan);	
		head=new JLabel("Apply leave for (Teacher)");
		head.setBounds(40, 50, 300, 30);
		head.setFont(new Font("Tahona",Font.BOLD,20));
		add(head);
		

		l1=new JLabel("Search Employee id");
		l1.setBounds(60,100,200,20);
		l1.setFont(new Font("Tahona",Font.BOLD,18));
		add(l1);
		
		empid=new Choice();
		empid.setBounds(60, 130, 200, 20);
		add(empid);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Tdetail");
			while(rs.next()) {
				empid.add(rs.getString("empid"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		l2=new JLabel("Date");
		l2.setBounds(60,180,200,20);
		l2.setFont(new Font("Tahona",Font.BOLD,18));
		add(l2);
		
		date=new JDateChooser();
		date.setBounds(60, 210, 200, 25);
		add(date);
		
		l1=new JLabel("Time duration");
		l1.setBounds(60,260,200,20);
		l1.setFont(new Font("Tahona",Font.BOLD,18));
		add(l1);
		
		tdur=new Choice();
		tdur.setBounds(60, 290, 200, 30);
		tdur.add("");
		tdur.add("Full day");
		tdur.add("Half day");
		add(tdur);
		
		b1=new JButton("Apply");
		b1.setBounds(60,350,100,25);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif",Font.BOLD,16));
		add(b1);
		
		b2=new JButton("cancle");
		b2.setBounds(200,350,100,25);
		b2.setBackground(Color.blue);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif",Font.BOLD,16));
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(500,500);
		setLocation(550,100);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new Teacherleave();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
          
		
		String a=(((JTextField)date.getDateEditor().getUiComponent()).getText());
		
		if(ae.getSource()==b1) {
			String emp=empid.getSelectedItem();
			String duration=tdur.getSelectedItem();
				try {
				Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");

				PreparedStatement ps = con.prepareStatement("insert into Teacherleave values(?,?,?)");
				ps.setString(1, emp);
				ps.setString(2, a);
				ps.setString(3, duration);
				int x=ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Leave confirmed");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		if(ae.getSource()==b2){
			setVisible(false);
		}
		
	}

}


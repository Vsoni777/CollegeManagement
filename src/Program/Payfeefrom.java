package Program;
import javax.swing.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Payfeefrom extends JFrame implements ActionListener{
	JLabel Home,sname,l1,l2,t1,t2,l3,l4,l5,l6,l7;
	JComboBox cbg,cbg1,c;
	Choice rollno;
	JButton b1,b2,b3;
	Payfeefrom(){
		setSize(900,500);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("./icon./educationfee.jpg"));
		Image img1=img.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(img1);
		Home=new JLabel(img2);
		Home.setBounds(400,50,500,300);
		add(Home);
		
		sname=new JLabel("Select Roll no");
		sname.setBounds(40,60,150,20);
		sname.setFont(new Font("Tahona",Font.PLAIN,16));
		add(sname);
		
		rollno=new Choice();
		rollno.setBounds(200, 60, 150, 20);
		add(rollno);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3306/vivek1","vivek","Vi_soni777@&");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Sdetail");
			while(rs.next()) {
				rollno.add(rs.getString("rollno"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		l1=new JLabel("Name");
		l1.setBounds(40,100,150,20);
		l1.setFont(new Font("serif",Font.BOLD,16));
		add(l1);
		
		t1=new JLabel();
		t1.setBounds(200,100,150,20);
		add(t1);
		
		l2=new JLabel("Father's Name");
		l2.setBounds(40,140,150,20);
		l2.setFont(new Font("serif",Font.BOLD,16));
		add(l2);
		
		t2=new JLabel();
		t2.setBounds(200,140,150,20);
		add(t2);
		
		try 
		{
		Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
		Statement stmt=con.createStatement();
		String query="select *from Sdetail where rollno='"+rollno.getSelectedItem()+"'";

		ResultSet rs=stmt.executeQuery(query);

		while(rs.next())
		{
		   t1.setText(rs.getString("name"));
		   t2.setText(rs.getString("fname"));
		 
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		rollno.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				try 
				{
				Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3306/vivek1","vivek","Vi_soni777@&");
				Statement stmt=con.createStatement();
				String query="select *from Sdetail where rollno='"+rollno.getSelectedItem()+"'";

				ResultSet rs=stmt.executeQuery(query);

				while(rs.next())
				{
				   t1.setText(rs.getString("name"));
				   t2.setText(rs.getString("fname"));
				  
				}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
		   }
		});	
		
		l3=new JLabel("Course");
		l3.setBounds(40,180,150,20);
		l3.setFont(new Font("serif",Font.BOLD,16));
		add(l3);
		
		String course[]= {" ","BBA","BTech","BSC","BA","BCOM","BCA","MTECH","MCA","MCOM"};
		cbg=new JComboBox(course);
		cbg.setBounds(200,180,150,20);
		cbg.setBackground(Color.WHITE);
		add(cbg);
		
		l4=new JLabel("Branch");
		l4.setBounds(40,220,150,20);
		l4.setFont(new Font("serif",Font.BOLD,16));
		add(l4);
		
		String course1[]= {" ","Computer Science","Electrical","IT","Machancial","Civil"};
		cbg1=new JComboBox(course1);
		cbg1.setBounds(200,220,150,20);
		cbg1.setBackground(Color.WHITE);
		add(cbg1);
		
		l5=new JLabel("Select Semester :");
		l5.setBounds(40, 260, 150, 20);
		add(l5);
		
		String sem[]= {"Select semester","semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
		c=new JComboBox(sem);
		c.setBackground(Color.white);
		c.setBounds(200, 260, 150, 20);
		add(c);
		
		l6=new JLabel("Total Fee");
	    l6.setBounds(40,300,150,20);
		l6.setFont(new Font("serif",Font.BOLD,16));
		add(l6);
		
		l7=new JLabel();
	    l7.setBounds(200,300,150,20);
		l7.setFont(new Font("serif",Font.PLAIN,16));
		add(l7);
		
		b1=new JButton("Update");
		b1.setBounds(30,380,100,25);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif",Font.BOLD,18));
		add(b1);
		
		b2=new JButton("Pay fee");
		b2.setBounds(150,380,100,25);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif",Font.BOLD,18));
		add(b2);
		
		b3=new JButton("Back");
		b3.setBounds(270,380,100,25);
		b3.setBackground(Color.black);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("serif",Font.BOLD,18));
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Payfeefrom();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String roll=(String)rollno.getSelectedItem();
				
		String course=(String)cbg.getSelectedItem();
		String branch=(String)cbg1.getSelectedItem();
		String sem=(String)c.getSelectedItem();
		 if(ae.getSource()==b1) {
			 try {
				 Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3306/vivek1","vivek","Vi_soni777@&");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select *from Fee where course='"+course+"'");
					while(rs.next()) {
						l7.setText(rs.getString(sem));
					}
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		 
		 if(ae.getSource()==b2) {
			 String fee=l7.getText();
			 try {
				 Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3306/vivek1","vivek","Vi_soni777@&");
					//Statement stmt=con.createStatement();
					PreparedStatement ps = con.prepareStatement("insert into Collegefee values(?,?,?,?,?)");
					ps.setString(1, roll);
					ps.setString(2, course);
					ps.setString(3, branch);
					ps.setString(4, sem);
					ps.setString(5, fee);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Fees Paid");
					setVisible(false);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
        if(ae.getSource()==b3) {
			dispose(); 
		 }
	}
}

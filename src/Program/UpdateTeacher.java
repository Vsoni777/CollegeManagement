package Program;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
public class UpdateTeacher extends JFrame implements ActionListener {
		JLabel head,sname,dob,l1,t1,t2,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,t6,t7,t8;
		JTextField t3,t4,t5,cbg,cbg1;
		Choice empid;
		JButton b1,b2;
		
		
		
UpdateTeacher(){
	
		setSize(900,650);
		setLocation(350,30);
		setLayout(null);
		
		head=new JLabel("Update Teacher Details");
		head.setBounds(50,10,500,50);
		head.setFont(new Font("serif",Font.ITALIC,25));
		add(head);
		
		sname=new JLabel("Select Emp Id");
		sname.setBounds(50,100,200,20);
		sname.setFont(new Font("Tahona",Font.PLAIN,18));
		add(sname);
		
		empid=new Choice();
		empid.setBounds(250, 100, 200, 20);
		add(empid);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Tdetail");
			while(rs.next()) {
				empid.add(rs.getString("Empid"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		l1=new JLabel("Name");
		l1.setBounds(50,150,100,30);
		l1.setFont(new Font("serif",Font.BOLD,20));
		add(l1);
		
		t1=new JLabel();
		t1.setBounds(200,150,150,30);
		add(t1);
		
		l2=new JLabel("Father's Name");
		l2.setBounds(400,150,180,30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		add(l2);
		
		t2=new JLabel();
		t2.setBounds(600,150,150,30);
		add(t2);
		
		l3=new JLabel("EmpId");
		l3.setBounds(50,200,200,30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		add(l3);
		
		l4=new JLabel();
		l4.setBounds(200,200,200,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		add(l4);
		
		l5=new JLabel("DOB");
		l5.setBounds(400,200,200,30);
		l5.setFont(new Font("serif",Font.BOLD,20));
		add(l5);
		
		dob=new JLabel();
		dob.setBounds(600, 200, 150, 30);
		add(dob);
		
		l6=new JLabel("Address");
		l6.setBounds(50,250,200,30);
		l6.setFont(new Font("serif",Font.BOLD,20));
		add(l6);
		
		t3=new JTextField();
		t3.setBounds(200,250,150,30);
		add(t3);
		
		l7=new JLabel("Phone no");
		l7.setBounds(400,250,200,30);
		l7.setFont(new Font("serif",Font.BOLD,20));
		add(l7);
		
		t4=new JTextField();
		t4.setBounds(600,250,150,30);
		add(t4);
		
		l8=new JLabel("Email");
		l8.setBounds(50,300,200,30);
		l8.setFont(new Font("serif",Font.BOLD,20));
		add(l8);
		
		t5=new JTextField();
		t5.setBounds(200,300,150,30);
		add(t5);
		
		l9=new JLabel("Class X(%)");
		l9.setBounds(400,300,200,30);
		l9.setFont(new Font("serif",Font.BOLD,20));
		add(l9);
		
		t6=new JLabel();
		t6.setBounds(600,300,150,30);
		add(t6);
		
		l10=new JLabel("Class XII(%)");
		l10.setBounds(50,350,200,30);
		l10.setFont(new Font("serif",Font.BOLD,20));
		add(l10);
		
		t7=new JLabel();
		t7.setBounds(200,350,150,30);
		add(t7);
		
		l11=new JLabel("Aadhar No");
		l11.setBounds(400,350,200,30);
		l11.setFont(new Font("serif",Font.BOLD,20));
		add(l11);
		
		t8=new JLabel();
		t8.setBounds(600,350,150,30);
		add(t8);
		
		l12=new JLabel("Qualification");
		l12.setBounds(50,400,200,30);
		l12.setFont(new Font("serif",Font.BOLD,20));
		add(l12);
		
		//String course[]= {" ","BBA","B.tech","BSC","BCOM","BCA"};
		cbg=new JTextField();
		cbg.setBounds(200,400,150,30);
		cbg.setBackground(Color.WHITE);
		add(cbg);
		
		l13=new JLabel("Department");
		l13.setBounds(400,400,200,30);
		l13.setFont(new Font("serif",Font.BOLD,20));
		add(l13);
		
		//String course1[]= {" ","Computer Science","Electrical","IT","Machancial","Civil"};
		cbg1=new JTextField();
		cbg1.setBounds(600,400,150,30);
		cbg1.setBackground(Color.WHITE);
		add(cbg1);
		
		try 
		{
		Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
		Statement stmt=con.createStatement();
		String query="select *from Tdetail where Empid='"+empid.getSelectedItem()+"'";

		ResultSet rs=stmt.executeQuery(query);

		while(rs.next())
		{
		   t1.setText(rs.getString("name"));
		   t2.setText(rs.getString("fname"));
		   l4.setText(rs.getString("Empid"));
		   dob.setText(rs.getString("Dob"));
		   t3.setText(rs.getString("Address"));
		   t4.setText(rs.getString("Mobile_no"));
		   t5.setText(rs.getString("Email"));
		   t6.setText(rs.getString("x"));
		   t7.setText(rs.getString("xii"));
		   t8.setText(rs.getString("Aadhar_no"));
		   cbg.setText(rs.getString("Qualification"));
		   cbg1.setText(rs.getString("Department"));
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		empid.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				try 
				{
				Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
				Statement stmt=con.createStatement();
				String query="select *from Tdetail where Empid='"+empid.getSelectedItem()+"'";

				ResultSet rs=stmt.executeQuery(query);

				while(rs.next())
				{
				   t1.setText(rs.getString("name"));
				   t2.setText(rs.getString("fname"));
				   l4.setText(rs.getString("Empid"));
				   dob.setText(rs.getString("Dob"));
				   t3.setText(rs.getString("Address"));
				   t4.setText(rs.getString("Mobile_no"));
				   t5.setText(rs.getString("Email"));
				   t6.setText(rs.getString("x"));
				   t7.setText(rs.getString("xii"));
				   t8.setText(rs.getString("Aadhar_no"));
				   cbg.setText(rs.getString("Qualification"));
				   cbg1.setText(rs.getString("Department"));
				}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
		});
		
		b1=new JButton("Update");
		b1.setBounds(250,550,120,30);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif",Font.BOLD,20));
		add(b1);
		
		b2=new JButton("Reset");
		b2.setBounds(420,550,120,30);
		b2.setBackground(Color.blue);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif",Font.BOLD,20));
		add(b2);
		
		setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		
		new UpdateTeacher();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Teacher t = new Teacher();
		
		
		t.setEmpid(l4.getText());
		
		t.setTaddress(t3.getText());
		t.setTmno(t4.getText());
		t.setEmail(t5.getText());
		//s.setCls1(t6.getText());
		//s.setCls2(t7.getText());
		//s.setAadhar(t8.getText());
		t.setQua(cbg.getText());
		t.setDep(cbg1.getText());
		
		int x=0;
		Dbservice1 db = new Dbservice1();
		
		
		if(ae.getSource()==b1) {
			x = db.modifyTeacher(t);
			if(x>=1)
			{
				t1.setText("Record Update");
			}
			else
			{
				t1.setText("Record Not Inserted");
			}
		}
		if(ae.getSource()==b2) {
			dispose();
		}
		
	}

}

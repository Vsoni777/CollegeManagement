package Program;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class Enter_mark extends JFrame implements ActionListener {
		JLabel Home,head,sname,l1,l2,l3;
		Choice rollno;
		JComboBox c;
		JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
		JButton b1,b2;
	Enter_mark(){
		setSize(1000,500);
		setLocation(300,150);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("./icon./exam.jpg"));
		Image img1=img.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(img1);
		Home=new JLabel(img2);
		Home.setBounds(500,40,400,300);
		add(Home);
		
		head=new JLabel("Enter Marks of Student ");
		head.setBounds(50,0,500,50);
		head.setFont(new Font("serif",Font.ITALIC,20));
		add(head);
		
		sname=new JLabel("Select Roll no");
		sname.setBounds(50,70,150,20);
		sname.setFont(new Font("Tahona",Font.PLAIN,18));
		add(sname);
		
		rollno=new Choice();
		rollno.setBounds(200, 70, 150, 20);
		add(rollno);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Sdetail");
			while(rs.next()) {
				rollno.add(rs.getString("rollno"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		l1=new JLabel("Select Semester :");
		l1.setBounds(50, 110, 150, 20);
		add(l1);
		
		String sem[]= {"Select semester","1st","2nd","3rd","4th","5th","6th","7th","8th"};
		c=new JComboBox(sem);
		c.setBackground(Color.white);
		c.setBounds(200, 110, 150, 20);
		add(c);
		
		l2=new JLabel("Enter Subject");
		l2.setBounds(100,150,200,40);
		l2.setFont(new Font("Tahona",Font.PLAIN,18));
		add(l2);
		
		l3=new JLabel("Enter Marks");
		l3.setBounds(320,150,200,40);
		l3.setFont(new Font("Tahona",Font.PLAIN,18));
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(50, 200, 200, 20);
		add(t1);
		
		t2=new JTextField();
		t2.setBounds(50, 230, 200, 20);
		add(t2);
		
		t3=new JTextField();
		t3.setBounds(50, 260, 200, 20);
		add(t3);
		
		t4=new JTextField();
		t4.setBounds(50, 290, 200, 20);
		add(t4);
		
		t5=new JTextField();
		t5.setBounds(50, 320, 200, 20);
		add(t5);
		
		t6=new JTextField();
		t6.setBounds(270, 200, 200, 20);
		add(t6);
		
		t7=new JTextField();
		t7.setBounds(270, 230, 200, 20);
		add(t7);
		
		t8=new JTextField();
		t8.setBounds(270, 260, 200, 20);
		add(t8);
		
		t9=new JTextField();
		t9.setBounds(270, 290, 200, 20);
		add(t9);
		
		t10=new JTextField();
		t10.setBounds(270, 320, 200, 20);
		add(t10);
		
		b1=new JButton("Submit");
		b1.setBounds(70,360,150,25);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif",Font.BOLD,20));
		add(b1);
		
		b2=new JButton("Reset");
		b2.setBounds(280,360,150,25);
		b2.setBackground(Color.blue);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif",Font.BOLD,20));
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Enter_mark();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int x=0,y=0;
		String roll=rollno.getSelectedItem();
		String sem=(String)c.getSelectedItem();
		String sub1=t1.getText();
		String sub2=t2.getText();
		String sub3=t3.getText();
		String sub4=t4.getText();
		String sub5=t5.getText();
		String m1=t6.getText();
		String m2=t7.getText();
		String m3=t8.getText();
		String m4=t9.getText();
		String m5=t10.getText();
		if(ae.getSource()==b1) {
			try {
				Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
				PreparedStatement ps = con.prepareStatement("insert into Subject values(?,?,?,?,?,?,?)");
				PreparedStatement ps1 = con.prepareStatement("insert into Mark values(?,?,?,?,?,?,?)");

				ps.setString(1, roll);
				ps.setString(2,sem);
				ps.setString(3, sub1);
				ps.setString(4, sub2);
				ps.setString(5, sub3);
				ps.setString(6,sub4);
				ps.setString(7, sub5);
				
				ps1.setString(1, roll);
				ps1.setString(2,sem);
				ps1.setString(3, m1);
				ps1.setString(4, m2);
				ps1.setString(5, m3);
				ps1.setString(6,m4);
				ps1.setString(7, m5);
				ps.executeUpdate();
				ps1.executeUpdate();
				
					JOptionPane.showMessageDialog(null, "Subject marks Entered");
					setVisible(true);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

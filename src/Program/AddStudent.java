package Program;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
public class AddStudent extends JFrame implements ActionListener {
		JLabel head,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
		JTextField t1,t2,t3,t4,t5,t6,t7,t8;
		JDateChooser dob;
		JButton b1,b2;
		JComboBox cbg,cbg1;
		Random ran=new Random();
		long first4=Math.abs((ran.nextLong()%9000L)+1000L);
	AddStudent(){
		setSize(900,700);
		setLocation(350,30);
		setLayout(null);
		
		head=new JLabel("New student Details");
		head.setBounds(310,30,500,50);
		head.setFont(new Font("serif",Font.BOLD,20));
		add(head);
		
		l1=new JLabel("Name");
		l1.setBounds(50,150,100,30);
		l1.setFont(new Font("serif",Font.BOLD,20));
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(200,150,150,30);
		add(t1);
		
		l2=new JLabel("Father's Name");
		l2.setBounds(400,150,180,30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		add(l2);
		
		t2=new JTextField();
		t2.setBounds(600,150,150,30);
		add(t2);
		
		l3=new JLabel("Roll No");
		l3.setBounds(50,200,200,30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		add(l3);
		
		l4=new JLabel("1533"+first4);
		l4.setBounds(200,200,200,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		add(l4);
		
		l5=new JLabel("DOB");
		l5.setBounds(400,200,200,30);
		l5.setFont(new Font("serif",Font.BOLD,20));
		add(l5);
		
		dob=new JDateChooser();
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
		
		t6=new JTextField();
		t6.setBounds(600,300,150,30);
		add(t6);
		
		l10=new JLabel("Class XII(%)");
		l10.setBounds(50,350,200,30);
		l10.setFont(new Font("serif",Font.BOLD,20));
		add(l10);
		
		t7=new JTextField();
		t7.setBounds(200,350,150,30);
		add(t7);
		
		l11=new JLabel("Aadhar No");
		l11.setBounds(400,350,200,30);
		l11.setFont(new Font("serif",Font.BOLD,20));
		add(l11);
		
		t8=new JTextField();
		t8.setBounds(600,350,150,30);
		add(t8);
		
		l12=new JLabel("Course");
		l12.setBounds(50,400,200,30);
		l12.setFont(new Font("serif",Font.BOLD,20));
		add(l12);
		
		String course[]= {" ","BBA","B.tech","BSC","BCOM","BCA"};
		cbg=new JComboBox(course);
		cbg.setBounds(200,400,150,30);
		cbg.setBackground(Color.WHITE);
		add(cbg);
		
		l13=new JLabel("Branch");
		l13.setBounds(400,400,200,30);
		l13.setFont(new Font("serif",Font.BOLD,20));
		add(l13);
		
		String course1[]= {" ","Computer Science","Electrical","IT","Machancial","Civil"};
		cbg1=new JComboBox(course1);
		cbg1.setBounds(600,400,150,30);
		cbg1.setBackground(Color.WHITE);
		add(cbg1);
		
		b1=new JButton("SUBMIT");
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
		
		new AddStudent();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Student s = new Student();
		
		s.setName(t1.getText());
		s.setFname(t2.getText());
		s.setRollno(l4.getText());
		s.setDob(((JTextField)dob.getDateEditor().getUiComponent()).getText());
		s.setAddress(t3.getText());
		s.setMno(t4.getText());
		s.setEmail(t5.getText());
		s.setCls1(t6.getText());
		s.setCls2(t7.getText());
		s.setAadhar(t8.getText());
		s.setCourse1((String)cbg.getSelectedItem());
		s.setCourse2((String)cbg1.getSelectedItem());
		
		int x=0;
		DBService db = new DBService();
		
		
		if(ae.getSource()==b1) {
			x = db.addRecord(s);
			if(x>=1)
			{
				t1.setText("Record Inserted");
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

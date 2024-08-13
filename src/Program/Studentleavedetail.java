package Program;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Studentleavedetail extends JFrame implements ActionListener{
		JLabel l1,l2;
		Choice crollno;
		JTable table;
		JScrollPane jsp;
		JButton b1,b2,b3,b4,b5;
	public Studentleavedetail() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		l1=new JLabel("Search by Roll number");
		l1.setBounds(20,20,150,20);
		add(l1);
		
		crollno=new Choice();
		crollno.setBounds(180, 20, 150, 20);
		add(crollno);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Studentleave");
			while(rs.next()) {
				crollno.add(rs.getString("rollno"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		table=new JTable();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Studentleave");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		 jsp=new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 600);
		add(jsp);
		
		b1=new JButton("Search");
		b1.setBounds(20, 70, 80, 20);
		add(b1);
		
		b2=new JButton("Print");
		b2.setBounds(120, 70, 80, 20);
		add(b2);
		
		
		b3=new JButton("Reset");
		b3.setBounds(220, 70, 80, 20);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		setSize(900,700);
		setLocation(300,100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Studentleavedetail();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String query="select *from Studentleave where rollno='"+crollno.getSelectedItem()+"'";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				
			}
		}else if(ae.getSource()==b2) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b3) {
			setVisible(false);
			
		}
		
	}

}

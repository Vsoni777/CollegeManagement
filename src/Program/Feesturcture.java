package Program;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Feesturcture extends JFrame{
		JLabel head;
		JScrollPane jsp;
		JTable table;
	public Feesturcture() {
		setSize(1000,700);
		setLocation(250,50);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		head=new JLabel("Fee structure");
		head.setBounds(50, 10, 400, 30);
		head.setFont(new Font("Tahoma",Font.CENTER_BASELINE,30));
		add(head);
		
		table=new JTable();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Fee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		jsp=new JScrollPane(table);
		jsp.setBounds(0, 60, 1000, 700);
		add(jsp);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Feesturcture();

	}

}

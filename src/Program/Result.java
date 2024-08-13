package Program;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
public class Result extends JFrame implements ActionListener, MouseListener{
		JLabel head;
		JTextField search;
		JButton b1,b2;
		JTable table;
		JScrollPane jsp;
	Result(){
		setSize(1000,475);
		setLocation(300,100);
		setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         head=new JLabel("Check Result ");
 		 head.setBounds(80,15,400,50);
 		 head.setFont(new Font("serif",Font.ITALIC,24));
 		 add(head);
 		 
 		 search=new JTextField();
 		 search.setBounds(80,90,200,30);
 		 search.setFont(new Font("Tahoma",Font.PLAIN,18));
 		 add(search);
 		 
 		b1=new JButton("Result");
		b1.setBounds(300,90,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif",Font.BOLD,20));
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(440,90,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif",Font.BOLD,20));
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		table=new JTable();
		table.setFont(new Font("Tahoma",Font.PLAIN,14));
		
		jsp=new JScrollPane(table);
		jsp.setBounds(0,130,1000,310);
		add(jsp);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Sdetail");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		table.addMouseListener(this);
		setVisible(true);
	}
	
	
	
    public static void main(String[] args) {
    	new Result();
    }



	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			new Mark(search.getText());
			setVisible(false);
		}
		if(ae.getSource()==b2) {
			dispose();
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 2).toString());
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

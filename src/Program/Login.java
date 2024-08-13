package Program;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


class Login_m extends JDialog implements ActionListener,ItemListener {
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField pass;
	JButton b1,b2;
	JCheckBox n;
	Login_m(){
		getContentPane().setBackground(Color.orange);
		setLayout(null);
		
		l1=new JLabel("Username:");
		l1.setBounds(40, 20, 100, 30);
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(150,20,150,30);
		add(t1);
		
		l2=new JLabel("PassWord:");
		l2.setBounds(40, 70, 100, 30);
		add(l2);
		
		pass=new JPasswordField();
		pass.setBounds(150,70,150,30);
		add(pass);
		
		n=new JCheckBox("show me");
		n.setBounds(40, 120, 120, 40);
		n.setBackground(Color.orange);
		add(n);
		
		b1=new JButton("LOGIN");
		b1.setBounds(40,150,120,30);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2=new JButton("RESET");
		b2.setBounds(180,150,120,30);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icon./userl.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i=new ImageIcon(i2);
		l3=new JLabel(i);
		l3.setBounds(350, 10, 200, 200);
		add(l3);
		
		
		
		
		setBounds(500,200,600,300);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		n.addItemListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Student s = new Student();
		try {
			s.setUsername(t1.getText());	
		}
		catch (NumberFormatException e) 
		{
			t1.setText("Invalid Input");
		}
		
		try {
			s.setPasswrod(pass.getText());
		}
		catch (NumberFormatException e) 
		{
			pass.setText("Invalid Input");
		}
		int x=0;
		DBService db = new DBService();
		if(ae.getSource()==b1) {
		String user = t1.getText();
		String pass1 = pass.getText();
		boolean isValid =  db.check(user,pass1);
		if(isValid==true)
		{
			MyFrame ma=new MyFrame();
			ma.addWindowListener(new MyWindowAdapter(ma));
			ma.setVisible(true);
			setVisible(false);
		}
		else
		{
			JOptionPane op=new JOptionPane("Invalid user not Authorized",JOptionPane.WARNING_MESSAGE);
			JDialog ds=op.createDialog("Warininng!");
			ds.setAlwaysOnTop(true);
			ds.setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		}
		}
		if(ae.getSource()==b2) {
			t1.setText("");
			pass.setText("");
		}

	}

	@Override
	public void itemStateChanged(ItemEvent ae) {
		// TODO Auto-generated method stub
		//String a=new String(pass.getPassword());
		if(ae.getSource()==n) {
			
	            if (n.isSelected()) {
	                pass.setEchoChar((char) 0);
	            } else {
	                pass.setEchoChar('*');
	            }
		}
		
	}
}
public class Login{
	public static void main(String[] args) {
		Login_m asl=new Login_m();
		asl.setVisible(true);
		asl.setLocation(500, 200);
	}
}
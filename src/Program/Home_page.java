package Program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

class MyFrame extends JFrame implements ActionListener {
	JMenuBar mbar;
	JMenu Homeop,m1,m2,m3,m4,m5,m6,m7,m8;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16;
	ButtonGroup cbg;
	JRadioButton c1,c2,c3;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JPanel p1;
	JToolBar toolbar;
	JLabel  Home,l1,l2;
	MyFrame(){
		setTitle("Home");
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//setBounds(0,0,1550,1000);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("./icon./background.jpg"));
		Image img1=img.getImage().getScaledInstance(getWidth(),getHeight(), Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(img1);
		Home=new JLabel(img2);
		Home.setBounds(0, 0, getWidth(),getHeight());
		add(Home);
		
		/*l1=new JLabel();
		l1.setBounds(600, 60, 1000, 50);
		l1.setFont(new Font("Tahoma",Font.PLAIN,36));
		l1.setForeground(Color.WHITE);
		Home.add(l1);*/
		
		mbar=new JMenuBar();
		mbar.setBounds(0, 0,getWidth(), 25);
		mbar.setBackground(Color.black);
		Home.add(mbar);
		
		Homeop=new JMenu("Home");
		Homeop.setForeground(Color.YELLOW);
		mbar.add(Homeop);
		
		m1=new JMenu("New Information");
		m1.setForeground(Color.YELLOW);
		mbar.add(m1);
		
		m2=new JMenu("View Details");
		m2.setForeground(Color.YELLOW);
		mbar.add(m2);
		
		m3=new JMenu("Apply Leave");
		m3.setForeground(Color.YELLOW);
		mbar.add(m3);
		
		m4=new JMenu("Examination");
		m4.setForeground(Color.YELLOW);
		mbar.add(m4);
		
		m5=new JMenu("Update Details");
		m5.setForeground(Color.YELLOW);
		mbar.add(m5);
		
		m6=new JMenu("Fee Details");
		m6.setForeground(Color.YELLOW);
		mbar.add(m6);
		
		m7=new JMenu("Utility");
		m7.setForeground(Color.YELLOW);
		mbar.add(m7);
		
		m8=new JMenu("Leave details");
		m8.setForeground(Color.YELLOW);
		mbar.add(m8);
		
		i1=new JMenuItem("new Faculty information");
		i1.setBackground(Color.WHITE);
		i2=new JMenuItem("new Student information");
		i2.setBackground(Color.WHITE);
		m1.add(i1);m1.add(i2);
		
		i3=new JMenuItem("FaCulty Details:");
		i3.setBackground(Color.WHITE);
		i4=new JMenuItem("Student Details:");
		i4.setBackground(Color.WHITE);
		m2.add(i3);m2.add(i4);
		
		i5=new JMenuItem("FaCulty Leave");
		i5.setBackground(Color.WHITE);
		i6=new JMenuItem("Student Leave");
		i6.setBackground(Color.WHITE);
		m3.add(i5);m3.add(i6);
		
		i7=new JMenuItem("Exam Result");
		i7.setBackground(Color.WHITE);
		i8=new JMenuItem("Enter Marks");
		i8.setBackground(Color.WHITE);
		m4.add(i7);m4.add(i8);
		
		i9=new JMenuItem("Update Faculty Details");
		i9.setBackground(Color.WHITE);
		i10=new JMenuItem("Update Student Details");
		i10.setBackground(Color.WHITE);
		m5.add(i9);m5.add(i10);
		
		i11=new JMenuItem("Fee Structure");
		i11.setBackground(Color.WHITE);
		i12=new JMenuItem("Student Fee From");
		i12.setBackground(Color.WHITE);
		m6.add(i11);m6.add(i12);
		
		i13=new JMenuItem("Notepad");
		i13.setBackground(Color.WHITE);
		i14=new JMenuItem("Calculator");
		i14.setBackground(Color.WHITE);
		m7.add(i13);m7.add(i14);
		
		i15=new JMenuItem("Faculty leave detail");
		i15.setBackground(Color.cyan);
		i16=new JMenuItem("Student leave detail");
		i16.setBackground(Color.cyan);
		m8.add(i15);m8.add(i16);
		
		
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		i7.addActionListener(this);
		i8.addActionListener(this);
		i9.addActionListener(this);
		i10.addActionListener(this);
		i11.addActionListener(this);
		i12.addActionListener(this);
		i13.addActionListener(this);
		i14.addActionListener(this);
		i15.addActionListener(this);
		i16.addActionListener(this);

	}
	public void createtoolbar()
	{
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==i1) {
			new AddTeacher();
			
			
		}
		if(ae.getSource()==i2) {
			new AddStudent();
			
			
		}
		if(ae.getSource()==i3) {
		new TeacherDetail();
	
			
		}
		if(ae.getSource()==i4) {
			new StudentDetail();
			
			
		}
		if(ae.getSource()==i5) {
		new Teacherleave();
	
			
		}
		if(ae.getSource()==i6) {
		new Studentleave();
	
			
		}
		if(ae.getSource()==i7) {
			new Result();
		}
		if(ae.getSource()==i8) {
			new Enter_mark();
		
				
			}
		if(ae.getSource()==i9) {
			new UpdateTeacher();
		
				
			}
		if(ae.getSource()==i10) {
			new Updatestudent();
		
				
			}
		if(ae.getSource()==i11) {
			new Feesturcture();
		}
		if(ae.getSource()==i12) {
			new Payfeefrom();
		}
		if(ae.getSource()==i13) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {}
		}
		if(ae.getSource()==i14) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {}
		}
		if(ae.getSource()==i15) {
			new Teacherleavedetail();
		
				
			}
			if(ae.getSource()==i16) {
			new Studentleavedetail();
		
				
			}
	}
}
class MyWindowAdapter extends WindowAdapter
{
	MyFrame mf1;
	public MyWindowAdapter(MyFrame mf) 
	{
		mf1 = mf;
	}
	public void windowClosing(WindowEvent we)
	{
		int a=JOptionPane.showConfirmDialog(mf1,"Are you sure?");  
		if(a==JOptionPane.YES_OPTION)
		{  
		    mf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.exit(0);
		}
		if(a==JOptionPane.NO_OPTION) {
		
		}
	}
}

public class Home_page {
	public static void main(String[] args) {
		MyFrame ma=new MyFrame();
		ma.addWindowListener(new MyWindowAdapter(ma));
		ma.setVisible(true);
	}
}
package Program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBService 
{
	Connection con=null;
	public DBService() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("Jdbc:mysql://localhost:3309/vivek1","root","root");
		}
		catch (Exception e) 
		{
		
		}
	}
	
	public int modifyStudent(Student s)
	{
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("update Sdetail set address= ?,mob_no = ?,email=?,course=?,branch=? where rollno = ?");
		ps.setString(1, s.getAddress());
		ps.setString(2, s.getMno());
		ps.setString(3, s.getEmail());
		ps.setString(4, s.getCourse1());
		ps.setString(5, s.getCourse2());
		ps.setString(6, s.getRollno());
		x = ps.executeUpdate();
		ps.close();
		con.close();
		}
		catch (Exception e) 
		{
		
		}
		return x;
	}
	
	public boolean check(String user,String pass)
	{
		boolean isvalid=false;
		try 
		{
		PreparedStatement ps = con.prepareStatement("select * from login where username = ? and password = ?");
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
	
		if(rs.next()==true)
		{
			isvalid = true;
		}
		else
		{
			isvalid = false;
		}
		}
		catch (Exception e) 
		{
		
		}
		return isvalid;
	}
	
	public int addRecord( Student s) {
		int x=0;
		try 
		{
		PreparedStatement ps = con.prepareStatement("insert into Sdetail values(?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, s.getSname());
		ps.setString(2, s.getFname());
		ps.setString(3, s.getRollno());
		ps.setString(4, s.getDob());
		ps.setString(5, s.getAddress());
		ps.setString(6, s.getMno());
		ps.setString(7, s.getEmail());
		ps.setString(8, s.getCls1());
		ps.setString(9, s.getCls2());
		ps.setString(10, s.getAadhar());
		ps.setString(11, s.getCourse1());
		ps.setString(12, s.getCourse2());
		x = ps.executeUpdate();
		
		ps.close();
		con.close();
		}
		catch (Exception e) 
		{
		
		}
		return x;
		
	}
}
	

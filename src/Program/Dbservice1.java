package Program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Dbservice1 {
	Connection con=null;
	public Dbservice1() 
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
		public int addTRecord(Teacher t) {
			int x=0;
			try 
			{
				PreparedStatement ps = con.prepareStatement("insert into Tdetail values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1,t.getTname());
			ps.setString(2,t.getTfname());
			ps.setString(3,t.getEmpid());
			ps.setString(4,t.getDob());
			ps.setString(5,t.getTaddress());
			ps.setString(6,t.getTmno());
			ps.setString(7,t.getEmail());
			ps.setString(8,t.getTcls());
			ps.setString(9,t.getTcls1());
			ps.setString(10,t.getAadhar());
			ps.setString(11,t.getQua());
			ps.setString(12,t.getDep());
			x = ps.executeUpdate();
			
			}
			catch (Exception e) 
			{
			
			}
			return x;
			
		}
		
		public int modifyTeacher(Teacher t)
		{
			int x=0;
			try 
			{
			PreparedStatement ps = con.prepareStatement("update Tdetail set Address= ?,Mobile_no = ?,Email=?,Qualification=?,Department=? where Empid = ?");
			ps.setString(1, t.getTaddress());
			ps.setString(2, t.getTmno());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getQua());
			ps.setString(5, t.getDep());
			ps.setString(6, t.getEmpid());
			x = ps.executeUpdate();
			}
			catch (Exception e) 
			{
			
			}
			return x;
		}
	
	}


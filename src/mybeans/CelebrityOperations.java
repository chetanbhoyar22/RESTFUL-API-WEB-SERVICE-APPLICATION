package mybeans;
import java.sql.*;
import java.util.ArrayList;

public class CelebrityOperations 
{
	public Celebrity searchInfo(int no)
	{
		Celebrity obj=new Celebrity();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb?user=root&password=12345");
			pst=con.prepareStatement("select * from celebs where celebno=?;");
			pst.setInt(1, no);
			rs=pst.executeQuery();
			if(rs.next())
			{
				obj.setCelebno(rs.getInt("celebno"));
				obj.setCelebnm(rs.getString("celebnm"));
				obj.setField(rs.getString("field"));
				obj.setCountry(rs.getString("country"));
			}
			else
			{
				obj.setCelebno(0);
				obj.setCelebnm("Not Found");
				obj.setField("Not Found");
				obj.setCountry("Not Found");
			}
		}
		catch(Exception e)
		{
			obj.setCelebno(0);
			obj.setCelebnm("Error");
			obj.setField("Error");
			obj.setCountry("Error");
		}
		
		return(obj);
	}

	
	public ArrayList<Celebrity> getAllCelebrities()
	{
		ArrayList<Celebrity> list=new ArrayList<Celebrity>();
		Celebrity obj;
		
		Connection con;
		Statement st;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb?user=root&password=12345");
			st=con.createStatement();
			rs=st.executeQuery("select * from celebs;");
			while(rs.next())
			{
				obj=new Celebrity();
				obj.setCelebno(rs.getInt("celebno"));
				obj.setCelebnm(rs.getString("celebnm"));
				obj.setField(rs.getString("field"));
				obj.setCountry(rs.getString("country"));
				list.add(obj);
			}
			con.close();
		}
		catch(Exception e)
		{
			obj=new Celebrity();
			obj.setCelebno(0);
			obj.setCelebnm("Error");
			obj.setField("Error");
			obj.setCountry("Error");
			list.add(obj);
		}
		return(list);
	}
	
	
	public String addNewCelebrity(Celebrity c)
	{
		String createstatus="";
		Connection con;
		PreparedStatement pst;
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb?user=root&password=12345");
			pst=con.prepareStatement("insert into celebs(celebnm,field,country) values(?,?,?);");
			pst.setString(1, c.getCelebnm());
			pst.setString(2, c.getField());
			pst.setString(3, c.getCountry());
			pst.executeUpdate();
			createstatus="success";
			con.close();
			
		}
		catch(Exception e)
		{
			createstatus="failed";
		}
		
		
		return(createstatus);
	}
	public String deleteCelebrity(int no)
	{
		String stat="";
		Connection con;
		PreparedStatement pst;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb?user=root&password=12345");
			pst=con.prepareStatement("delete from celebs where celebno=?;");
			pst.setInt(1, no);
			int cnt=pst.executeUpdate();
			if(cnt>0)
				stat="success";
			else
				stat="not found";
			con.close();
			
		}
		catch(Exception e)
		{
			stat="failed";
		}
		
		return(stat);
	}

	
}











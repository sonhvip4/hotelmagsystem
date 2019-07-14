package hongocsonha.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MysqlDataAccessHelper {

	   public static Connection conn = null;
	   // xu ly ngoai le khi tuong tac voi csdl
	   public void displayError(SQLException ex){
	       System.out.println(" Error Message:" + ex.getMessage());
	       System.out.println(" SQL State:" + ex.getSQLState());
	       System.out.println(" Error Code:" + ex.getErrorCode());
	   }
	   
	   public void open()
	   {
			final String url= "jdbc:mysql://localhost:3306/hotelmanager";
			final String user= "root";
			final String password= "12345";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn= DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				displayError(e);
			}
	   }
	   
	   public void close(){// dong ket noi co so du lieu
	       try {
		        if(conn!=null) {
		               conn.close();
		         }
	       } catch (SQLException e) {
	           displayError(e);
	       }
	   }

	   //tao va thuc thi cac cau lenh sql
	   // cung cap thong tin trich rut tu csdl va cho phep truy xuat tung dong du lieu
	   public ResultSet excuteQuery(String sql){// danh cho cau lenh secect
	       ResultSet rs = null;
	       try {
	           Statement stm = (Statement) conn.createStatement();
	           rs = stm.executeQuery(sql);
	       } catch (SQLException ex) {
	           displayError(ex);
	       }
	       return rs;
	   }
	   
	   // select have parameter
	   public ResultSet excuteQuery(String query,List<Object> params) throws SQLException
	   {
			PreparedStatement stmt = conn.prepareStatement(query);
			for(int i = 0; i < params.size() ;i++)
			{
				if (params.get(i) == null)
				{
					stmt.setObject(i+1, null);
					continue;
				}
					
				if(params.get(i).getClass() == Integer.class)
				{
					stmt.setInt(i+1, (int)params.get(i)); 
					continue;
				}
				if(params.get(i).getClass() == Date.class)
				{
					stmt.setDate(i+1, (Date)params.get(i)); 
					continue;
				}
				if(params.get(i).getClass() == boolean.class)
				{
					stmt.setBoolean(i+1, (boolean)params.get(i)); 
					continue;
				}
				if(params.get(i).getClass() == String.class)
				{
					stmt.setString(i+1, ""+params.get(i)); 
					continue;
				}
				stmt.setObject(i+1, params.get(i));
				continue;

			}
	        return stmt.executeQuery();
	   }
	   
	   //searchExcuteQuery
		public ResultSet searchExcuteQuery(String query,String character) throws SQLException
		{
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,"%"+character+"%");
	        return stmt.executeQuery();
	        
		}
	   
	// insert,update,delete with no parameter
		public boolean executeUpdate(String query) throws SQLException
		{
			Statement stmt = conn.createStatement();
	 
	        int action = stmt.executeUpdate(query);
	        return action >0;
	        
		}
		// insert,update,delete with parameter

		public boolean executeUpdate(String query,List<Object> params) throws SQLException
		{
			PreparedStatement stmt = conn.prepareStatement(query);
			for(int i = 0; i < params.size() ;i++)
			{
				if (params.get(i) == null)
				{
					stmt.setObject(i+1, null);
					continue;
				}
					
				if(params.get(i).getClass() == Integer.class)
				{
					stmt.setInt(i+1, (int)params.get(i)); 
					continue;
				}
				if(params.get(i).getClass() == Date.class)
				{
					stmt.setDate(i+1, (Date)params.get(i)); 
					continue;
				}
				if(params.get(i).getClass() == boolean.class)
				{
					stmt.setBoolean(i+1, (boolean)params.get(i)); 
					continue;
				}
				if(params.get(i).getClass() == String.class)
				{
					stmt.setString(i+1, ""+params.get(i)); 
					continue;
				}
				stmt.setObject(i+1, params.get(i));
				continue;

			}
			
			int action = stmt.executeUpdate();
			return action >0;
		}
	   
}

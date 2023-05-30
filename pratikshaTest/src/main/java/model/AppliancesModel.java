package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppliancesModel 
{
	Connection con;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pratiksha_test?user=root&password=sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double getBill(String companyName,int quantity) 
	{
		PreparedStatement pstmt;
		ResultSet rs;
		double price=1;
		double getBill=1;
		int dbQuantity=0;
		
		String query1="select appliance_quantity,price_per_appliance from appliances_details where appliance_company=?";
		
		try {
			pstmt=con.prepareStatement(query1);
			pstmt.setString(1,companyName);
		    rs=pstmt.executeQuery();
		    if (rs.next())
		    {
		    	dbQuantity=rs.getInt(1);
		    	price=rs.getDouble(2);
		    	if(quantity<=dbQuantity)
		    	{
		    		getBill=quantity*price;
		    		updateQuantity(companyName,quantity,dbQuantity);
		    		
		    		
		    	}
		    	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBill;
	}
	public void updateQuantity(String companyName, int quantity,int dbQuantity) {
		PreparedStatement pstmt;
		
		String query2="update appliances_details set appliance_quantity=? where appliance_company=?";
		try {
			pstmt=con.prepareStatement(query2);
			pstmt.setInt(1, dbQuantity-quantity);
			pstmt.setString(2,companyName);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

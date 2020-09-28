package com.whatsappweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.whatsappweb.entity.WhatsAppWebUser;

public class WhatsAppWebDAO implements WhatsAppWebDAOInterface {

	public int registerDAO(WhatsAppWebUser ff) {
		// TODO Auto-generated method stub
		int i=0;
		PreparedStatement ps;
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
		
		
		//step 3 create query
	    ps=con.prepareStatement("insert into WhatsAppUser values(?,?,?,?)");
		ps.setString(1, ff.getName());
		ps.setString(2, ff.getPassword());
		ps.setString(3, ff.getEmail());
		ps.setString(4, ff.getAddress());
		i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		//step 4 executeQuery
		System.out.println(i);
						
		return i;
	}

	@Override
	public boolean loginDAO(WhatsAppWebUser ff) {
		// TODO Auto-generated method stub
		boolean i=false;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
			PreparedStatement ps=con.prepareStatement("select * from WhatsAppUser where Name=? and Password=?");
			ps.setString(1, ff.getName());
			ps.setString(2, ff.getPassword());
			
			
			//step 4 executeQuery
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=true;
			}
							
			
		}
		catch(ClassNotFoundException|SQLException ee) {
			ee.printStackTrace();
		}


		return i;
	}

}

package com.facebookweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.FacebookWebUser;
import com.facebookweb.entity.IrctcUser;

public class FacebookWebDAO implements FacebookWebDAOInterface {

	
	@Override
	public int registerDAO(FacebookUser ff) {
		// TODO Auto-generated method stub
		int i=0;
		PreparedStatement ps;
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
		
		
		//step 3 create query
	    ps=con.prepareStatement("insert into FacebookUser values(?,?,?,?)");
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

	
	public boolean loginDAO(FacebookUser ff) {
		boolean i=false;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
			PreparedStatement ps=con.prepareStatement("select * from FacebookUser where Name=? and Password=?");
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


	@Override
	public List<FacebookUser> FriendListDAO(FacebookUser ff) {
		// TODO Auto-generated method stub
		
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		FacebookUser f1=new FacebookUser();
		f1.setName("Zayeema");
		f1.setAddress("Kashmir");
		
		FacebookUser f2=new FacebookUser();
		f2.setName("Maya");
		f2.setAddress("Mumbai");
		
		ll.add(f1);
		ll.add(f2);
		/*try {
			PreparedStatement ps=con.prepareStatement("select * from friendlist where name=?");
			ps.setString(1, iu.getName());
		
			
			
			//step 4 executeQuery
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				FacebookEmployee f=new FacebookEmployee();
				f.setName(res.getString(1));
				f.setAddress(res.getString(4));
				ll.add(f);
			}
							
			
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}*/
		return ll;

		
	}


	@Override
	public boolean validateEmailDAO(FacebookUser ff) {
		// TODO Auto-generated method stub
		boolean i=false;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
			PreparedStatement ps=con.prepareStatement("select * from FacebookUser where Email=?");
			ps.setString(1, ff.getEmail());
			
			
			
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


	



	public List<FacebookUser> generateAddressDAO(FacebookUser ff) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public List<String> generateCountryDAO() {
		// TODO Auto-generated method stub
		List<String> fb=new ArrayList<String>();
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("******************************************************");
			Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
			PreparedStatement ps=con.prepareStatement("select country from FacebookWebUser");
		
			
			
			
			//step 4 executeQuery
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				fb.add(res.getNString("country"));
				System.out.println(fb);
			}
							
			
		}
		catch(ClassNotFoundException|SQLException ee) {
			ee.printStackTrace();
		}

		return fb;
	}


	@Override
	public List<String> countryDAO() {
		// TODO Auto-generated method stub
		List<String>ll=new ArrayList<String>();
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
		PreparedStatement ps=con.prepareStatement("select * from country");
		
		
		
		//step 4 executeQuery
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			ll.add(res.getString("country_name"));
		}
		}
		catch(ClassNotFoundException |SQLException e1)
		{
			e1.printStackTrace();
		}
		return ll;
	}


	@Override
	public List<String> StateDao(FacebookWebUser ff) {
		// TODO Auto-generated method stub
		List<String>ll=new ArrayList<String>();
		String cname=ff.getCountry();
		System.out.println(cname);
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
		PreparedStatement ps=con.prepareStatement("select id from country where country_name=? ");
		ps.setString(1, cname);
		ResultSet res=ps.executeQuery();
		//int id=res.getInt(1);
		if(res.next())
		{
			System.out.println("Inside if");
			PreparedStatement ps1=con.prepareStatement("select * from state where country_id=? ");
			
			ps1.setInt(1, res.getInt(1));
			ResultSet res1=ps1.executeQuery();
			
			//step 4 executeQuery
			//System.out.println(res1.next());
			while(res1.next()) {
				ll.add(res1.getString("state_name"));
			}	
		}
		//System.out.println(id);
		
		}
		catch(ClassNotFoundException |SQLException e1)
		{
			e1.printStackTrace();
		}
		return ll;
		
	}


	@Override
	public List<String> CityDao(FacebookWebUser ff) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<String>ll=new ArrayList<String>();
		String cname=ff.getCountry();
		//System.out.println(cname);
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
		PreparedStatement ps=con.prepareStatement("select state_id from state where state_name=? ");
		ps.setString(1, cname);
		ResultSet res=ps.executeQuery();
		//int id=res.getInt(1);
		if(res.next())
		{
			System.out.println("Inside city");
			PreparedStatement ps1=con.prepareStatement("select * from city where state_id=? ");
			
			ps1.setInt(1, res.getInt(1));
			ResultSet res1=ps1.executeQuery();
			
			//step 4 executeQuery
			//System.out.println(res1.next());
			while(res1.next()) {
				ll.add(res1.getString("city_name"));
			}	
			System.out.println(ll);
		}
		System.out.println("Outside City");
		
		
		}
		catch(ClassNotFoundException |SQLException e1)
		{
			e1.printStackTrace();
		}
		return ll;
		
	}


	@Override
	public List<IrctcUser> sourceDao(){
		// TODO Auto-generated method stub
		Connection con=null;
		List<IrctcUser> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
		PreparedStatement ps=con.prepareStatement("select * from IRCTC");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<IrctcUser>();
		
		while(res.next()) {
			IrctcUser uu=new IrctcUser();
			uu.setCity(res.getString(2));
			
			ll.add(uu);
		}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return ll;
		
	}
	

}

package com.Facebook2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Facebook2.entity.FacebookUser;

public class FacebookDao implements FacebookDaoInterface {
	
public FacebookUser signInDao(FacebookUser fu)  {
	FacebookUser fu1=null;
	Connection con=null;
	try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("select * from FacebookUser where Name=? and Password=?");
	ps.setString(1,fu.getName());
	ps.setString(2, fu.getPassword());
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		fu1=new FacebookUser();
		fu1.setName(rs.getString(1));
		fu1.setPassword(rs.getString(2));
		fu1.setEmail(rs.getString(3));
		fu1.setAddress(rs.getString(4));
	}
	}
	catch(ClassNotFoundException|SQLException e1)
	{
		e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		}
		catch(SQLException e1)
		{
		e1.printStackTrace();
		}
	}
	return fu1;
	
}
public int signUpDao(FacebookUser fu) {
	Connection con=null;
	int i=0;
	try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("insert into FacebookUser values(?,?,?,?)");
	ps.setString(1,fu.getName());
	ps.setString(2, fu.getPassword());
	ps.setString(3, fu.getEmail());
	ps.setString(4, fu.getAddress());
	i=ps.executeUpdate();
	}
	catch(ClassNotFoundException|SQLException e1)
	{
		e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		}
		catch(SQLException e1)
		{
		e1.printStackTrace();
		}
	}
	return i;
	
}
public int deleteProfileDao(FacebookUser fu) 
{

    int rs=0;
    Connection con=null;
    try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("delete from FacebookUser where Name=? and Password=?");
	ps.setString(1,fu.getName());
	ps.setString(2, fu.getPassword());
	rs=ps.executeUpdate();
    }
    catch(ClassNotFoundException|SQLException e1)
	{
		e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		}
		catch(SQLException e1)
		{
		e1.printStackTrace();
		}
	}
	return rs;
}
public List<FacebookUser> searchProfileDao(FacebookUser fu){
	FacebookUser ff=null;
	List <FacebookUser> ll=new ArrayList<FacebookUser>(); 
	Connection con=null;
	try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("select * from FacebookUser where Name=?");
	ps.setString(1,fu.getName());
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		ff=new FacebookUser();
		ff.setName(rs.getString(1));
		ff.setPassword(rs.getString(2));
		ff.setEmail(rs.getString(3));
		ff.setAddress(rs.getString(4));
		ll.add(ff);
		
	}
	}
catch(ClassNotFoundException | SQLException e1)
	{
	e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		}
		catch(SQLException e1)
		{
		e1.printStackTrace();
		}
	}
	return ll;
}
public FacebookUser viewProfileDao(FacebookUser fu) {
	FacebookUser ff=null;
	Connection con=null;
	try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
 con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("select * from FacebookUser where Name=? and Password=?");
	ps.setString(1,fu.getName());
	ps.setString(2,fu.getPassword());
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		ff=new FacebookUser();
		ff.setName(rs.getString(1));
		ff.setPassword(rs.getString(2));
		ff.setEmail(rs.getString(3));
		ff.setAddress(rs.getString(4));
		
		
	}
	}
	catch(ClassNotFoundException | SQLException e1)
	{
	e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		}
		catch(SQLException e1)
		{
		e1.printStackTrace();
		}
	}
	return ff;
}

public int editProfileByNameDao(FacebookUser fu) 
{

	Connection con=null;
	int rs=0;
	try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("update FacebookUser set Name=? where Email=?");
	ps.setString(1,fu.getName());
	ps.setString(2, fu.getEmail());
	 rs=ps.executeUpdate();
	}
	catch(ClassNotFoundException | SQLException e1)
	{
	e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		}
		catch(SQLException e1)
		{
		e1.printStackTrace();
		}
	}
	return rs;
}
public int editProfileByPasswordDao(FacebookUser fu) 
{

	Connection con=null;
	int rs=0;
	try {

	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	 con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("update FacebookUser set Password=? where Email=?");
	ps.setString(1,fu.getPassword());
	ps.setString(2, fu.getEmail());
	 rs=ps.executeUpdate();
	}
	 catch(ClassNotFoundException | SQLException e1)
		{
		e1.printStackTrace();
		}
		finally {
			try {
			con.close();
			}
			catch(SQLException e1)
			{
			e1.printStackTrace();
			}
		}
	return rs;
}
public int editProfileByAddressDao(FacebookUser fu) throws Exception
{


	Connection con=null;
	int rs=0;
	try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con=DriverManager.getConnection("jdbc:derby:f:/firstdb1;create=true","sakshi","sakshi");
	PreparedStatement ps=con.prepareStatement("update FacebookUser set Address=? where Email=?");
	ps.setString(1,fu.getAddress());
	ps.setString(2, fu.getEmail());
    rs=ps.executeUpdate();
	}
	 catch(ClassNotFoundException | SQLException e1)
		{
		e1.printStackTrace();
		}
		finally {
			try {
			con.close();
			}
			catch(SQLException e1)
			{
			e1.printStackTrace();
			}
		}
	return rs;
}
}


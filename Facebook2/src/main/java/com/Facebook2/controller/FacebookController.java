package com.Facebook2.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.Facebook2.entity.FacebookUser;
import com.Facebook2.service.FacebookService;
import com.Facebook2.service.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface{
	private FacebookServiceInterface fs;
	public FacebookController()
	{
		fs=new FacebookService();
	}
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public void signUp() 
	{
		try {
		System.out.println("Enter username");
		String name=br.readLine();
		System.out.println("Enter password");
		String password=br.readLine();
		System.out.println("Enter email");
		String email=br.readLine();
		System.out.println("Enter address");
		String address=br.readLine();
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		
		int i=fs.signUpService(fu);
		if(i>0)
		{
			System.out.println("Profile created");
		}
		else
		{
			System.out.println("Could not create profile");
		}
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
	}
	public void signIn()
	{
		try {
		System.out.println("Enter username");
		String name=br.readLine();
		System.out.println("Enter password");
		String password=br.readLine();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		
		
		FacebookUser ff=fs.signInService(fu);
		String cc="y";
		
		if(ff!=null)
		{
			while(cc.equals("y")) {
			System.out.println("press 1 to Search profile");
			System.out.println("press 2 to Edit profile");
			System.out.println("press 3 to View profile");
			System.out.println("press 4 to Delete profile");
			System.out.println("enter your choice ");
			int i=Integer.parseInt(br.readLine());
			switch(i)
			{
			case 1:searchProfile();
			break;
			case 2:editProfile(ff);
			break;
			case 3:viewProfile(ff);
			break;
			case 4:deleteProfile(ff);
			break;
			default:System.out.println("wrong choice");
			}
		System.out.println("Do you want to continue??");
		System.out.println("If yes press y else press n");
		cc=br.readLine();
			}
		}
		else
		{
			System.out.println("Enter valid username and password");
		}
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
	
	}
	private void deleteProfile(FacebookUser ff)  {
		// TODO Auto-generated method stub
	    
		String name=ff.getName();
		String password=ff.getPassword();
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		
		int i=fs.deleteProfileService(fu);
		if(i>0)
		{
			System.out.println("Profile Deleted");
		}
		else
		{
			System.out.println("could not delete profile");
		}
	    
	}
	private void viewProfile(FacebookUser ff)  {
		// TODO Auto-generated method stub
		
		FacebookUser fu=new FacebookUser();
		fu.setName(ff.getName());
		fu.setPassword(ff.getPassword());
		FacebookUser ll=fs.viewProfileService(fu);
		if(ll!=null)
		{       System.out.println("**************************************************");
				System.out.println("Name: "+ll.getName());
				System.out.println("Password: "+ll.getPassword());
				System.out.println("Email: "+ll.getEmail());
				System.out.println("Address: "+ll.getAddress());
				System.out.println("**************************************************");
		}
		else
		{
			System.out.println("User with name "+ll.getName()+" does not exist.");
		}
				
			
	}
	private void editProfile(FacebookUser ff)  {
		// TODO Auto-generated method stub
		String cc="y";
		try {
		viewProfile(ff);
		
		while(cc.equals("y")) {
		System.out.println("press 1 to update name");
		System.out.println("press 2 to update password");
		System.out.println("press 3 to update address");
		
		
		System.out.println("Enter your choice:");
		int i=Integer.parseInt(br.readLine());
		
		
		
		switch(i)
		{
		case 1:editProfileByName(ff);
		break;
		case 2:editProfileByPassword(ff);
		break;
		case 3:editProfileByAddress(ff);
		break;
		
		default: System.out.println("Wrong Choice");
		}
		System.out.println("Do you want to edit??");
		System.out.println("If yes press y else press n");
		cc=br.readLine();
		}
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
		
	}
	
	private void editProfileByAddress(FacebookUser ff)  {
		// TODO Auto-generated method stub
		try {
		System.out.println("Enter new addres: ");
		String new_address=br.readLine();
		FacebookUser fu1=new FacebookUser();
		fu1.setAddress(new_address);
		fu1.setEmail(ff.getEmail());
		
		int i=fs.editProfileByAddressService(fu1);
		if(i>0)
		{
			System.out.println("Profile Updated");
		}
		else
		{
			System.out.println("Could not Update profile");
		}
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
	}
	
	private void editProfileByPassword(FacebookUser ff)  {
		// TODO Auto-generated method stub
		try {
		System.out.println("Enter new password: ");
		String new_password=br.readLine();
		FacebookUser fu1=new FacebookUser();
		fu1.setPassword(new_password);
		fu1.setEmail(ff.getEmail());
		
		int i=fs.editProfileByPasswordService(fu1);
		if(i>0)
		{
			System.out.println("Profile Updated");
		}
		else
		{
			System.out.println("Could not Update profile");
		}
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
	}
	private void editProfileByName(FacebookUser ff)  {
		// TODO Auto-generated method stub
		try {
		System.out.println("Enter new name: ");
		String new_name=br.readLine();
		FacebookUser fu1=new FacebookUser();
		fu1.setName(new_name);
		fu1.setEmail(ff.getEmail());
		
		int i=fs.editProfileByNameService(fu1);
		if(i>0)
		{
			System.out.println("Profile Updated");
		}
		else
		{
			System.out.println("Could not Update profile");
		}
		
	}
	catch(IOException e1)
	{
	e1.printStackTrace();
	}
	
	}
	private void searchProfile()  {
		// TODO Auto-generated method stub
		try {
		System.out.println("Enter username");
		String name=br.readLine();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		List <FacebookUser> ll=fs.searchProfileService(fu);
		System.out.println(ll.size()+" no. of users found");
		if(ll.size()==0)
		{
			System.out.println("No user found.");
		}
		else {
			for(FacebookUser l:ll)
			{
				System.out.println("**************************************************");
				System.out.println("Name: "+l.getName());
				System.out.println("Email: "+l.getEmail());
				System.out.println("Address: "+l.getAddress());
				System.out.println("**************************************************");
				
			}
		}
		
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
		
		
	}
}
/*
*********************************MAIN MENU************************
press 1 to Sign In
press 2 to Sign Up
enter your choice 
1
Enter username
Sakshi
Enter password
riya
press 1 to Search profile
press 2 to Edit profile
press 3 to View profile
press 4 to Delete profile
enter your choice 
2
**************************************************
Name: Sakshi
Password: riya
Email: riya@yahoo.com
Address: Nagpur
**************************************************
press 1 to update name
press 2 to update password
press 3 to update address
Enter your choice:
2
Enter new password: 
sakshi
Profile Updated
Do you want to continue??
If yes press y else press n
y
press 1 to update name
press 2 to update password
press 3 to update address
Enter your choice:
4
Wrong Choice
Do you want to continue??
If yes press y else press n
n
Do you want to continue??
If yes press y else press n
y
press 1 to Search profile
press 2 to Edit profile
press 3 to View profile
press 4 to Delete profile
enter your choice 
1
Enter username
Isha
2 no. of users found
**************************************************
Name: Isha
Email: isha@yahoo.com
Address: Mumbai
**************************************************
**************************************************
Name: Isha
Email: isha@yahoo.com
Address: Chennai
**************************************************
Do you want to continue??
If yes press y else press n
n
Do you want to continue??
Press y to continue
Press n to sign out
n
*/
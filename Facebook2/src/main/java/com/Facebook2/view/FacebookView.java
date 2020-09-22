package com.Facebook2.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.Facebook2.controller.FacebookController;
import com.Facebook2.controller.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int i=0;
String cc="y";
try {
System.out.println("*********************************MAIN MENU************************");
System.out.println("press 1 to Sign In");
System.out.println("press 2 to Sign Up");

System.out.println("enter your choice ");
i=Integer.parseInt(br.readLine());

FacebookControllerInterface fi=new FacebookController();

while(cc.equals("y")) {
switch(i)
{
case 1:fi.signIn();
break;
case 2:fi.signUp(); 
break;
		 
default:System.out.println("wrong choice");
}
System.out.println("Do you want to continue??");
System.out.println("Press y to continue");
System.out.println("Press n to sign out");
cc=br.readLine();
}
}
catch(IOException e1)
{
	e1.printStackTrace();
}

	}

}

package com.Instagram.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.Instagram.controller.InstagramController;
import com.Instagram.controller.InstagramControllerInterface;

public class InstagramView {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("*********************************MAIN MENU************************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to edit profile");
		System.out.println("press 3 to delete profile");
		System.out.println("press 4 to view profile");
		System.out.println("press 5 to search profile");
		
		
		System.out.println("enter your choice ");
		int i=Integer.parseInt(br.readLine());
		
		
		InstagramControllerInterface fi=new InstagramController();
		
		
		switch(i) {
		
		case 1: fi.createProfile();
			break;
		case 2: fi.editProfile();
			break;
		case 3:fi.deleteProfile();
			break;
		case 4:fi.viewProfile();
			break;
		case 5:fi.searchProfile();
			break;
		
		default:System.out.println("wrong choice");
		
		}
	}
	}

/*
 *********************************MAIN MENU************************
press 1 to create profile
press 2 to edit profile
press 3 to delete profile
press 4 to view profile
press 5 to search profile
enter your choice 
3
Profile deleted
Profile deleted
Profile deleted
*/

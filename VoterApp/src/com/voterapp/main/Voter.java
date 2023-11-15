package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.service.ElectionBooth;

public class Voter {

	public static void main(String[] args) {
		ElectionBooth election = new ElectionBooth();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the age to check for voting:");
		int agecheck = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your corresponding locality: ");
		String locality = scanner.nextLine();
		System.out.println("Enter your voter ID: ");
		int voteid = scanner.nextInt();
		try {
			scanner.close();
			election.checkEligibility(agecheck, locality, voteid);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}

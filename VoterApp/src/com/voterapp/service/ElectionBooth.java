package com.voterapp.service;

import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.NotEligibleException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBooth {
	String[] localities = { "Chennai", "Madurai", "Svpr", "Coimbatore", "Salem" };

	public boolean checkAge(int age) throws UnderAgeException {
		boolean flag = false;
		if (age < 18) {
			throw new UnderAgeException("Age should be greater than 18!");
		} else {
			flag = true;
		}
		return flag;
	}

	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean flag = false;
		for (String loc : localities) {
			if (loc.equalsIgnoreCase(locality)) {
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new LocalityNotFoundException("There is no election in your locality");
		}

		return flag;
	}

	public boolean checkVoterID(int vid) throws NoVoterIDException {
		boolean flag = false;
		if (vid >= 100 && vid <= 999) {
			flag = true;
		} else {
			flag = false;
			throw new NoVoterIDException("Age is not valid! Give correct age");
		}
		return flag;

	}

	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {
		boolean flag = false;

		boolean checkage = checkAge(age);
		boolean checkloc = checkLocality(locality);
		boolean checkvid = checkVoterID(vid);
		if (checkage == true) {
			if (checkloc == true) {
				if (checkvid == true) {
					flag = true;
				}
			}
		} else {
			flag = false;
			throw new NotEligibleException("Not Eligible to vote!");
		}
		return flag;
	}
}

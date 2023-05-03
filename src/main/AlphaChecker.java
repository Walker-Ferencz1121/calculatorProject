package main;

import java.util.*;

public class AlphaChecker {
	
	String[] alphabetList = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y",
			"z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	public AlphaChecker(String s) {
		returnAlpha(s);
	}
	
	public String returnAlpha(String s) {
		String alphaAns = "";
		
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<alphabetList.length; j++) {
				if (s.contains(alphabetList[j])) {
					alphaAns = alphabetList[j];
				}
			}
		}
		return alphaAns;
	}
}

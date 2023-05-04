package main.checkingAlgorithms;

import java.util.*;

public class SymbolChecker {

	String[] operators = {"\\+", "-", "\\*", "/", "="};
	
	public void checkForSymbol(String s) {
		String tempStr = "";
//		if (s.contains("sqrt"))
//			tempStr = s.replace("sqrt", "");
//		String temp[] = tempStr.split("(?<=[\\(\\)\\+\\-*\\/\\^\\=A-Za-z])|(?=[\\(\\)\\+\\-*\\/\\^\\=A-Za-z])");
		
		tempStr = s.replace(" ", "");
		String temp[] = tempStr.split("(?<=[\\(\\)\\+\\-*\\/\\=])|(?=[\\(\\)\\+\\-*\\/\\=])");
		List<String> numList = new ArrayList<String>();
		numList = Arrays.asList(temp);
		
		for (int i=0; i<numList.size(); i++) {
//			for (int j=0; j<operators.length; j++) {
				if(Objects.equals("-",  numList.get(i))) {
					numList.remove(i);
				}
//			}
		}
		System.out.println(numList);
	}
	
	public String printEquation(String s) {
		return s.replace(" ", "");
	}
	
	public String alphaVar(String s) {	AlphaChecker alpha = new AlphaChecker();
		String userVar = "";
		
		if (s.contains(alpha.returnAlpha(s))) {
			userVar = alpha.returnAlpha(s);
		}
		
		return userVar;
	}
}

//String temp[] = s.split("(?<=[\\(\\)\\+\\-*\\/\\^\\=A-Za-z])|(?=[\\(\\)\\+\\-*\\/\\^\\=A-Za-z])");

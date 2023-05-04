package main;

import java.util.ArrayList;

import main.checkingAlgorithms.AlphaChecker;

public class CoeffAndVarCalculations {
	ArrayList<Integer> coeffList = new ArrayList<Integer>();
	ArrayList<String> varExpoList = new ArrayList<String>();
	ArrayList<Integer> expoList = new ArrayList<Integer>();
	
	//Removes exponents to retrieve list of coefficients
	public ArrayList<Integer> getCoefficient(ArrayList<String> ls) {
		
		for (int i=0; i<ls.size(); i++) {
			AlphaChecker alpha = new AlphaChecker();
			
			if (ls.get(i).contains("^")) {
				coeffList.add(stringToInt(ls.get(i).replace(ls.get(i).substring(ls.get(i).length()-3, ls.get(i).length()), "")));
				varExpoList.add(ls.get(i).substring(ls.get(i).length()-3, ls.get(i).length()));
				expoList.add(stringToInt(ls.get(i).substring(ls.get(i).length()-1)));
			}
			else if (ls.get(i).contains(alpha.returnAlpha(ls.get(i))) && alpha.returnAlpha(ls.get(i)) != "") {
				if (ls.get(i).length() == 1) {
					coeffList.add(1);
				}
				else {
					coeffList.add(stringToInt(ls.get(i).replace(alpha.returnAlpha(ls.get(i)), "")));
				}
				varExpoList.add(alpha.returnAlpha(ls.get(i)));
				expoList.add(1);
			}
			else {
				coeffList.add(stringToInt(ls.get(i)));
				varExpoList.add("1");
				expoList.add(0);
			}
		}
		
		return coeffList;
	}
	
	public int stringToInt(String s) {
		return Integer.parseInt(s);
	}
	
	public String intToString(int n) {
		return String.valueOf(n);
	}
}
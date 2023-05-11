package main;

import java.util.ArrayList;

import main.checkingAlgorithms.AlphaChecker;
import main.checkingAlgorithms.SymbolChecker;

public class CoeffAndVarCalculations {
	ArrayList<String> numList = new ArrayList<String>();
	ArrayList<Integer> coeffList = new ArrayList<Integer>();
	ArrayList<String> varExpoList = new ArrayList<String>();
	ArrayList<Integer> expoList = new ArrayList<Integer>();
	ArrayList<String> opList = new ArrayList<String>();
	public int negCoeff = 0;
	
	//Removes exponents to retrieve list of coefficients
	public void createLists(ArrayList<String> ls) {
		AlphaChecker alpha = new AlphaChecker();
		SymbolChecker symbol = new SymbolChecker();
		
		for (int i=0; i<ls.size(); i++) {	
			numList.add(ls.get(i));
			if (ls.get(i).contains("^")) {
				coeffList.add(stringToInt(ls.get(i).replace(ls.get(i).substring(ls.get(i).length()-3, ls.get(i).length()), "")));
				varExpoList.add(ls.get(i).substring(ls.get(i).length()-3, ls.get(i).length()));
				expoList.add(stringToInt(ls.get(i).substring(ls.get(i).length()-1)));
			}
			else if (ls.get(i).contains(alpha.isAlpha(ls.get(i))) && alpha.isAlpha(ls.get(i)) != "") {
				if (ls.get(i).length() == 1) {
					coeffList.add(1);
				}
				else {
					coeffList.add(stringToInt(ls.get(i).replace(alpha.isAlpha(ls.get(i)), "")));
				}
				varExpoList.add(alpha.isAlpha(ls.get(i)));
				expoList.add(1);
			}
			else if (symbol.hasOperator(ls.get(i))) {
				opList.add(ls.get(i));
				ls.remove(ls.get(i));
				i--;
			}
			else {
				coeffList.add(stringToInt(ls.get(i)));
				varExpoList.add("1");
				expoList.add(0);
			}
		}
		
		for (int j=0; j<opList.size(); j++) {
			if (opList.get(j).matches("-")) {
				if (opList.size() == coeffList.size()) {
					negCoeff = coeffList.get(j) * -1;
					coeffList.set(j, negCoeff);
				}
				else {
					negCoeff = coeffList.get(j+1) * -1;
					coeffList.set(j+1, negCoeff);
				}
			}
		}
	}
	
	public int stringToInt(String s) {
		return Integer.parseInt(s);
	}
	
	public String intToString(int n) {
		return String.valueOf(n);
	}
}
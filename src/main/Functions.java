package main;

import java.util.*;

import main.checkingAlgorithms.AlphaChecker;
import main.checkingAlgorithms.SymbolChecker;

public class Functions {
	
	CoeffAndVarCalculations calc = new CoeffAndVarCalculations();
	SymbolChecker symbol = new SymbolChecker();
	ArrayList<String> calcList = new ArrayList<String>();
	
	//Print the problem
	public void printedFunction(String equation, String evalVar) {
		String statement = ("f(" + evalVar + ")=" + equation).replace(" ", "");
		System.out.println(statement);
	}
	
	//Create the list from the equation
	public ArrayList<String> createList(String s) {
		String tempStr = "";
		
		tempStr = s.replace(" ", "");
		String temp[] = tempStr.split("(?<=[\\(\\)\\+\\-*\\/\\=])|(?=[\\(\\)\\+\\-*\\/\\=])");
		List<String> fixedList = Arrays.asList(temp);
		ArrayList<String> numList = new ArrayList<String>(fixedList);
		calc.createLists(numList);

		return numList;
	}
	
	//Solve the problem
	public void totalFunctionCalculation(ArrayList<String> ls, String evaluation) {
		int totalSum = 0;
		int count = 0;
		AlphaChecker alpha = new AlphaChecker();
		
		for (int j=0; j<ls.size(); j++) {
			if (calc.varExpoList.get(j).contains("^")) {
//				if (alpha.isAlpha(ls.get(j)) == alpha.alphaVar(evaluation)) {
					calcList.add(calc.intToString(calc.coeffList.get(j) * (int)Math.pow(calc.stringToInt(evaluation), calc.expoList.get(j))));
//				}
//				else {
//					calcList.add("0");
//					count++;
//					System.out.print(ls.get(j) + " ");
//				}
			}
			else if (calc.varExpoList.get(j).contains(alpha.isAlpha(ls.get(j))) && alpha.isAlpha(ls.get(j)) != "") {
//				if (alpha.isAlpha(ls.get(j)) == alpha.alphaVar(evaluation)) {
					calcList.add(calc.intToString(calc.coeffList.get(j) * calc.stringToInt(evaluation)));
//				}
//				else {
//					calcList.add("0");
//					count++;
//					System.out.print(ls.get(j) + " ");
//				}
			}
			else {
				calcList.add(calc.intToString(calc.coeffList.get(j)));
			}
			totalSum += calc.stringToInt(calcList.get(j));
		}
		if (totalSum < 0 && count != 0)
			System.out.println("- " + (totalSum * -1));
		else if (totalSum > 0 && count != 0)
			System.out.println("+ " + totalSum);
		else
			System.out.println(totalSum);
	}
}
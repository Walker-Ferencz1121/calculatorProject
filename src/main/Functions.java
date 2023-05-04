package main;

import java.util.*;

import main.checkingAlgorithms.AlphaChecker;
import main.checkingAlgorithms.SymbolChecker;

public class Functions {
	
	CoeffAndVarCalculations calc = new CoeffAndVarCalculations();
	SymbolChecker symbol = new SymbolChecker();
	ArrayList<String> calcList = new ArrayList<String>();
	
	public Functions(String s) {
		System.out.println(createList(s));
		
		System.out.println(calc.coeffList);
		System.out.println(calc.varExpoList);
		System.out.println(calc.expoList);
	}
	
//	public Functions(ArrayList<String> ls, String evalVar, String evaluation) {		
//		calc.getCoefficient(ls);
//		
//		printedFunction(ls, evalVar, evaluation);
////		System.out.println(totalFunctionCalculation(ls, evalVar, evaluation));
//		totalFunctionCalculation(ls, evalVar, evaluation);
//
//		System.out.println(ls);
//		System.out.println(calc.coeffList);
//		System.out.println(calc.varExpoList);
//		System.out.println(calc.expoList);
//	}
	
	public void printedFunction(ArrayList<String> ls, String evalVar, String evaluation) {
		int posCoeff = 0;
		
		//Print out the problem
		System.out.print("f(" + evalVar + ") = ");
		for (int i=0; i<ls.size(); i++) {
			if (i == 0) {
				System.out.print(ls.get(i) + " ");
			}
			else if (calc.coeffList.get(i) < 0) {
				posCoeff = calc.coeffList.get(i) * -1;
				System.out.print("- " + posCoeff + calc.varExpoList.get(i) + " ");
			}
			else {
				System.out.print("+ " + ls.get(i) + " ");
			}
		}
		System.out.println();
	}
	
	public ArrayList<String> createList(String s) {
		String tempStr = "";
		int posNum;
		
		tempStr = s.replace(" ", "");
		String temp[] = tempStr.split("(?<=[\\(\\)\\+\\-*\\/\\=])|(?=[\\(\\)\\+\\-*\\/\\=])");
		List<String> fixedList = Arrays.asList(temp);
		ArrayList<String> numList = new ArrayList<String>(fixedList);

		return numList;
	}
	
	public ArrayList<String> posNegValues(ArrayList<String> ls) {
		for (int i=0; i<ls.size(); i++) {
			if (symbol.hasOperator(ls.get(i))) {
				ls.remove(i);
			}
		}
		return ls;
	}
	
	public void totalFunctionCalculation(ArrayList<String> ls, String evalVar, String evaluation) {
		int totalSum = 0;
		int count = 0;
		
		//Solve the problem
		for (int j=0; j<ls.size(); j++) {
			AlphaChecker alpha = new AlphaChecker();

			if (calc.varExpoList.get(j).contains("^")) {
				if (alpha.hasAlpha(ls.get(j)) == evalVar) {
					calcList.add(calc.intToString(calc.coeffList.get(j) * (int)Math.pow(calc.stringToInt(evaluation), calc.expoList.get(j))));
				}
				else {
					calcList.add("0");
					count++;
					System.out.print(ls.get(j) + " ");
				}
			}
			else if (calc.varExpoList.get(j).contains(alpha.hasAlpha(ls.get(j))) && alpha.hasAlpha(ls.get(j)) != "") {
				if (alpha.hasAlpha(ls.get(j)) == evalVar) {
					calcList.add(calc.intToString(calc.coeffList.get(j) * calc.stringToInt(evaluation)));
				}
				else {
					calcList.add("0");
					count++;
					System.out.print(ls.get(j) + " ");
				}
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
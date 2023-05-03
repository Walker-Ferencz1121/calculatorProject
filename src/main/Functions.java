package main;

import java.util.*;

public class Functions {
	
	CoeffAndVarCalculations calc = new CoeffAndVarCalculations();
	ArrayList<Integer> calcList = new ArrayList<Integer>();
	
	public Functions(ArrayList<String> ls, String evaluation) {		
		calc.getCoefficient(ls);
		
		printedFunction(ls, evaluation);
		System.out.println(totalFunctionCalculation(ls, evaluation));
		
//		System.out.println(calc.coeffList);
//		System.out.println(calc.varExpoList);
//		System.out.println(calc.expoList);
	}
	
	private void printedFunction(ArrayList<String> ls, String evaluation) {
		int posCoeff = 0;
		
		//Print out the problem
		System.out.print("f(" + evaluation + ") = ");
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
	
	private int totalFunctionCalculation(ArrayList<String> ls, String evaluation) {
		int totalSum = 0;
		
		//Solve the problem
		for (int j=0; j<ls.size(); j++) {
			if (calc.varExpoList.get(j).contains("^")) {
				calcList.add(calc.coeffList.get(j) * (int)Math.pow(calc.stringToInt(evaluation), calc.expoList.get(j)));
			}
			else if (calc.varExpoList.get(j).contains("x")) {
				calcList.add(calc.coeffList.get(j) * calc.stringToInt(evaluation));
			}
			else {
				calcList.add(calc.coeffList.get(j));
			}
			totalSum += calcList.get(j);
		}
		return totalSum;
	}
}
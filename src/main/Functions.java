package main;

import java.util.*;

public class Functions {
	
	CoeffAndVarCalculations calc = new CoeffAndVarCalculations();
	ArrayList<String> calcList = new ArrayList<String>();
	
	public Functions(ArrayList<String> ls, String evalVar, String evaluation) {		
		calc.getCoefficient(ls);
		
		printedFunction(ls, evalVar, evaluation);
//		System.out.println(totalFunctionCalculation(ls, evalVar, evaluation));
		totalFunctionCalculation(ls, evalVar, evaluation);

		
//		System.out.println(calc.coeffList);
//		System.out.println(calc.varExpoList);
//		System.out.println(calc.expoList);
	}
	
	private void printedFunction(ArrayList<String> ls, String evalVar, String evaluation) {
		int posCoeff = 0;
		
		//Print out the problem
		System.out.println(evalVar + " = " + evaluation);
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
	
	private void totalFunctionCalculation(ArrayList<String> ls, String evalVar, String evaluation) {
		int totalSum = 0;
		int count = 0;
		
		//Solve the problem
		for (int j=0; j<ls.size(); j++) {
			AlphaChecker alpha = new AlphaChecker(ls.get(j));

			if (calc.varExpoList.get(j).contains("^")) {
				if (alpha.returnAlpha(ls.get(j)) == evalVar) {
					calcList.add(calc.intToString(calc.coeffList.get(j) * (int)Math.pow(calc.stringToInt(evaluation), calc.expoList.get(j))));
				}
				else {
					calcList.add("0");
					count++;
					System.out.print(ls.get(j) + " ");
				}
			}
			else if (calc.varExpoList.get(j).contains(alpha.returnAlpha(ls.get(j))) && alpha.returnAlpha(ls.get(j)) != "") {
				if (alpha.returnAlpha(ls.get(j)) == evalVar) {
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
package main;

import java.util.*;

import main.checkingAlgorithms.AlphaChecker;
import main.checkingAlgorithms.SymbolChecker;

public class Functions {
	CoeffAndVarCalculations calc = new CoeffAndVarCalculations();
	SymbolChecker symbol = new SymbolChecker();
//	ArrayList<String> calcList = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	public boolean flag = true;
	
	public String setEquation() {
		System.out.println("Please enter your equation leaving out the f(x)= portion:");
		return sc.nextLine();
	}
	
	public void runFunction(String equation) {
		String userInput = "";

		while (flag) {
			System.out.println("Now enter the value you want to evaluate:");
			String userEval = sc.nextLine();
			
			System.out.println("==========================================");
			
			printedFunction(equation, userEval);
			totalFunctionCalculation(createList(equation), userEval);
			
			System.out.println("Type 'y' to continue, 'x' for new equation and 'n' to quit program");
			userInput = sc.nextLine().toLowerCase();
			if (userInput.matches("n")) {
				flag = false;
			}
			else if (userInput.matches("x")) {
				runFunction(setEquation());
			}
			else
				runFunction(equation);
		}
	}
	
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
				totalSum += (calc.coeffList.get(j) * (int)Math.pow(calc.stringToInt(evaluation), calc.expoList.get(j)));
			}
			else if (calc.varExpoList.get(j).contains(alpha.isAlpha(ls.get(j))) && alpha.isAlpha(ls.get(j)) != "") {
				totalSum += calc.coeffList.get(j) * calc.stringToInt(evaluation);
			}
			else {
				totalSum += calc.coeffList.get(j);
			}
		}
		System.out.println(totalSum);
		totalSum = 0;
	}
}
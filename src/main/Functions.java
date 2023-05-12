package main;

import java.util.*;

import main.checkingAlgorithms.AlphaChecker;
import main.checkingAlgorithms.SymbolChecker;

public class Functions {
	CoeffAndVarCalculations calc = new CoeffAndVarCalculations();
	Scanner sc = new Scanner(System.in);
	public boolean flag = true;
	
	//Sets the equation, is called when new equation is ran
	public String setEquation() {
		System.out.println("Please enter your equation leaving out the f(x)= portion:");
		return sc.nextLine();
	}
	
	//Print the problem
	public String printedFunction(String equation, String evalVar) {
		return ("f(" + evalVar + ")=" + equation).replace(" ", "");
	}
	
	//Main portion that will be ran
	public void runFunction(String equation) {
		String userInput = "";

		while (flag) {
			System.out.println("Now enter the value you want to evaluate:");
			String userEval = sc.nextLine();
			
			System.out.println("==========================================");
			
			printedFunction(equation, userEval);
			createList(equation);
//			totalFunctionCalculation(createList(equation), userEval);
			
			System.out.println("Type 'y' to continue, 'x' for new equation and 'n' to quit program");
			userInput = sc.nextLine().toLowerCase();
			if (userInput.matches("n")) {
				flag = false;
			}
			else if (userInput.matches("x")) {
				runFunction(setEquation());
			}
			else {
				calc.numList.clear();
				calc.coeffList.clear();
				calc.varExpoList.clear();
				calc.expoList.clear();
				calc.opList.clear();
				runFunction(equation);
			}
		}
	}
	
	//Create the list from the equation
//	public ArrayList<String> createList(String s) {
	public void createList(String s) {
		String tempStr = "";
		ArrayList<String> numList = new ArrayList<String>();
		
		tempStr = s.replace(" ", "");
		if (tempStr.contains("/")) {
			String temp[] = tempStr.split("(?<=[\\(\\)\\/\\=])|(?=[\\(\\)\\/\\=])");
			List<String> fixedList = Arrays.asList(temp);
			numList.addAll(fixedList);
			for (int i=0; i<numList.size(); i++) {
				
			}
			System.out.println(numList);
		}
		else {
			String temp[] = tempStr.split("(?<=[\\(\\)\\+\\-*\\/\\=])|(?=[\\(\\)\\+\\-*\\/\\=])");
			List<String> fixedList = Arrays.asList(temp);
			numList.addAll(fixedList);
			System.out.println(numList);
		}
//		calc.createLists(numList);
		
//		System.out.println(calc.numList);
//		System.out.println(calc.varExpoList);
		
//		return numList;
	}
	
	//Solve the function
	public void totalFunctionCalculation(ArrayList<String> ls, String evaluation) {
		int totalSum = 0;
		AlphaChecker alpha = new AlphaChecker();
		SymbolChecker symbol = new SymbolChecker();
		
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
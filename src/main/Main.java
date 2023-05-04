package main;

import java.util.*;

import main.checkingAlgorithms.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlphaChecker alpha = new AlphaChecker();
		
		String equation = "3 - 5x - 2x^2";
		String userEval = "4";
		
//		ArrayList<String> functionList = new ArrayList<String>();
//		functionList.add("3");
//		functionList.add("-5x");
//		functionList.add("-2x^2");
//		new Functions(functionList, alpha.alphaVar(equation), userEval);
		
//		System.out.println("Please enter your equation leaving out the f(x)= portion.");
//		String equation = sc.nextLine();
		//sqrt1-z^2
		
//		System.out.println("f(" + alpha.alphaVar(equation) + ")=" + symbol.printEquation(equation));
//		symbol.checkForSymbol(equation);
		
		System.out.println("==========================================");
		Functions fun = new Functions(equation);
		
		sc.close();
	}
}

package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> functionList = new ArrayList<String>();
		functionList.add("3");
		functionList.add("-5x");
		functionList.add("-2x^2");
		
//		System.out.println("Enter the value to evaluate: ");
//		int userNum = sc.nextInt();
		
		String equation = "f(x) = 3 / 5x - 2x^2";
		
		String userVar = "x";
		String userEval = "4";
		
		new SymbolChecker(equation);
//		new Functions(equation, userVar, userEval);
//		new Functions(functionList, userVar, userEval);
	}
}

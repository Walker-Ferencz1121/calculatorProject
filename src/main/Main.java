package main;

import java.util.*;

import main.checkingAlgorithms.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Functions fun = new Functions();
		
//		String equation = "3 - 5x - 2x^2";
//		String userEval = "4";
		
		System.out.println("Please enter your equation leaving out the f(x)= portion:");
		String equation = sc.nextLine();
		System.out.println("Now enter the value you want to evaluate:");
		String userEval = sc.nextLine();
		
		System.out.println("==========================================");
		
		fun.printedFunction(equation, userEval);
		fun.totalFunctionCalculation(fun.createList(equation), userEval);
		
		sc.close();
	}
}

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
		
		fun.runFunction(equation);
		
		sc.close();
	}
}
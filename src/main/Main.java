package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> functionList = new ArrayList<String>();
		
		functionList.add("3");
		functionList.add("-5x");
		functionList.add("-2p^2");
		
//		System.out.println("Enter the value to evaluate: ");
//		int userNum = sc.nextInt();
		String userVar = "x";
		String userEval = "4";
		
//		new AlphaChecker(functionList);
		
		new Functions(functionList, userVar, userEval);
	}
}

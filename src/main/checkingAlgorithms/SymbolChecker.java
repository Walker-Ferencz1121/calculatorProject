package main.checkingAlgorithms;

public class SymbolChecker {

	String[] operators = {"+", "-", "*", "/", "="};

	public boolean hasOperator(String s) {
//		String opAns = "";
		boolean opAns = false;
		
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<operators.length; j++) {
				if (s.contains(operators[j]))
					opAns = true;
			}
		}
		return opAns;
	}
	
	public String isOperator(String s) {
		String opAns = "";
		
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<operators.length; j++) {
				if (s.contains(operators[j])) {
					opAns = operators[j];
				}
			}
		}
		return opAns;
	}
}

package main;

import java.util.*;

public class SymbolChecker {

	String[] operators = {"\\+", "-", "\\*", "/", "="};
	
	public SymbolChecker(String s) {
		String temp[] = s.split("(?<=[\\(\\)\\+\\-*\\/\\^\\=A-Za-z])|(?=[\\(\\)\\+\\-*\\/\\^\\=A-Za-z])");
		System.out.println(Arrays.toString(temp));
	}
}

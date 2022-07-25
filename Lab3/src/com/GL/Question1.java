package com.GL;

import java.util.Stack;

public class Question1 {
	// program of Balancing Brackets.

	public static void main(String[] args) {
		// Hard coded input
		String s = "([[{}]])";

		if (checkBalancedBrackets(s)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

	}

	private static boolean checkBalancedBrackets(String str) {
		// checking for balance bracket in string s

		Stack<Character> stack = new Stack<Character>();
		int len = str.length();

		for (int i = 0; i < len; i++) {
			char a = str.charAt(i);

			if (a == '(' || a == '{' || a == '[') {
				stack.push(a);
				continue;
			}
			if (stack.isEmpty())
				return false;

			char b;

			switch (a) {
			case '}':
				b = stack.pop();
				if (b != '{')
					return false;
				break;
			case ']':
				b = stack.pop();
				if (b != '[')
					return false;
				break;
			case ')':
				b = stack.pop();
				if (b != '(')
					return false;
				break;

			}
		}
		return stack.isEmpty();
	}

}

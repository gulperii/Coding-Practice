import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class InorderTo {
	private Stack<String> theStack;
	List<String> tokenList = new ArrayList<>();
	private String output = "";

	/*
	 * Tokenizes <pre>input</pre>, creates empty stack. A token is either an operand
	 * (number), an operator (+,-,*,/), or open/close a parenthesis.
	 * 
	 * @param input the input read from user
	 */
	public Infix2Postfix(String input) {
		// StringTokenizer converts a string into a sequence of tokens. Token separators
		// are specified the second parameter as "+-/*()".
		StringTokenizer st = new StringTokenizer(input, "+-/*()", true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			tokenList.add(token);
		}
		theStack = new Stack<String>();
		// System.out.println("Token list:" + tokenList);
	}

	/*
	 * Processes <code>tokenList</code>.
	 * <ul>
	 *   <li> If token is an operand, it is appended to the output. </li> 
	 *   <li> If token is '(', just push it to the stack. </li>
	 *   <li> If token is ')', then pop the stack until '(' is observed and append them to the output
	 *        (except for '('). </li>
	 *   <li> If token is an operator, then call <code>isOperator</code> method with corresponding precedence. </li> 
	 *   <li> After all of <code>tokenList</code> is processed, keep popping and appending to the output
	 *        until the stack is empty. </li>
	 * </ul>
	 * 
	 * @return The string that contains the corresponding <b>postfix expression</b>.
	 */
	public String processTokens() {
		for (String token : tokenList) {
			if (token.equals("+") || token.equals("-"))
				isOperator(token, 1);
			else if (token.equals("*") || token.equals("/"))
				isOperator(token, 2);
			else if (token.equals("("))
				theStack.push(token);
			else if (token.equals(")"))
				isParenthesis();
			else
				output = output + " " + token;
		}
		
		// Pop all remaining items in the stack.
		while (!theStack.isEmpty()) {
			output = output + " " + theStack.pop();
		}
		return output;
	}

	/*
	 * Takes necessary action for <code>newOperator</code>.
	 * <ul>
	 *    <li> If <code>newOperator</code> has higher precedence than the operator at the top of the stack, 
	 *         then push <code>newOperator</code> to the stack. </li> 
	 *    <li> Else, if <code>newOperator</code> has lower precedence than the operator at the top of the stack, 
	 *         then keep popping from the stack and appending to the output until either stack is empty 
	 *         or a lower priority operator is encountered. </li>
	 * </ul>
	 * 
	 * @param newOperator the operator to be processed
	 * 
	 * @param precedence1 the precedence of the first parameter
	 */
	public void isOperator(String newOperator, int precedence1) {
		while (!theStack.isEmpty()) {
			String operatorAtTop = theStack.pop();
			if (operatorAtTop.equals("(")) {
				theStack.push(operatorAtTop);
				break;
			} else {
				int precedence2;
				if (operatorAtTop.equals("+") || operatorAtTop.equals("-"))
					precedence2 = 1;
				else
					precedence2 = 2;

				if (precedence2 < precedence1) {
					theStack.push(operatorAtTop);
					break;
				} else
					output = output + " " + operatorAtTop;
			}
		}
		theStack.push(newOperator);
	}

	/*
	 * Processes ')' character. Pop the stack until '(' is observed and append them to the output (except for '(').
	 */
	public void isParenthesis() {
		while (!theStack.isEmpty()) {
			String match = theStack.pop();
			if (match.equals("("))
				break;
			else
				output = output + " " + match;
		}
	}
}

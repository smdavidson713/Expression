/**
Sydney Davidson
Lab 8
CSI 213
*/

public interface Lab08{

	/**
	Converts an infix expression to a 
	postfix expression
	@return ArrayList<String>
	*/

	public ArrayList<String> infixToPostfix();

	/**
	Evaluates the postfix expression from the previous
	method and returns the result from this method
	@return int 
	*/

	public int evaluate();

	/**
	Determines if the character is an operator
	@return char
	*/
	public boolean isOp(char ch);

	/**
	Checks the precedence of the operators
	@param char
	@return int
	*/

	public int prec(char ch);

	/**
	Gets the infix expression
	@return String[]
	*/
	public String[] getInfix();

	/**
	Sets the infix expression
	@param String[]
	*/
	public void setInfix(String[] infix);

/**
	sets the postfix expression
	@param ArrayList<String>
	*/
	public void setPostfix(ArrayList<String> postfix);

	/**
	Gets the postfix expression
	@return ArrayList<String>
	*/
	public ArrayList<String> getPostfix();


}
/**
Sydney Davidson
Lab 8
CSI 213
*/
import java.util.Stack;
import java.lang.Character;
import java.util.ArrayList;
public class Expression{

	private String[] infix;
	ArrayList<String> postfix = new ArrayList<>();

	/**
	Converts an infix expression to a 
	postfix expression
	@return ArrayList 
	*/

	public ArrayList<String> infixToPostfix(){
		ArrayList<String> postfix = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < infix.length; i++){
			String ch = infix[i];
			char c = ch.charAt(0);
			if(Character.isDigit(c)){
				postfix.add(infix[i]);
			}
			else if(ch.compareTo("(") == 0){
				stack.push(ch);
			}
			else if(isOp(c)){
				if(stack.empty()){
					stack.push(ch);

				}
				else if(!stack.empty()){
					while(!stack.empty()){
						if(stack.peek() == ")"){
							stack.push(ch);
							break;
						}
						if(prec(stack.peek().charAt(0)) < prec(c)){
							stack.push(ch);
							break;
						}
						if(prec(stack.peek().charAt(0)) > prec(c)){
							postfix.add(stack.pop());
						}
						if(prec(stack.peek().charAt(0)) == prec(c)){
							postfix.add(stack.pop());
							stack.push(ch);
							break;
						}
					}
				}

			}
			else if(ch.compareTo(")") == 0){
				while(!stack.empty()){
					if(stack.peek().compareTo("(") == 0){
						stack.pop();
						break;
					}
					postfix.add(stack.pop());
				}
			}
		}

		while(!stack.empty()){
			if(stack.peek().compareTo("(") == 0){
				stack.pop();
				break;
			}
			postfix.add(stack.pop());
		}
		return postfix;
	}


	/**
	Evaluates the postfix expression from the previous
	method and returns the result from this method
	@return int 
	*/

	public int evaluate(ArrayList<String> postfix){
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < postfix.size(); i++){
			String ch = postfix.get(i);
			char c = ch.charAt(0);

			if(Character.isDigit(c))
				stack.push(ch);
			else{
				int x = Integer.parseInt(stack.pop());
				int y = Integer.parseInt(stack.pop());

				switch(c){

					case '+':
					stack.push(Integer.toString(y+x));
					break;

					case '-':
					stack.push(Integer.toString(y-x));
					break;

					case '*':
					stack.push(Integer.toString(y*x));
					break;

					case '/':
					stack.push(Integer.toString(y/x));
					break;
				}

			}
			
		}
		return Integer.parseInt(stack.pop());
	}

	/**
	Determines if the character is an operator
	@return char
	*/
	public boolean isOp(char ch){

		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	/**
	Checks the precedence of the operators
	@param char
	@return int
	*/

	public int prec(char ch){
		switch(ch){
			case '+':
			case '-':

			return 1;

			case '*':
			case'/':

			return 2;
		}
		return -1;
	}

	/**
	sets the infix expression
	@param String
	*/

	public void setInfix(String[] infix){
		this.infix = infix;
	}

	/**
	Gets the infix expression
	@return string
	*/

	public String[] getInfix(){
		return infix;
	}

	/**
	sets the postfix expression
	@param String
	*/

	public void setPostix(ArrayList<String> postfix){
		this.postfix = postfix;
	}

	/**
	Gets the postfix expression
	@return string
	*/

	public ArrayList<String> getPostfix(){
		return postfix;
	}
}
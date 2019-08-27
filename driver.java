/**
Sydney Davidson
Lab 8
CSI 213
*/
import java.io.*;
import java.util.*;
public class driver{
	public static void start()throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		String line = br.readLine();
		ArrayList<String> postfix = new ArrayList<>();
		while(line != null){
			String[] exp = line.split(" ");
			Expression e = new Expression();
			e.setInfix(exp);
			postfix = e.infixToPostfix();
			System.out.println(e.evaluate(postfix));
			line = br.readLine();
		}

	}
}
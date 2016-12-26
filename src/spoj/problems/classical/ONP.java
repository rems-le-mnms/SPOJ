/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/ONP/
==========================================================
STATUS : AC 0.06s
 */
package spoj.problems.classical;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Stack;

public class ONP {

	

		private static final int LEFT_ASSOC = 0;
		private static final int RIGHT_ASSOC = 1;
	 
		// Supported operators
		private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();

		static {
			// Map<"token", []{precendence, associativity}>
			OPERATORS.put("+", new int[] { 0, LEFT_ASSOC });
			OPERATORS.put("-", new int[] { 0, LEFT_ASSOC });
			OPERATORS.put("*", new int[] { 5, LEFT_ASSOC });
			OPERATORS.put("/", new int[] { 5, LEFT_ASSOC });
			OPERATORS.put("%", new int[] { 5, LEFT_ASSOC });
			OPERATORS.put("^", new int[] { 10, RIGHT_ASSOC });
		}
	 
		/**
		 * Test if a certain is an operator .
		 * @param token The token to be tested .
		 * @return True if token is an operator . Otherwise False .
		 */
		private static boolean isOperator(String token) {
			return OPERATORS.containsKey(token);
		}
	 
		/**
		 * Test the associativity of a certain operator token .
		 * @param token The token to be tested (needs to operator).
		 * @param type LEFT_ASSOC or RIGHT_ASSOC
		 * @return True if the tokenType equals the input parameter type .
		 */
		private static boolean isAssociative(String token, int type) {
			if (!isOperator(token)) {
				throw new IllegalArgumentException("Invalid token: " + token);
			}
			if (OPERATORS.get(token)[1] == type) {
				return true;
			}
			return false;
		}
	 
		/**
		 * Compare precendece of two operators.
		 * @param token1 The first operator .
		 * @param token2 The second operator .
		 * @return A negative number if token1 has a smaller precedence than token2,
		 * 0 if the precendences of the two tokens are equal, a positive number
		 * otherwise.
		 */
		private static final int cmpPrecedence(String token1, String token2) {
			if (!isOperator(token1) || !isOperator(token2)) {
				throw new IllegalArgumentException("Invalied tokens: " + token1
						+ " " + token2);
			}
			return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
		}

		public static String[] infixToRPN(String[] inputTokens) {
			ArrayList<String> out = new ArrayList<String>();
			Stack<String> stack = new Stack<String>();
			// For all the input tokens [S1] read the next token [S2]
			for (String token : inputTokens) {
				if (isOperator(token)) {
					// If token is an operator (x) [S3]
					while (!stack.empty() && isOperator(stack.peek())) {
						// [S4]
						if ((isAssociative(token, LEFT_ASSOC) && cmpPrecedence(
								token, stack.peek()) <= 0)
								|| (isAssociative(token, RIGHT_ASSOC) && cmpPrecedence(
										token, stack.peek()) < 0)) {
							out.add(stack.pop()); 	// [S5] [S6]
							continue;
						}
						break;
					}
					// Push the new operator on the stack [S7]
					stack.push(token);
				} else if (token.equals("(")) {
					stack.push(token); 	// [S8]
				} else if (token.equals(")")) {
					// [S9]
					while (!stack.empty() && !stack.peek().equals("(")) {
						out.add(stack.pop()); // [S10]
					}
					stack.pop(); // [S11]
				} else {
					out.add(token); // [S12]
				}
			}
			while (!stack.empty()) {
				out.add(stack.pop()); // [S13]
			}
			String[] output = new String[out.size()];
			return out.toArray(output);
		}
	

	static class FasterScanner {
			private InputStream mIs;
			private byte[] buf = new byte[1024];
			private int curChar;
			private int numChars;

			public FasterScanner() {
				this(System.in);
			}

			public FasterScanner(InputStream is) {
				mIs = is;
			}

			public int read() {
				if (numChars == -1)
					throw new InputMismatchException();
				if (curChar >= numChars) {
					curChar = 0;
					try {
						numChars = mIs.read(buf);
					} catch (IOException e) {
						throw new InputMismatchException();
					}
					if (numChars <= 0)
						return -1;
				}
				return buf[curChar++];
			}

			public String nextLine() {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				StringBuilder res = new StringBuilder();
				do {
					res.appendCodePoint(c);
					c = read();
				} while (!isEndOfLine(c));
				return res.toString();
			}

			public String nextString() {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				StringBuilder res = new StringBuilder();
				do {
					res.appendCodePoint(c);
					c = read();
				} while (!isSpaceChar(c));
				return res.toString();
			}

			public long nextLong() {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				int sgn = 1;
				if (c == '-') {
					sgn = -1;
					c = read();
				}
				long res = 0;
				do {
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					res *= 10;
					res += c - '0';
					c = read();
				} while (!isSpaceChar(c));
				return res * sgn;
			}

			public int nextInt() {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				int sgn = 1;
				if (c == '-') {
					sgn = -1;
					c = read();
				}
				int res = 0;
				do {
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					res *= 10;
					res += c - '0';
					c = read();
				} while (!isSpaceChar(c));
				return res * sgn;
			}

			public boolean isSpaceChar(int c) {
				return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
			}

			public boolean isEndOfLine(int c) {
				return c == '\n' || c == '\r' || c == -1;
			}

		}
	
	static class FasterOutput {
		private final PrintWriter writer;


		public FasterOutput(OutputStream outputStream) {
			
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}


		public FasterOutput(Writer writer) {
			this.writer = new PrintWriter(writer);
		}


		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}


		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}


		public void close() {
			writer.close();
		}


		public void flush() {
			writer.flush();
		}
	}

	public static void main(String[] args) throws Exception {
		
		FasterScanner in=new FasterScanner();
		FasterOutput out=new FasterOutput(System.out);
		int t=in.nextInt();
		String[] input = new String[t];
		for(int i=0; i< t; i++) {
			input[i] = in.nextLine();
			String[] result = infixToRPN(input[i].split(""));
			StringBuilder builder = new StringBuilder();
			for(String s : result) {
			    builder.append(s);
			}
			out.printLine(builder.toString());
		}
		out.flush();
		out.close();

	}
}
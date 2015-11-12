package spoj.problems.classical;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Arith {
	public static void main(String[] args) throws Exception {
		try {
			FasterScanner in = new FasterScanner();
			FasterOutput out = new FasterOutput(System.out);
			int n = in.nextInt();
			String[] input = new String[n];
			for (int i = 0; i < input.length; i++) {
				input[i] = in.nextLine();
			}
			for (int i = 0; i < input.length; i++) {
				String[] nb = input[i].split("[+*-]");
				
				BigInteger nb1 = new BigInteger(nb[0]);
				BigInteger nb2 = new BigInteger(nb[1]);
				BigInteger res;
				int width;
				for (int j = 0; j < input[i].length(); j++) {
					char c = input[i].charAt(j);
					switch (c) {
					case '+':
						res = nb1.add(nb2);
						width = Math.max(res.toString().length(), nb[1].length()+1);
						for (int k2 = 0; k2 < width - nb[0].length(); k2++) {
							out.print(' ');
						}
						for (int k2 = 0; k2 < nb[0].length(); k2++) {
							out.print(nb[0].charAt(k2));
						}
						out.printLine();
						for (int k2 = 0; k2 < width - nb[1].length()-1; k2++) {
							out.print(' ');
						}
						out.print(c);
						for (int k2 = 0; k2 < nb[1].length(); k2++) {
							out.print(nb[1].charAt(k2));
						}
						out.printLine();
						for (int k = 0; k < width; k++) {
							out.print('-');	
						}
						out.printLine();
						for (int k = 0; k < width - res.toString().length(); k++) {
							out.print(' ');
						}
						out.printLine(res.toString());
						break;
					case '-' :
						res = nb1.subtract(nb2);
						width = Math.max(nb[0].length(), nb[1].length()+1);
						for (int k2 = 0; k2 < width - nb[0].length(); k2++) {
							out.print(' ');
						}
						for (int k2 = 0; k2 < nb[0].length(); k2++) {
							out.print(nb[0].charAt(k2));
						}
						out.printLine();
						for (int k2 = 0; k2 < width - nb[1].length()-1; k2++) {
							out.print(' ');
						}
						out.print(c);
						for (int k2 = 0; k2 < nb[1].length(); k2++) {
							out.print(nb[1].charAt(k2));
						}
						out.printLine();
						for (int k = 0; k < width; k++) {
							out.print('-');	
						}
						out.printLine();
						for (int k = 0; k < width - res.toString().length(); k++) {
							out.print(' ');
						}
						out.printLine(res.toString());
						break;
					case '*' : 
						res = nb1.multiply(nb2);
						width = Math.max(Math.max(res.toString().length(), nb[0].length()),nb[1].length()+1);
						if(nb[1].length() == 1) {
							for (int k2 = 0; k2 < width - nb[0].length(); k2++) {
								out.print(' ');
							}
							for (int k2 = 0; k2 < nb[0].length(); k2++) {
								out.print(nb[0].charAt(k2));
							}
							out.printLine();
							for (int k2 = 0; k2 < width - nb[1].length()-1; k2++) {
								out.print(' ');
							}
							out.print(c);
							for (int k2 = 0; k2 < nb[1].length(); k2++) {
								out.print(nb[1].charAt(k2));
							}
							out.printLine();
							for (int k = 0; k < width; k++) {
								out.print('-');	
							}
							out.printLine();
							for (int k = 0; k < width - res.toString().length(); k++) {
								out.print(' ');
							}
							out.printLine(res.toString());break;
						} else {
							for (int k2 = 0; k2 < width - nb[0].length(); k2++) {
								out.print(' ');
							}
							for (int k2 = 0; k2 < nb[0].length(); k2++) {
								out.print(nb[0].charAt(k2));
							}
							out.printLine();
							for (int k2 = 0; k2 < width - nb[1].length()-1; k2++) {
								out.print(' ');
							}
							out.print(c);
							for (int k2 = 0; k2 < nb[1].length(); k2++) {
								out.print(nb[1].charAt(k2));
							}
							out.printLine();
							for (int k = 0; k < width - Math.max(nb[0].length(), nb[1].length() + 1); k++) {
								out.print(' ');
							}
							for (int k = 0; k < Math.max(nb[0].length(), nb[1].length() + 1); k++) {
								out.print('-');	
							}
							out.printLine();
							for (int k = 0; k < nb[1].length(); k++) {
								BigInteger interRes = nb1.multiply(new BigInteger(Character.toString(nb2.toString().charAt(nb[1].length()-1-k))));
								for (int k2 = 0; k2 < width - interRes.toString().length()-k; k2++) {
									out.print(' ');
								}
								out.print(interRes);
								for (int k2 = 0; k2 < nb[0].length(); k2++) {
									out.print(' ');
								}
								out.printLine();
							}
							for (int k = 0; k < width; k++) {
								out.print('-');
							}
							out.printLine();
							for (int k = 0; k < width - res.toString().length(); k++) {
								out.print(' ');
							}
							out.print(res);
							out.printLine();
						}
					}	
				}
				out.printLine();

			}
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
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

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object... objects) {
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
}

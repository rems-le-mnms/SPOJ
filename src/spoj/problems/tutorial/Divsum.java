/*
==========================================================
Author	: 		R�mi Kaeffer
Description : 	http://www.spoj.com/problems/DIVSUM/
==========================================================
STATUS : TLE
 */
package spoj.problems.tutorial;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Divsum {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> input = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		FasterScanner in = new FasterScanner(System.in);
		FasterOutput out = new FasterOutput(System.out);
		int n = in.nextInt();
		while(n-- > 0) {
			input.add(in.nextInt());
		}
		int interRes;
		for (int i = 0; i < input.size(); i++) {
			interRes = 1;
			for (int j = 2; j <= input.get(i) / 2; j++) {
				if(input.get(i) % j == 0) {
					interRes += j;
				}
			}
			res.add(interRes);
		}
		
		for (int i = 0; i < res.size(); i++) {
			out.printLine(res.get(i));
		}
		out.flush();
		out.close();
		
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
}

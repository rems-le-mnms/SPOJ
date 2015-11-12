/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/CPTTRN4/
==========================================================
STATUS : AC in 
 */
package spoj.problems.basics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Hs12mbr {
	public static void main(String[] args) throws Exception {
		FasterScanner in = new FasterScanner(System.in);
		FasterOutput out = new FasterOutput(System.out);
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			res.add(new Integer[4]);
			for (int j = 0; j < res.get(i).length; j++) {
				res.get(i)[j] = -100000;
			}
			int t = in.nextInt();
			for (int j = 0; j < t; j++) {
				String[] s = in.nextLine().split(" ");
				if(s[0].equals("p")) {
					int x = Integer.parseInt(s[1]);
					int y = Integer.parseInt(s[2]);
					if(res.get(i)[0] == -100000) {
						res.get(i)[0]=x;
						res.get(i)[1]=y;
						res.get(i)[2]=x;
						res.get(i)[3]=y;
					} else {
						res.get(i)[0]=Math.min(res.get(i)[0], x);
						res.get(i)[1]=Math.min(res.get(i)[1], y);
						res.get(i)[2]=Math.max(res.get(i)[2], x);
						res.get(i)[3]=Math.max(res.get(i)[3], y);
					}
				} else if (s[0].equals("c")) {
					int x = Integer.parseInt(s[1]);
					int y = Integer.parseInt(s[2]);
					int r = Integer.parseInt(s[3]);
					if(res.get(i)[0] == -100000) {
						res.get(i)[0]=x-r;
						res.get(i)[1]=y-r;
						res.get(i)[2]=x+r;
						res.get(i)[3]=y+r;
					} else {
						res.get(i)[0]=Math.min(res.get(i)[0], x-r);
						res.get(i)[1]=Math.min(res.get(i)[1], y-r);
						res.get(i)[2]=Math.max(res.get(i)[2], x+r);
						res.get(i)[3]=Math.max(res.get(i)[3], y+r);
					}
				} else {
					int x1 = Integer.parseInt(s[1]);
					int y1 = Integer.parseInt(s[2]);
					int x2 = Integer.parseInt(s[3]);
					int y2 = Integer.parseInt(s[4]);
					if(res.get(i)[0] == -100000) {
						res.get(i)[0]=Math.min(x1, x2);
						res.get(i)[1]=Math.min(y1, y2);
						res.get(i)[2]=Math.max(x1, x2);
						res.get(i)[3]=Math.max(y1, y2);
					} else {
						res.get(i)[0]=Math.min(res.get(i)[0], Math.min(x1, x2));
						res.get(i)[1]=Math.min(res.get(i)[1], Math.min(y1, y2));
						res.get(i)[2]=Math.max(res.get(i)[2], Math.max(x1, x2));
						res.get(i)[3]=Math.max(res.get(i)[3], Math.max(y1, y2));
					}
				}
			}
		}
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).length; j++) {
				if(j==0) {
					out.print(res.get(i)[j]);
				} else {
					out.print(" " + res.get(i)[j]);
				}
			}
			out.printLine();
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
		
		public char nextChar() {
			int c = read();
			return Character.toChars(c)[0];
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

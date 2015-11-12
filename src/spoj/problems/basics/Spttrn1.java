/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/SPTTRN1/
==========================================================
STATUS : NS 
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

public class Spttrn1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> input = new ArrayList<Integer>();
		ArrayList<Character[][]> res = new ArrayList<Character[][]>();
		FasterScanner in = new FasterScanner(System.in);
		FasterOutput out = new FasterOutput(System.out);
		int n = in.nextInt();
		// initialisation input
		while (n-- > 0) {
			input.add(in.nextInt());
		}
		// initialisation des matrices
		for (int i = 0; i < input.size(); i++) {
			res.add(new Character[input.get(i)][]);
			for (int j = 0; j < res.get(i).length; j++) {
				res.get(i)[j] = new Character[input.get(i)];
			}
		}
		// travail sur chacune des matrices
		for (int i = 0; i < res.size(); i++) {
			int posX = 0;
			int posY = 2;
			int direction = 1;
			boolean stop = true;
			for (int j = 0; j < input.get(i); j++) {
				res.get(i)[0][j] = '*';
				res.get(i)[input.get(i) - 1][j] = '*';
				res.get(i)[j][input.get(i) - 1] = '*';
				if (j == 1) {
					res.get(i)[j][0] = '.';
				} else {
					res.get(i)[j][0] = '*';
				}
			}
			/*
			 * while(stop) { res.get(i)[posX][posY] = '*'; if(direction == 1) {
			 * if(res.get(i)[posX+2][posY] == null) { posX++; } else {
			 * if(res.get(i)[posX][posY+1] == null) { direction = 2; } else {
			 * stop = false; } } } else if (direction == 2) {
			 * if(res.get(i)[posX][posY+2] == null) { posY++; } else {
			 * if(res.get(i)[posX-1][posY] == null) { direction = 3; } else {
			 * stop = false; } } } else if (direction == 3) { if(posX-1 > 0 &&
			 * res.get(i)[posX-2][posY] == null) { posX--; } else {
			 * if(res.get(i)[posX][posY-1] == null) { direction = 4; } else {
			 * stop = false; } } } else if (direction == 4) { if(posY-1 > 0 &&
			 * res.get(i)[posX][posY-2] == null) { posY--; } else {
			 * if(res.get(i)[posX+1][posY] == null) { direction = 1; } else {
			 * stop = false; } } } }
			 */
			/*
			 * for (int k = 0; k < input.get(i); k++) { for (int k2 = 0; k2 <
			 * input.get(i); k2++) { if(res.get(i)[k][k2] == null) {
			 * res.get(i)[k][k2] ='.'; } } }
			 */
		}
		// impression des matrices
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).length; j++) {
				for (int j2 = 0; j2 < res.get(i)[j].length; j2++) {
					out.print(res.get(i)[j][j2]);
				}
				out.printLine();
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

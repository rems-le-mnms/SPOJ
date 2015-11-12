/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/PCROSS2/
==========================================================
STATUS : AC in 0.33s
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

public class Pcross2 {
	public static void main(String[] args) throws Exception {
		FasterScanner in = new FasterScanner(System.in);
		FasterOutput out = new FasterOutput(System.out);
		ArrayList<ArrayList<ArrayList<Character>>> res = new ArrayList<ArrayList<ArrayList<Character>>>();
		char point = '.';
		char etoile ='*';
		int n = in.nextInt();
		int[][] config = new int[n][4];
		for (int i = 0; i < config.length; i++) {
			for (int j = 0; j < config[i].length; j++) {
				config [i][j] = in.nextInt();
			}
		}
		for (int k = 0; k < config.length; k++) {
			res.add(new ArrayList<ArrayList<Character>>());
			for (int i = 0; i < config[k][0]; i++) {
				res.get(k).add(new ArrayList<Character>());
				for (int j = 0; j < config[k][1]; j++) {
					res.get(k).get(i).add(point);
				}
			}
		}
		for (int i = 0; i < res.size(); i++) {
			int line = config[i][2];
			int cnt = 0;
			while(line-- > 0) {
				if(config[i][3] - 1 + cnt < config[i][1]) {
					res.get(i).get(config[i][2] - 1 - cnt).set(config[i][3] - 1 + cnt,etoile);
				}
				if(config[i][3] - 1 - cnt >= 0) {
					res.get(i).get(config[i][2] - 1 - cnt).set(config[i][3] - 1 - cnt,etoile);
				}
				cnt++;
			}
			cnt = 0;
			line = config[i][2];
			while(line ++ <= config[i][0]) {
				if(config[i][3] - 1 + cnt < config[i][1]) {
					res.get(i).get(config[i][2] - 1 + cnt).set(config[i][3] - 1 + cnt,etoile);
				}
				if(config[i][3] - 1 - cnt >= 0) {
					res.get(i).get(config[i][2] - 1 + cnt).set(config[i][3] - 1 - cnt,etoile);
				}
				cnt++;
			}
		}
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				for (int k = 0; k < res.get(i).get(j).size(); k++) {
					out.print(res.get(i).get(j).get(k));
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

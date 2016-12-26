/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/KPSUM/
==========================================================
STATUS : TLE
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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Kpsum {
	//static Map<Integer, Couple> a = new HashMap<Integer, Couple>();

	/*public static void main(String[] args) throws Exception {
		FasterScanner in = new FasterScanner();
		FasterOutput out = new FasterOutput();
		ArrayList<Integer> input = new ArrayList<Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		int n;
		while ((n = in.nextInt()) != 0) {
			input.add(n);
		}
		for (int i : input) {
			output.add(sum(1, i));
		}
		for (int i : output) {
			out.printLine(i);
		}
		out.flush();
		out.close();
		System.exit(0);

	}

	private static Couple memo_sum(int n) {
		if (a.containsKey(n)) {
			return a.get(n);
		} else {
			if (a.isEmpty()) {
				Couple b = new Couple(n, ;
				a.put(n, b);
				return n;
			} else {
				int low_limit = -1;
				Set key = a.keySet();
				Iterator it = key.iterator();
				while (it.hasNext()) {
					Object actualKey = it.next();
					if ((int) actualKey > low_limit && (int) actualKey < n) {
						low_limit = (int) actualKey;
					}
				}
				int b = sum(low_limit + 1, n);
				a.put(n, a.get(low_limit) + b);
				return a.get(low_limit) + b;
			}
		}
	}

	private static Couple sum(int a, int b, boolean bool) {
		int mod;
		boolean res_mod;
		if(bool) {
			mod = 0;
			res_mod=true;
		} else {
			mod=1;
			res_mod=false;
		}
		ArrayList<Character> chr = new ArrayList<Character>();
		String[] s = new String[b - a + 1];
		for (int i = 0; i < s.length; i++) {
			s[i] = Integer.toString(a);
			a++;
		}
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				chr.add(s[i].charAt(j));
			}
		}
		int res = Character.getNumericValue(chr.get(0));
		boolean modulo = true;
		for (int i = 1; i < chr.size(); i++) {
			if (i % 2 == mod) {
				res += Character.getNumericValue(chr.get(i));
				modulo = res_mod;
			} else {
				res -= Character.getNumericValue(chr.get(i));
				modulo = flip(res_mod);
			}
		}
		Couple res_couple = new Couple(res, modulo);
		return res_couple;

	}
	
	static class Couple {
		// a est la valeur de la map à une valeur clé
		int a;
		//b est la valeur du modulo enregistrée (0 ou 1)
		boolean b;
		
		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public boolean isB() {
			return b;
		}

		public void setB(boolean b) {
			this.b = b;
		}

		public Couple(int a, boolean b) {
			this.a = a;
			this.b = b;
		}
		
	}*/
	
	static boolean flip(boolean b) {
		if(b) {
			return false;
		} else {
			return true;
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

		public FasterOutput() {
			this(System.out);
		}

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

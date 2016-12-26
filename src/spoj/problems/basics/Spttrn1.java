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
import java.util.Map;
import java.util.Map.Entry;

public class Spttrn1 {
	
	private final static int LEFT_DIRECTION = 4;
	private final static int BOTTOM_DIRECTION = 3;
	private final static int RIGHT_DIRECTION = 2;
	private final static int TOP_DIRECTION = 1;
	
	public Spttrn1() {
		
	}

	public static void main(String[] args) throws Exception {
		Spttrn1 spttrn1 = new Spttrn1();
		ArrayList<Integer> input = new ArrayList<Integer>();
		ArrayList<Character[][]> res = new ArrayList<Character[][]>();
		FasterScanner in = new FasterScanner(System.in);
	
		int n = in.nextInt();
		// initialisation input
		while (n-- > 0) {
			input.add(in.nextInt());
		}
		// initialisation des matrices
		for (int i = 0; i < input.size(); i++) {
			int nb = input.get(i);
			res.add(new Character[nb][nb]);
			//Initialisation des matrices
			for(int j = 0; j < nb; j++) {
				for(int k = 0; k < nb; k++) {
					res.get(i)[j][k] = '*';
				}
			}
			
			SpiraleCursor sp = spttrn1.new SpiraleCursor(spttrn1.new MyEntry<Integer, Integer>(2, 1), RIGHT_DIRECTION, nb);
			
			boolean stop = true;
			do {
				
			} while(stop);
			
		}
		printResult(res);
	}
	
	class SpiraleCursor {
		
		private MyEntry<Integer, Integer> cursorPosition;
		private int direction;
		private int squareSize;
		private int countEnd = 0;
		
		public SpiraleCursor(MyEntry<Integer, Integer> cursorPosition, int direction, int squareSize) {
			this.cursorPosition = cursorPosition;
			this.direction = direction;
			this.squareSize = squareSize;
		}
		
		public boolean isEnd(boolean flag) {
			if(flag) {
				this.countEnd++;
			} else {
				this.countEnd = 0;
			}
			if(countEnd == 3) {
				return true;
			}
			return false;
		}
		
		//false si fin, true sinon
		public boolean moveCursor() {
			boolean flagEnd = false;
			switch(direction) {
				case BOTTOM_DIRECTION:			
					if(cursorPosition.key + 2 > squareSize) {
						if(cursorPosition.value - 2 < 0 ) {
							flagEnd = true;
						}
						direction = BOTTOM_DIRECTION;
					} else {
						cursorPosition.key++;
					}
				case TOP_DIRECTION:
					if(cursorPosition.key - 2 < 0) {
						if(cursorPosition.value + 2 > squareSize ) {
							flagEnd = true;
						}
						direction = BOTTOM_DIRECTION;
					} else {
						cursorPosition.key--;
					}
				case LEFT_DIRECTION:
					if(cursorPosition.value - 2 < 0) {
						if(cursorPosition.key - 2 < 0 ) {
							flagEnd = true;
						}
						direction = TOP_DIRECTION;
					} else {
						
					}
				default:
					if(cursorPosition.value + 2 > squareSize) {
						if(cursorPosition.key + 2 > squareSize ) {
							flagEnd = true;
						}
						direction = BOTTOM_DIRECTION;
					} else {
						
					}
			}
			if(isEnd(flagEnd)) {
				return false;
			}
			return true;
		}
		
	}
	
	public class MyEntry<K, V> implements Entry<K, V> {
	    private K key;
	    private V value;
	    public MyEntry(K key) {
	        this.key = key;
	    }
	    public MyEntry(K key, final V value) {
	        this.key = key;
	        this.value = value;
	    }
	    public K getKey() {
	        return key;
	    }
	    public V getValue() {
	        return value;
	    }
	    public V setValue(V value) {
	        V oldValue = this.value;
	        this.value = value;
	        return oldValue;
	    }
	}
	
	private static void printResult(ArrayList<Character[][]> toPrint) {
		FasterOutput out = new FasterOutput(System.out);
		for (int i = 0; i < toPrint.size(); i++) {
			Character[][] line = toPrint.get(i);
			int nb = line.length;
			for(int j = 0; j < nb; j++) {
				for(int k = 0; k < nb; k++) {
					out.print(line[j][k]);
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

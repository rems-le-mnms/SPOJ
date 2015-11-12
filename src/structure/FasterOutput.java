package structure;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class FasterOutput {
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


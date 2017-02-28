package ua.org.shaddy.bingrep.streams;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleBufferedOutputStream extends OutputStream {
	private static final int DEFAULT_BUFFER_SIZE = 8000;
	private final byte[] buffer;
	private final OutputStream os;
	private int pointer;

	public SimpleBufferedOutputStream(OutputStream os, int bufferSize) {
		this.os = os;
		this.buffer = new byte[bufferSize];
	}

	public SimpleBufferedOutputStream(OutputStream os) {
		this(os, DEFAULT_BUFFER_SIZE);
	}

	@Override
	public void write(int b) throws IOException {
		this.buffer[pointer++] = (byte) b;
		if (pointer >= this.buffer.length) {
			os.write(buffer);
			pointer = 0;
		}
	}

	@Override
	public void close() throws IOException {
		os.write(buffer, 0, pointer);
		os.close();
		super.close();
	}

}

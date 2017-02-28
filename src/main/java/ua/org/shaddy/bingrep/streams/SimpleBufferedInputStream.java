package ua.org.shaddy.bingrep.streams;

import java.io.IOException;
import java.io.InputStream;

public class SimpleBufferedInputStream extends InputStream{
	private static final int DEFAULT_BUFFER_SIZE = 16000;
	private final InputStream is;
	private final byte[] buffer;
	private int pointer = -1;
	private boolean eof = false;
	

	public SimpleBufferedInputStream(InputStream is) {
		this(is, DEFAULT_BUFFER_SIZE);
	}
	
	public SimpleBufferedInputStream(InputStream is, int bufferSize) {
		this.is = is;
		this.buffer = new byte[bufferSize]; 
	}
	
	private int fill() throws IOException{
		pointer = 0;
		int count = is.read(buffer);
		if (count == -1){
			eof  = true;
		}
		return count;
	}
	
	@Override
	public int read() throws IOException {
		if (eof){
			return -1;
		}
		if (pointer == -1 || pointer >= buffer.length){
			fill();
		}
		if (eof){
			return -1;
		}
		return buffer[pointer++] & 255;
	}

	@Override
	public void close() throws IOException {
		is.close();
		super.close();
	}
}

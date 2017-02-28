package ua.org.shaddy.bingrep.streams;

import java.io.IOException;
import java.io.InputStream;

public class SimpleBufferedInputStream extends InputStream{
	private static final int DEFAULT_BUFFER_SIZE = 16000;
	private final InputStream is;
	private final byte[] buffer;
	private int pointer = -1;
	private int dataSize = -1;
	private boolean eof = false;
	

	public SimpleBufferedInputStream(InputStream is) {
		this(is, DEFAULT_BUFFER_SIZE);
	}
	
	public SimpleBufferedInputStream(InputStream is, int bufferSize) {
		this.is = is;
		this.buffer = new byte[bufferSize]; 
	}
	
	private void fill() throws IOException{
		if (!eof){
			pointer = 0;
			dataSize = is.read(buffer);
			if (dataSize == -1){
				eof  = true;
			}
		}
	}
	
	@Override
	public int read() throws IOException {
		if (pointer == -1 || pointer >= dataSize){
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

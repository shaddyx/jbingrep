package ua.org.shaddy.bingrep;

import java.io.IOException;

import ua.org.shaddy.bingrep.streams.SimpleBufferedInputStream;
import ua.org.shaddy.bingrep.streams.SimpleBufferedOutputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		SimpleBufferedInputStream in = new SimpleBufferedInputStream(System.in);
		SimpleBufferedOutputStream out = new SimpleBufferedOutputStream(System.out);
		int counter = 0;
		while (true){
			counter ++;
			int b = in.read();
			if (b == -1){
				break;
			}
		//	out.write(b);
		}
		System.out.println(counter);
		in.close();
		//out.close();
	}
}

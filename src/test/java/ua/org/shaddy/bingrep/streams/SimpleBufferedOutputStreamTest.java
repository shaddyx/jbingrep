package ua.org.shaddy.bingrep.streams;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

import ua.org.shaddy.bingrep.streams.SimpleBufferedOutputStream;

public class SimpleBufferedOutputStreamTest {

	@Test
	public void testWrite() throws IOException {
		ByteArrayOutputStream barr = new ByteArrayOutputStream();
		OutputStream bos = new SimpleBufferedOutputStream(barr);
		for (int i = 0; i < 65535; i++) {
			bos.write(i % 255);
		}
		bos.close();
		byte[] arr = barr.toByteArray();
		assertEquals(65535, arr.length);
		for (int i = 0; i < 65535; i++) {
			assertEquals((byte) (i % 255), arr[i]);
		}
	}
	
	@Test
	public void testMultiSizeWrite() throws IOException {
		for(int j=1; j<1024; j++){
			ByteArrayOutputStream barr = new ByteArrayOutputStream();
			OutputStream bos = new SimpleBufferedOutputStream(barr, j);
			for (int i = 0; i < 65535; i++) {
				bos.write(i % 255);
			}
			bos.close();
			byte[] arr = barr.toByteArray();
			for (int i = 0; i < 65535; i++) {
				assertEquals((byte) (i % 255), arr[i]);
			}
	
		}		
	}

}

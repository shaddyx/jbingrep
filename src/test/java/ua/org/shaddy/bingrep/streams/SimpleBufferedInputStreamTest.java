package ua.org.shaddy.bingrep.streams;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

import ua.org.shaddy.bingrep.streams.SimpleBufferedInputStream;

public class SimpleBufferedInputStreamTest {

	ByteArrayInputStream createBis() {
		byte[] bytes = new byte[65535];
		for (int i = 0; i < 65535; i++) {
			bytes[i] = (byte) (i % 255);
		}
		return new ByteArrayInputStream(bytes);
	}

	@Test
	public void testRead() throws IOException {
		SimpleBufferedInputStream sbis = new SimpleBufferedInputStream(createBis());
		for (int i = 0; i < 65535; i++) {
			assertEquals((byte) (i % 255), (byte) sbis.read());
		}
	}
	
	@Test
	public void testEofRead() throws IOException {
		SimpleBufferedInputStream sbis = new SimpleBufferedInputStream(createBis());
		for (int i = 0; i < 65535 + 200; i++) {
			int res = sbis.read();
			if (i >= 65535){
				assertEquals("Error, must be eof, i:" + i, -1, res);
			} else {
				assertNotEquals("Error, must not be eof, i:" + i, -1, res);
			}
		}
	}
	
	@Test
	public void testReadMultiSizes() throws IOException {
		for (int j = 1; j<1024; j++){
			SimpleBufferedInputStream sbis = new SimpleBufferedInputStream(createBis(), j);
			for (int i = 0; i < 65535; i++) {
				assertEquals((byte) (i % 255), (byte) sbis.read());
			}
		}
	}
}

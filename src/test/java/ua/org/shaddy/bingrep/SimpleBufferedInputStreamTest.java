package ua.org.shaddy.bingrep;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class SimpleBufferedInputStreamTest {

	ByteArrayInputStream createBis() {
		byte[] bytes = new byte[65535];
		for (int i = 0; i < 65535; i++) {
			bytes[i] = (byte) (i % 255);
		}
		return new ByteArrayInputStream(bytes);
	}

	@Test
	public void testRead() {
		for (int j = 1; j<1024; j++){
			SimpleBufferedInputStream sbis = new SimpleBufferedInputStream(createBis(), j);
			for (int i = 0; i < 65535; i++) {
				try {
					assertEquals((byte) (i % 255), sbis.read());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}

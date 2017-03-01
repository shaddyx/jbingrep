package ua.org.shaddy.bingrep.grammar.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CommaSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.IntegerToken;

public class TokenizerTest {

	@Test
	public void getNextTokenTestNumber() {
		Tokenizer tokenizer = new Tokenizer("0x24");
		IntegerToken token = (IntegerToken) tokenizer.getNextToken();
		assertEquals(0x24, token.getValue());
		assertNull(tokenizer.getNextToken());
	}
	
	@Test
	public void getNextTokenTestNumbers() {
		Tokenizer tokenizer = new Tokenizer("0x24, 23");
		IntegerToken token = (IntegerToken) tokenizer.getNextToken();
		assertEquals(0x24, token.getValue());
		assertTrue(tokenizer.getNextToken() instanceof CommaSignToken);
		IntegerToken token1 = (IntegerToken) tokenizer.getNextToken();
		assertEquals(23, token1.getValue());
	}

}

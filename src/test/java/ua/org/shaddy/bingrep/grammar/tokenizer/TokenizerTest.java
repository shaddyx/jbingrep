package ua.org.shaddy.bingrep.grammar.tokenizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	
	@Test
	public void getTokensTest() {
		List<Token> tokensCreated = new Tokenizer("12,22,44,54").getTokens();
		System.out.println(tokensCreated);
		assertTrue(tokensCreated.get(0) instanceof IntegerToken);
		assertTrue(tokensCreated.get(2) instanceof IntegerToken);
		assertTrue(tokensCreated.get(4) instanceof IntegerToken);
		assertTrue(tokensCreated.get(6) instanceof IntegerToken);
		assertEquals(12, ((IntegerToken) tokensCreated.get(0)).getValue());
		assertEquals(22, ((IntegerToken) tokensCreated.get(2)).getValue());
		assertEquals(44, ((IntegerToken) tokensCreated.get(4)).getValue());
		assertEquals(54, ((IntegerToken) tokensCreated.get(6)).getValue());
	}
	
	

}

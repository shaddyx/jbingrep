package ua.org.shaddy.bingrep.grammar.rules;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ua.org.shaddy.bingrep.grammar.rules.impl.IntegerRule;
import ua.org.shaddy.bingrep.grammar.tokenizer.Token;
import ua.org.shaddy.bingrep.grammar.tokenizer.Tokenizer;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CommaSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.IntegerToken;

public class RulesAnalyzerTest {

	
	private List<Token> createTokens(String value){
		Tokenizer tokenizer = new Tokenizer(value);
		return tokenizer.getTokens();
	}
	
	@Test
	public void testAnalyze() {
		
		List<Token> tokensList = Arrays.asList(new Token[]{
			new IntegerToken(10),
			new CommaSignToken(),
			new IntegerToken(11),
			new CommaSignToken(),
			new IntegerToken(13),
			new CommaSignToken(),
			new IntegerToken(14),
			new CommaSignToken(),
			new IntegerToken(15)
		});
		List<GrepRule> rules = new RulesAnalyzer(tokensList).getRules();
		assertEquals(10, ((IntegerRule) rules.get(0)).getValue());
		assertEquals(11, ((IntegerRule) rules.get(1)).getValue());
		assertEquals(13, ((IntegerRule) rules.get(2)).getValue());
		assertEquals(14, ((IntegerRule) rules.get(3)).getValue());
	}
	
	@Test
	public void testAnalyzeTokens() {
		List<Token> tokensCreated = createTokens("12,22,44,54");
		List<GrepRule> rules = new RulesAnalyzer(tokensCreated).getRules();
		System.out.println(rules);
	}

}

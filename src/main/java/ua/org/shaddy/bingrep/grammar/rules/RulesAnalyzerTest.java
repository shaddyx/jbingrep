package ua.org.shaddy.bingrep.grammar.rules;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
		RulesAnalyzer a = new RulesAnalyzer(tokensList );
		while(true) {
			GrepRule rule = a.analyze();
			if (rule == null){
				break;
			}
			//System.out.println(rule);
		}
	}
	
	@Test
	public void testAnalyzeTokens() {
		List<Token> tokensCreated = createTokens("12,22,44,54");
		System.out.println("Tokens:" + tokensCreated);
		RulesAnalyzer a = new RulesAnalyzer(tokensCreated);
		while(true) {
			GrepRule rule = a.analyze();
			if (rule == null){
				break;
			}
			System.out.println(rule);
		}
	}

}

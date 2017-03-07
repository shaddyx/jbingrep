package ua.org.shaddy.bingrep.cmdline;

import java.util.List;

import ua.org.shaddy.bingrep.grammar.rules.RulesAnalyzer;
import ua.org.shaddy.bingrep.grammar.rules.impl.SequentionRule;
import ua.org.shaddy.bingrep.grammar.tokenizer.Token;
import ua.org.shaddy.bingrep.grammar.tokenizer.Tokenizer;

public class RulesUtil {

	public static List<Token> createTokens(String value){
		Tokenizer tokenizer = new Tokenizer(value);
		return tokenizer.getTokens();
	}

	public static SequentionRule createRules(String rules){
		return new RulesAnalyzer(createTokens(rules)).getSequention();	
	}
	
	
}

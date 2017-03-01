package ua.org.shaddy.bingrep.grammar.rules;

import java.util.LinkedList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.tokenizer.Token;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CloseBraceToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.OpenBraceToken;

public class RulesAnalyzer {
	private final TokenList tokens;

	public RulesAnalyzer(List<Token> tokens) {
		this.tokens = new TokenList(tokens);
	}

	public RulesAnalyzer(TokenList tokens) {
		this.tokens = tokens;
	}

	public TokenList getTokens() {
		return tokens;
	}

	private TokenList getInnerTokens(Class<? extends Token> start, Class<? extends Token> end) {
		List<Token> tokenList = new LinkedList<Token>();
		if (!start.isInstance(tokens.getNext())) {
			throw new RulesAnalyzerException("Error no start token found:" + start.getName());
		}
		tokens.poll();
		int startTokens = 1;
		while (!end.isInstance(tokens.getNext()) || startTokens != 1) {
			if (start.isInstance(tokens.getNext())) {
				startTokens++;
			} else if (end.isInstance(tokens.getNext())) {
				startTokens--;
			}
			tokenList.add(tokens.poll());
		}
		return new TokenList(tokenList);
	}

	private List<GrepRule> getInnerRules(Class<OpenBraceToken> class1, Class<CloseBraceToken> class2) {
		TokenList innerTokens = getInnerTokens(class1, class2);
		RulesAnalyzer rulesAnalyzer = new RulesAnalyzer(innerTokens);
		LinkedList<GrepRule> rules = new LinkedList<GrepRule>();
		GrepRule rule;
		while ((rule = rulesAnalyzer.analyze())!= null){
			rules.add(rule);
		}
		return rules;
	}

	public GrepRule analyze() {
		if (tokens.getNext() instanceof OpenBraceToken) {
			List<GrepRule> rulesList = getInnerRules(OpenBraceToken.class, CloseBraceToken.class);
		}
		return null;

	}

}

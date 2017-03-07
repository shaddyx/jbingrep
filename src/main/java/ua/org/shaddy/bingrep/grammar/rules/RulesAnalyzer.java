package ua.org.shaddy.bingrep.grammar.rules;

import java.util.List;

import ua.org.shaddy.bingrep.grammar.rules.impl.CommaGrepRule;
import ua.org.shaddy.bingrep.grammar.rules.impl.IntegerRule;
import ua.org.shaddy.bingrep.grammar.rules.impl.OrGrepRule;
import ua.org.shaddy.bingrep.grammar.rules.impl.SequentionRule;
import ua.org.shaddy.bingrep.grammar.tokenizer.Token;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CloseBraceToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CommaSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.IntegerToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.OpenBraceToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.OrSignToken;

public class RulesAnalyzer {
	private final TokenList tokens;

	public RulesAnalyzer(List<Token> tokens) {
		this.tokens = new TokenList(tokens);
	}

	public RulesAnalyzer(TokenList tokens) {
		this.tokens = tokens;
	}

	private IntegerRule getIntRule(Token token) {
		int intParam = ((IntegerToken) token).getValue();
		return new IntegerRule(intParam);
	}

	/**
	 * returns next rule
	 * 
	 * @return
	 */
	private GrepRule analyze() {
		GrepRule grepRule = null;
		if (tokens.getNext() instanceof OpenBraceToken) {
			grepRule = getSequention();
		} else if (tokens.getNext() instanceof IntegerToken) {
			grepRule = getIntRule(tokens.poll());
		} else if (tokens.getNext() instanceof CommaSignToken) {
			tokens.poll();
			grepRule = new CommaGrepRule();
		} else if (tokens.getNext() instanceof OrSignToken) {
			tokens.poll();
			grepRule = new OrGrepRule();
		}
		return grepRule;
	}

	public SequentionRule getSequention() {
		SequentionRule sequention = new SequentionRule();
		while (!(tokens.getNext() instanceof CloseBraceToken)){
			GrepRule grepRule = analyze();
			if ((grepRule instanceof OrGrepRule)){
				GrepRule prevRule = sequention.getPreviousRule();
				if (prevRule instanceof OrGrepRule){
					((OrGrepRule) prevRule).add(prevRule);
				} else {
					((OrGrepRule) grepRule).add(sequention.pollPreviousRule());
				}
			} else if (grepRule == null) {
				break;
			};
			sequention.add(grepRule);
		}
		sequention.clearCommas();
		return sequention;
	}

}

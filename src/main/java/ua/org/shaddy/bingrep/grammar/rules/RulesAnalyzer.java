package ua.org.shaddy.bingrep.grammar.rules;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.rules.impl.IntegerRule;
import ua.org.shaddy.bingrep.grammar.tokenizer.Token;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CloseBraceToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CommaSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.IntegerToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.OpenBraceToken;

public class RulesAnalyzer {
	private final TokenList tokens;

	public RulesAnalyzer(List<Token> tokens) {
		this.tokens = new TokenList(tokens);
	}

	public RulesAnalyzer(TokenList tokens) {
		this.tokens = tokens;
	}
	/**
	 * returns inner tokens from start brace to end
	 * @param start
	 * @param end
	 * @return
	 */
	
	private TokenList getInnerTokens(Class<? extends Token> start, Class<? extends Token> end) {
		List<Token> tokenList = new LinkedList<Token>();
		if (!start.isInstance(tokens.getNext())) {
			throw new RulesAnalyzerException("Error no start token found:" + start.getName());
		}
		tokens.poll();
		int startTokens = 1;
		while (!end.isInstance(tokens.getNext()) || startTokens != 1) {
			if (tokens.getNext() == null) {
				throw new RulesAnalyzerException("Missed end token:" + end.getName());
			}
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
		} else if (tokens.getNext() instanceof IntegerToken) {
			return getSequence(IntegerToken.class);
		} else if (tokens.getNext() instanceof CommaSignToken){
			tokens.poll();
			return analyze();
		}
		return null;
	}
	
	private GrepRule getSequence(Class<IntegerToken> clazz) {
		LinkedList<GrepRule> rules = new LinkedList<GrepRule>();
		//new IntegerRule(((IntegerToken) tokens.poll()).getValue());
		while (tokens.getNext() != null && clazz.isInstance(tokens.getNext()) || (tokens.getNext() instanceof CommaSignToken)){
			if (!(tokens.getNext() instanceof CommaSignToken)){
				Constructor<IntegerToken> constr = clazz.getConstructor(Object.class);
				IntegerRule integerRule = (IntegerRule) constr.newInstance((((IntegerToken) tokens.getNext()).getValue()));
				rules.add(constr.newInstance();
			}
			tokens.poll();
		}
		
	}

	public List<GrepRule> getRules(){
		GrepRule rule;
		LinkedList<GrepRule> rules = new LinkedList<GrepRule>();
		while ((rule = analyze()) != null){
			rules.add(rule);
		}
		return rules;
	}

}

package ua.org.shaddy.bingrep.grammar.rules;

import java.util.LinkedList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.tokenizer.Token;

public class TokenList {
	private final LinkedList<Token> tokens;

	public TokenList(List<Token> tokens) {
		this.tokens = new LinkedList<Token>(tokens);
	}
	
	public Token getNext(){
		return tokens.get(0);
	}
	
	public Token getSecond(){
		if (tokens.size() > 1){
			return tokens.get(1);
		} else {
			return null;
		}
	}
	
	public Token poll(){
		return tokens.poll();
	}
	
}

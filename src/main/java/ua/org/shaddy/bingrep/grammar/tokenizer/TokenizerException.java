package ua.org.shaddy.bingrep.grammar.tokenizer;

import ua.org.shaddy.bingrep.grammar.tokenizer.impl.TokenString;

public class TokenizerException extends RuntimeException {
	
	private TokenString tokenString;

	public TokenizerException(String error, TokenString tokenString) {
		super(error);
		this.tokenString = tokenString;
	}
	
}

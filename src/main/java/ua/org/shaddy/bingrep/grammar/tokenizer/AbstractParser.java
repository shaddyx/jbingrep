package ua.org.shaddy.bingrep.grammar.tokenizer;

import ua.org.shaddy.bingrep.grammar.tokenizer.impl.TokenString;

public abstract class AbstractParser {
	public abstract Object parse(TokenString tokenString);
}

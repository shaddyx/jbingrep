package ua.org.shaddy.bingrep.grammar.tokenizer;

import java.util.ArrayList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.tokenizer.impl.AndSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.CommaSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.IntegerToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.OrSignToken;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.TokenString;

public class Tokenizer {

	private final TokenString tokenString;
	private final IntegerParser intParser = new IntegerParser();
	private final BracesParser bracesParser = new BracesParser();

	//
	// Tokens ()|&,
	//
	public Tokenizer(String tokenString) {
		this.tokenString = new TokenString(tokenString);
	}

	private void skipSpaces() {
		while (!tokenString.isEof() && tokenString.getFirstSymbol() == ' ') {
			tokenString.popChar();
		}
	}

	public Token getNextToken() {
		skipSpaces();
		if (tokenString.isEof()) {
			return null;
		} else if (StrUtil.isDigit(tokenString.getFirstSymbol())) {
			return new IntegerToken(intParser.parse(tokenString));
		} else if (tokenString.checkSymbol('(')) {
			String bracesStrings = bracesParser.parse(tokenString);
			Tokenizer bracesTokenizer = new Tokenizer(bracesStrings);
			bracesTokenizer.getTokens();
		} else if (tokenString.checkSymbol(',')) {
			tokenString.popChar();
			return new CommaSignToken();
		} else if (tokenString.checkSymbol('|')) {
			tokenString.popChar();
			return new OrSignToken();
		} else if (tokenString.checkSymbol('&')) {
			tokenString.popChar();
			return new AndSignToken();
		}

		throw new TokenizerException(String.format("Error parsing token: %s", tokenString.toString()), tokenString);
	}

	public List<Token> getTokens() {
		List<Token> list = new ArrayList<>();
		while (getNextToken() != null) {
			list.add(getNextToken());
		}
		return list;
	}

}

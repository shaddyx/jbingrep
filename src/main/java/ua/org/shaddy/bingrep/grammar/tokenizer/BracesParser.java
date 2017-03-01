package ua.org.shaddy.bingrep.grammar.tokenizer;

import ua.org.shaddy.bingrep.constants.TokenConstants;
import ua.org.shaddy.bingrep.grammar.tokenizer.impl.TokenString;

public class BracesParser extends AbstractParser{

	@Override
	public String parse(TokenString tokenString) {
		TokenString currentTokenString = new TokenString(tokenString);
		int bracesOpened = 1;
		StringBuilder sb = new StringBuilder();
		char firstBrace = tokenString.popChar();
		if (firstBrace != TokenConstants.OPEN_BRACE){
			throw new TokenizerException(String.format("First brace is not open brace, expected: %s, found: %s", TokenConstants.OPEN_BRACE, firstBrace), currentTokenString);
		}
		try{
			while (tokenString.getFirstSymbol() != TokenConstants.CLOSE_BRACE && bracesOpened != 1){
				if (tokenString.getFirstSymbol() == TokenConstants.CLOSE_BRACE){
					bracesOpened--;
					char chr = tokenString.popChar();
					if (bracesOpened != 0){
						sb.append(chr);
					}
				} else if (tokenString.getFirstSymbol() == TokenConstants.OPEN_BRACE){
					bracesOpened ++;
					sb.append(tokenString.popChar());
				} else {
					sb.append(tokenString.popChar());
				}
			}
			
		} catch (IndexOutOfBoundsException e){
			throw new TokenizerException("No closing brace", currentTokenString);
		}
		return sb.toString();
	}

}

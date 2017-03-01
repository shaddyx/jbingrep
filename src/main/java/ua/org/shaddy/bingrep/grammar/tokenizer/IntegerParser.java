package ua.org.shaddy.bingrep.grammar.tokenizer;

import ua.org.shaddy.bingrep.grammar.tokenizer.impl.TokenString;

public class IntegerParser extends AbstractParser{

	@Override
	public Integer parse(TokenString tokenString) {
		StringBuilder intVal = new StringBuilder();
		while (!tokenString.isEof() && StrUtil.isDigit(tokenString.getFirstSymbol())){
			intVal.append(tokenString.popChar());
		}
		if (intVal.indexOf("x") != -1){
			return Integer.valueOf(intVal.toString().replace("x", ""), 16);
		}
		return Integer.valueOf(intVal.toString());
	}

}

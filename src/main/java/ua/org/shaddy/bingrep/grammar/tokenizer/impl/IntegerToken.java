package ua.org.shaddy.bingrep.grammar.tokenizer.impl;

import ua.org.shaddy.bingrep.grammar.rules.RulesAnalyzerException;
import ua.org.shaddy.bingrep.grammar.tokenizer.Token;

public class IntegerToken extends Token {
	private final int value;

	public IntegerToken(Object value) {
		if (value instanceof Integer){
			this.value = (int) value;	
		} else {
			throw new RulesAnalyzerException(String.format("Wrong integer token:", value));
		}
		
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "IntegerToken [value=" + value + "]";
	}

}

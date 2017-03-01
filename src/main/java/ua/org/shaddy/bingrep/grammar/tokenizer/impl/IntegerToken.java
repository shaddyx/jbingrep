package ua.org.shaddy.bingrep.grammar.tokenizer.impl;

import ua.org.shaddy.bingrep.grammar.tokenizer.Token;

public class IntegerToken extends Token {
	private final int value;

	public IntegerToken(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "IntegerToken [value=" + value + "]";
	}

}

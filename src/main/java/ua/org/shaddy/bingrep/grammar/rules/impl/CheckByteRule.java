package ua.org.shaddy.bingrep.grammar.rules.impl;

import ua.org.shaddy.bingrep.grammar.rules.GrepRule;

public class CheckByteRule extends GrepRule {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}

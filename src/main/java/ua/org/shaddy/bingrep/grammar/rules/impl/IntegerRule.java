package ua.org.shaddy.bingrep.grammar.rules.impl;

public class IntegerRule extends CheckValueGrepRule {

	public IntegerRule(int i) {
		super(i);
	}
	
	@Override
	public boolean check(int value) {
		return getValue().equals(value);
	}
}

package ua.org.shaddy.bingrep.grammar.rules.impl;

import ua.org.shaddy.bingrep.grammar.rules.GrepRule;

public class CheckValueGrepRule extends GrepRule{
	private Object value;
	
	public CheckValueGrepRule(Object value) {
		this.value = value;
	}
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "CheckValueGrepRule [value=" + value + ", toString()=" + super.toString() + "]";
	}
	
}

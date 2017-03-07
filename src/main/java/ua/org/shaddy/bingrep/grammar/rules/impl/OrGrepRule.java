package ua.org.shaddy.bingrep.grammar.rules.impl;

import java.util.LinkedList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.rules.GrepRule;

public class OrGrepRule extends GrepRule {
	private List<GrepRule> list = new LinkedList<GrepRule>();

	public void add(GrepRule sequenction) {
		list.add(sequenction);
	}

	@Override
	public String toString() {
		return "OrGrepRule [list=" + list + ", toString()=" + super.toString() + "]";
	}

}

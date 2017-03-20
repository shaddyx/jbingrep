package ua.org.shaddy.bingrep.grammar.rules.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ua.org.shaddy.bingrep.grammar.rules.GrepRule;

public class SequentionRule extends GrepRule {
	private List<GrepRule> list = new LinkedList<GrepRule>();

	public void add(GrepRule sequenction) {
		list.add(sequenction);
	}

	public void clearCommas() {
		list = list.stream().filter(item -> (!(item instanceof CommaGrepRule))).collect(Collectors.toList());
	}

	public GrepRule getPreviousRule() {
		return list.get(list.size() - 1);
	}
	
	public GrepRule pollPreviousRule() {
		GrepRule last = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return last;
	}
	
	public List<GrepRule> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "SequentionRule [list=" + list + ", toString()=" + super.toString() + "]";
	}

}

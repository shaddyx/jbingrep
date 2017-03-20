package ua.org.shaddy.bingrep.grammar.rules.impl;

import java.util.LinkedList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.rules.GrepRule;

public class SequenceRule extends GrepRule{
	private List<GrepRule> list = new LinkedList<GrepRule>();

	public void add(GrepRule sequenction) {
		sequenction.setParentRule(this);
		list.add(sequenction);
	}
	
	public List<GrepRule> getList() {
		return list;
	}
	/**
	 * returns next sibling for given element if contains
	 * @param grepRule
	 * @return
	 */
	public GrepRule getNext(GrepRule grepRule){
		int pos = list.indexOf(grepRule);
		
		if (pos == -1){
			return null;	
		}
		if (pos >= list.size() - 1){
			return null;
		}
		return list.get(pos + 1);
	}
		
	public void setList(List<GrepRule> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OrGrepRule [list=" + list + ", toString()=" + super.toString() + "]";
	}

}

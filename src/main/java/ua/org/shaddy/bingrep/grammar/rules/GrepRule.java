package ua.org.shaddy.bingrep.grammar.rules;

import ua.org.shaddy.bingrep.grammar.pointers.GrepPointersContainer;

public abstract class GrepRule {
	
	private GrepRule parentRule;

	
	public GrepRule getParentRule() {
		return parentRule;
	}

	public void setParentRule(GrepRule parentRule) {
		this.parentRule = parentRule;
	}
	
	public void processPointers(GrepPointersContainer container){
		//
		//	TODO: override this if necessary
		//
	}
	
	@Override
	public String toString() {
		return "GrepRule [toString()=" + super.toString() + "]";
	}
}

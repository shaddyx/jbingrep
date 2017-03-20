package ua.org.shaddy.bingrep.grammar.pointers;

import ua.org.shaddy.bingrep.grammar.rules.GrepRule;
import ua.org.shaddy.bingrep.grammar.rules.impl.OrGrepRule;
import ua.org.shaddy.bingrep.grammar.rules.impl.SequenceRule;

public class GrepPointer {
	private GrepRule grepRule;

	public GrepPointer(GrepRule grepRule) {
		this.grepRule = grepRule;
	}
	
	public GrepPointer() {
		
	}

	public GrepRule getGrepRule() {
		return grepRule;
	}

	public void setGrepRule(GrepRule grepRule) {
		this.grepRule = grepRule;
	}
	/**
	 * goes up on rules tree
	 * @return
	 */
	public boolean goUp(){
		GrepRule parent = grepRule.getParentRule();
		if (parent == null){
			return false;
		}
		grepRule = parent;
		return true;
	}
	
	public boolean goRight(){
		GrepRule parent = grepRule.getParentRule();
		if (parent instanceof SequenceRule){
			GrepRule tmpRule = ((SequenceRule) parent).getNext(grepRule);
			if (tmpRule != null){
				grepRule = tmpRule;
				return true;
			}
		}
		return false;
	}
	
}

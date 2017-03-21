package ua.org.shaddy.bingrep.grammar.rules.impl;

import ua.org.shaddy.bingrep.grammar.pointers.GrepPointer;
import ua.org.shaddy.bingrep.grammar.pointers.GrepPointersContainer;
import ua.org.shaddy.bingrep.grammar.rules.GrepRule;

public class OrGrepRule extends SequenceRule {
	
	@Override
	public void processPointers(GrepPointersContainer container, GrepPointer pointer) {
		for (GrepRule rule: getList()){
			container.add(new GrepPointer(rule));
		}	
	}

}

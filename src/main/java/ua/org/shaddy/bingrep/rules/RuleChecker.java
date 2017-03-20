package ua.org.shaddy.bingrep.rules;

import java.util.LinkedList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.pointers.GrepPointer;
import ua.org.shaddy.bingrep.grammar.pointers.GrepPointersContainer;
import ua.org.shaddy.bingrep.grammar.rules.GrepRule;
import ua.org.shaddy.bingrep.grammar.rules.impl.CheckValueGrepRule;

public class RuleChecker {
	
	long pos = 0;
	private final GrepPointersContainer pointersContainer = new GrepPointersContainer();
	
	public RuleChecker(GrepRule rules) {
		pointersContainer.add(new GrepPointer(rules));
	}

	public void check(int b) {
		for (GrepPointer pointer: pointersContainer){
			pointer.getGrepRule().processPointers(pointersContainer);
		}
		
		processPointers(pointersContainer);
		check(pointersContainer, b);
		
		
		
	}

	private void check(GrepPointersContainer pointersContainer2, int b) {
		List<GrepRule> toRemove = new LinkedList<GrepRule>();
		for (GrepPointer pointer: pointersContainer){
			if (pointer.getGrepRule() instanceof CheckValueGrepRule){
				if (!((CheckValueGrepRule) pointer.getGrepRule()).check(b)){
					toRemove.add(pointer.getGrepRule());
				}
			}
		}
		pointersContainer.removeAll(toRemove);
	}

	private void processPointers(GrepPointersContainer pointersContainer2) {
		for (GrepPointer pointer: pointersContainer){
			pointer.getGrepRule().processPointers(pointersContainer);
		}
		
	}
}

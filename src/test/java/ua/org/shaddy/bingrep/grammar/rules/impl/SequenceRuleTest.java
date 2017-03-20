package ua.org.shaddy.bingrep.grammar.rules.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SequenceRuleTest {

	@Test
	public void testCheck() {
		SequenceRule seqRule = new SequenceRule();
		//seqRule.check(value, pointers)
		
	}

	@Test
	public void testAdd() {
		SequenceRule seqRule = new SequenceRule();
		IntegerRule intRule = new IntegerRule(10);
		seqRule.add(intRule);
		assertEquals(1, seqRule.getList().size());
	}

	@Test
	public void testGetNext() {
		SequenceRule seqRule = new SequenceRule();
		IntegerRule a;
		IntegerRule b;
		IntegerRule c;
		IntegerRule d;
		seqRule.add(a = new IntegerRule(10));
		seqRule.add(b = new IntegerRule(20));
		seqRule.add(c = new IntegerRule(30));
		seqRule.add(d = new IntegerRule(40));
		assertEquals(b, seqRule.getNext(a));
		assertEquals(c, seqRule.getNext(b));
		assertEquals(d, seqRule.getNext(c));
		assertEquals(null, seqRule.getNext(d));
	}

}

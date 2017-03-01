package ua.org.shaddy.bingrep.grammar.tokenizer.impl;

import java.util.ArrayList;
import java.util.List;

import ua.org.shaddy.bingrep.grammar.tokenizer.Token;

public class TokenNode extends Token{
	private List<Token> children = new ArrayList<>();

	public List<Token> getChildren() {
		return new ArrayList<Token>(children);
	}
	
	public void addToken(Token token){
		children.add(token);
	}
	
	@Override
	public String toString() {
		return "TokenNode [children=" + children + ", toString()=" + super.toString() + "]";
	}
	
}

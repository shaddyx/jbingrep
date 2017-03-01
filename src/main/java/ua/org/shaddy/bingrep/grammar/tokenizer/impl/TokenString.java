package ua.org.shaddy.bingrep.grammar.tokenizer.impl;

public class TokenString {
	private String str;
	public TokenString(String str){
		this.str = str;
	}
	public TokenString(TokenString str){
		this.str = str.getStr();
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public char getFirstSymbol(){
		return str.charAt(0);
	}
	
	public boolean checkSymbol(char s){
		return str.charAt(0) == s;
	}
	
	public boolean checkSymbol(String s){
		if (s.length() != 1){
			return false;
		}
		return str.charAt(0) == s.charAt(0);
	}
	
	public char popChar(){
		char val = str.charAt(0);
		str = str.substring(1);
		return val;
	}
	public boolean isEof() {
		return str.length() == 0;
	}
	@Override
	public String toString() {
		return "TokenString [str=" + str + "]";
	}
	
}

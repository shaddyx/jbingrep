package ua.org.shaddy.bingrep.grammar.tokenizer;

class StrUtil {

	public static boolean isDigit(char s) {
		try{
			if (s == 'x'){
				return true;
			}
			Integer.parseInt(String.valueOf(s));
			return true;
		} catch (NumberFormatException  e) {
			return false;
		}
	}
	
	

}

package Morpheme;

public class test {
	
	public static String[] brackets = { "()", "{}", "[]" };


	public static void main(String[] args){
		
		valid_braces("(()())")
		
		
	}
	
	
	public static boolean valid_braces(String braces){
		
	}
	
	public static boolean isForwardBracket(String s){
		
		boolean torf = false;
		
		if (s.equals("(") || s.equals("{") || s.equals("[")){
			torf = true;
		}
		
		return torf;
	}
	
	public static String getReverse(String s){
		
		String reverse = "";
		
		for (int h = 0; h < brackets.length; h++){
			if (s.equals(brackets[h].substring(0, 1))){
				reverse = brackets[h].substring(1, 2);
			}
		}
		
		return reverse;
	}
	
}

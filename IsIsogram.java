package pcprac;

import java.util.HashSet;

public class IsIsogram {
	
	public static boolean isogram(String s) {
		HashSet<Character> set= new HashSet<>();
		
		for(int i=0; i<s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				return false;
			}else {
				set.add(s.charAt(i));
				
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

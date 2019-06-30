package pcprac;

import java.util.ArrayList;
import java.util.HashMap;

public class StringAnagram {
	
	public static ArrayList<Integer> stringAnagram(String s, String sub){
		ArrayList<Integer> indices= new ArrayList<>();
		
		HashMap<Character, Integer> submap= new HashMap<>();
		HashMap<Character, Integer> strmap= new HashMap<>();
		
		for(int i=0; i<sub.length(); i++) {
			if(submap.containsKey(sub.charAt(i))) {
				submap.put(sub.charAt(i), submap.get(sub.charAt(i))+1);
			}else {
				submap.put(sub.charAt(i), 1);
			}
		}
		int sublen= sub.length();
		
		int i=0; int j=0;
		
		while(j<s.length() && i<s.length()) {
			
			
			if(strmap.containsKey(s.charAt(j))) {
				strmap.put(s.charAt(j), strmap.get(s.charAt(j))+1);
			}else {
				strmap.put(s.charAt(j), 1);
			
			}
			
			if(strmap.equals(submap)) {
				indices.add(i);
			}
			
			j++;
			if(j-i==sublen) {
				strmap.put(s.charAt(i), strmap.get(s.charAt(i))-1);
				if(strmap.get(s.charAt(i))==0) {
					strmap.remove(s.charAt(i));
				}
				
				i++;
				
			}
			
			
			
		}
		
		return indices;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans= stringAnagram("badccdabbadaccabcdabbcda", "abbcda");
		System.out.println(ans);

	}

}

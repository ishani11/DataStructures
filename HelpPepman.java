package pcprac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HelpPepman {
	
	public static String oddEven(String s) {
		int x=0;
		int y=0;
		
		HashMap<Character, Integer> map= new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char ch= s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue()%2==0 && entry.getKey()%2==0) {
				x++;
			}
			
			if(entry.getValue()%2==1 && entry.getKey()%2==1) {
				y++;
			}
			
		}
		
		if((x+y)%2==0) {
			return "EVEN";
		}else {
			return "ODD";
		}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		sc.nexTl
		System.out.println(oddEven("pepman"));
	}

}

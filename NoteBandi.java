package pcprac;

import java.util.ArrayList;
import java.util.HashMap;

public class NoteBandi {
	
	public static void removeString(String str, String m, String n) {
		HashMap<String, ArrayList<Integer>> map= new HashMap<>();
		ArrayList<Integer> mlist= new ArrayList<>();
		ArrayList<Integer> nlist= new ArrayList<>();
		
		map.put(m, mlist);
		map.put(n, nlist);
		
		int indexm=str.indexOf(m);
		int indexn= str.indexOf(n);
		
		while(indexm>=0) {
			mlist.add(indexm);
			indexm=str.indexOf(m, indexm+1);
		}
		
		while(indexn>=0) {
			nlist.add(indexn);
			indexn=str.indexOf(n, indexn+1);
		}
		
		str=str.replace(m, "");
		str=str.replace(n, "");
		
		System.out.println(str);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeString("abbbccab", "ab","bcc");

	}

}

package pcprac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DirectoryQuestion {
	
	public static ArrayList<ArrayList<String>> directory(String[] paths){
		
		TreeMap<String, ArrayList<String>> map= new TreeMap<>();
		for(int i=0; i<paths.length; i++) {
			String[] dir=paths[i].split(" ");
			String rootpath= dir[0];
			
			for(int j=1; j<dir.length; j++) {
				int idx=dir[j].indexOf('(');
				String content= dir[j].substring(idx+1, dir[j].length()-1);
				String additionalPath= dir[j].substring(0, idx);
				if(map.containsKey(content)) {
					ArrayList<String> list= map.get(content);
					list.add(rootpath+"/"+additionalPath);
					
					map.put(content, list);
				}else {
					ArrayList<String> list= new ArrayList<>();
					list.add(rootpath+"/"+additionalPath);
					map.put(content, list);
				}
			}
		}
		
		ArrayList<ArrayList<String>> ans= new ArrayList<ArrayList<String>>();
		for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
			ans.add(entry.getValue());
		}
		
		
		return ans;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr= {"root/a 1.txt(abcd) 2.txt(efgh)",
				"root/c 3.txt(abcd)",
				"root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)"};
		
		System.out.println(directory(arr));

	}

}

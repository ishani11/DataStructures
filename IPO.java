package pcprac;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
	
	public static class Project{
		int name;
		int cap;
		int profit;
		
		public Project(int name, int profit, int cap) {
			this.name=name;
			this.profit=profit;
			this.cap=cap;
		}
		
	}
	
	public static class ProjectProfitComparator implements Comparator<Project>{
		public int compare(Project one, Project two) {
			return one.profit-two.profit;
		}
	}
	
	public static class ProjectCapitalComparator implements Comparator<Project>{
		public int compare(Project one, Project two) {
			return one.cap-two.cap;
		}
	}
	
	
	public static int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
	 	 //write your code here
		
		Project[] projects= new Project[profits.length];
		for(int i=0; i<profits.length; i++) {
			Project project= new Project(i, profits[i], capital[i]);
			projects[i]=project;
		}
		
		Arrays.sort(projects, new ProjectCapitalComparator());
		
		PriorityQueue<Project> pq= new PriorityQueue<>(profits.length,Collections.reverseOrder(new ProjectProfitComparator()));
		int i=0;
		
		for(i=0; i<projects.length; i++) {
			if(projects[i].cap<=W) {
				pq.add(projects[i]);
			}else {
				break;
			}
			
			
		}
		
		
		while(pq.size()>0 && k-->0) {
			Project ptd=pq.poll();
			
			W+=ptd.profit;
			//System.out.println(W);
			for(; i<projects.length; i++) {
				if(projects[i].cap<=W) {
					pq.add(projects[i]);
				}else {
					break;
				}
			}
			
			
			
		}
		
		
		return W;
		
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] names= "abcdef".toCharArray();
		int[] caps= {80, 90, 150, 200, 290, 350};
		int[] profs= {40, 50, 60, 70, 50, 300};
		System.out.println(findMaximizedCapital(4, 100, profs, caps));

	}

}

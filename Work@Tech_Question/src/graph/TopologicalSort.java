package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		
	}
	
	public int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
		int[] topo = new int[N];
		int[] indegree = new int[N];
		
		for(int i=0;i<N;i++) {
			for(int it:adj.get(i)) {
				indegree[it]++;
			}
				
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			if(indegree[i]==0)
				q.add(i);
		}
		int idx = 0;
		
		while(!q.isEmpty()) {
			Integer node = q.remove();
			topo[idx++] = node;
			
			for(Integer it:adj.get(node)) {
				indegree[it]--;
				if(indegree[it]==0)
					q.add(it);
			}
			
		}
		
		return topo;
		
		
	}
	
}

package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	class Pair{
		int v;
		int weight;
		
		public Pair(int v,int weight) {
			this.v = v;
			this.weight = weight;
		}
		
		int getV() {
			return v;
		     }
			
			int getWeight() {
				return weight;
			}
		
		public int compare(Pair p1,Pair p2) {
			if(p1.weight<p2.weight)
				return -1;
			if(p1.weight>p2.weight)
				return 1;
			
			return 0;
		}
		
		
	}
	
	
	void ShortestPath(int s,ArrayList<ArrayList<Pair>> adj,int N) {
		
		int[] dist = new int[N];
		
		for(int i=0;i<N;i++)
			dist[i] = 100000000;
		
		dist[s] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(s,0));
		
		while(!pq.isEmpty()) {
			
			Pair rp = pq.remove();
			
			for(Pair it:adj.get(rp.getV())) {
				if(dist[rp.getV()]+it.weight<dist[it.getV()]) {
					dist[it.getV()] = dist[rp.getV()]+ it.getWeight();
					pq.add(new Pair(it.getV(),dist[it.getWeight()]));
				}
			}
		}
		
		for(int i=0;i<N;i++)
			System.out.println(dist[i]);
		
	}
}

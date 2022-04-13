package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prims {
	
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
	    
	    int compare(Pair p1,Pair p2) {
	    	if(p1.weight<p2.weight)
	    		return -1;
	    	if(p1.weight>p2.weight)
	    		return 1;
	    	
	    	return 0;
	    }
	}
	
	public void primsAlgo(ArrayList<ArrayList<Pair>> adj,int N) {
		boolean[] mstSet = new boolean[N];
		int[] parent = new int[N];
		int[] key = new int[N];
		
		for(int i=0;i<N;i++) {
			key[i] = 100000000;
			mstSet[i] = false;
			parent[i] = -1;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		key[0] = 0;
		pq.add(new Pair(0,key[0]));
		
		for(int i=0;i<N-1;i++) {
			int u = pq.remove().getV();
			mstSet[u] = true;
			
			for(Pair it:adj.get(u)) {
				if(mstSet[it.getV()]==false && it.getWeight()<key[it.getV()]) {
					parent[it.getV()] = u;
					key[it.getV()] = it.getWeight();
					pq.add(new Pair(it.getV(),it.getWeight()));
				}
			}
		}
	}
	
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	
	class PrimsPair implements Comparable<PrimsPair>{
		int vname;
		int avname;
		int cost;
		
		public PrimsPair(int vname,int avname,int cost) {
			this.vname = vname;
			this.avname = avname;
			this.cost = cost;
		}
		
		public String toString() {
			return vname + " via " +avname+" @ "+cost;
		}
		
		public int compareTo(PrimsPair o) {
			return this.cost - o.cost;
		}
		
	}
	
	public void prims() {
		boolean[] visited = new boolean[map.size()+1];
		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();
		
		PrimsPair sp = new PrimsPair(1,0,0);
		pq.add(sp);
		
		while(!pq.isEmpty()) {
			PrimsPair rp = pq.remove();
			
			if(visited[rp.vname])
				continue;
			
			visited[rp.vname] = true;
			
			if(rp.avname!=0) {
				System.out.println(rp);
			}
			
			for(int nbr:map.get(rp.vname).keySet()) {
				if(!visited[nbr]) {
					pq.add(new PrimsPair(nbr, rp.vname, map.get(rp.vname).get(nbr));
				}
			}
		}
	}

}

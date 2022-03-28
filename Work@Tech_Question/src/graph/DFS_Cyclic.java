package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFS_Cyclic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> dfs(ArrayList<Integer>[] adjList){
		Set<Integer> visited = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		
		dfs(0,adjList,visited,res);
		return res;
		
	}
	
	public void dfs(int root,ArrayList<Integer>[] adjList,Set<Integer> visited,ArrayList<Integer> res) {
		visited.add(root);
		res.add(root);
		
		for(int i=0;i<adjList[root].size();i++) {
			int nbr = adjList[root].get(i);
			if(!visited.contains(nbr)) {
				dfs(nbr,adjList,visited,res);
			}
		}
	}

}

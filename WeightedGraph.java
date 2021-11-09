

import java.util.*;

public abstract class WeightedGraph{
	protected int numberOfVertices;
	protected int numberOfEdges;
	protected int[][] adj;
	public static final int INFINITY = Integer.MAX_VALUE / 2;
	
	public WeightedGraph(int numberOfVertices){
		this.numberOfVertices = numberOfVertices;
		adj = new int[numberOfVertices][numberOfVertices];

		for(int i = 0; i < adj.length; i++){
			for(int j = 0; j < adj.length; j++){
				adj[i][j] = INFINITY;
			}
		}
	}

	public abstract void addEdge(int v, int w, int weighted);

	public List<Integer> getAdjacents(int v){
		List<Integer> result = new ArrayList<Integer>();

		for(int i = 0; i < adj.length; i++){
			if(adj[v][i] != INFINITY){
				result.add(i);
			}
		}
		return result;
	}
	
	public List<Integer> getPredecessors(int v){
		List<Integer> result = new ArrayList<Integer>();

		for(int i = 0; i < adj.length; i++){
			if(adj[i][v] != INFINITY){
				result.add(i);
			}
		}
		return result;
	}
	
	public List<Integer> getVertices() {
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0; i < getNumberOfVertices(); i++) {
			result.add(i);
		}
		
		return result;
	}

	public int getWeighted(int v, int w ){
		return adj[v][w];
	}

	public int getNumberOfVertices(){
		return this.numberOfVertices;
	}

	public int getNumberOfEdges(){
		return this.numberOfEdges;	
	}
	
	public boolean hasEdge(int v, int w) {
		return getWeighted(v, w) != INFINITY;
	}
}
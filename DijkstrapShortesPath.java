
import java.util.*;

public class DijkstrapShortesPath{
	private int[] edgeTo;
	private int[] distTo;
	private int source;
	private List<String> patht;
	int sequence = 0;

	public DijkstrapShortesPath(WeightedGraph graph, int source){
		this.source = source;
		edgeTo = new int[graph.getNumberOfVertices()];
		distTo = new int[graph.getNumberOfVertices()];

		for(int i = 0; i < distTo.length; i++){
			distTo[i] = WeightedGraph.INFINITY;
			edgeTo[i] = 0;
		}
		edgeTo[source] = 0;
		distTo[source] = 0;
		
		execute(graph, source);
	}

	private void execute(WeightedGraph graph, int s){
		List<Integer> open = graph.getVertices();
		List<Integer> closed = new ArrayList<Integer>();

		while(!open.isEmpty()){
			Collections.sort(open, new Comparator<Integer>(){
				public int compare(Integer v1, Integer v2){
					return distTo[v1] - distTo[v2];
				}
			});

			Integer v = open.get(0);
			closed.add(v);
			open.remove(v);
			
			System.out.println(sequence);
			
			System.out.println("Open: " + open);
			System.out.println("Closed: " + closed);
			
			sequence++;
			
			List<Integer> adj = graph.getAdjacents(v);
			for(Integer w : adj){
				if(!closed.contains(w)){
					if(distTo[v] + graph.getWeighted(v, w) < distTo[w]){
						distTo[w] = distTo[v] + graph.getWeighted(v, w);
						edgeTo[w] = v;
					}
				}
			}
		}
	}

	public Collection<Integer> pathTo(int v){
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != source; x = edgeTo[x] ){
			path.push(x);
		}

		path.push(source);

		return path;
	}
	


	public int getDistanceTo(int v){
		return distTo[v];
	}

	public int getEdgeeTo(int v){
		return edgeTo[v];
	}

	public int[] getDistTo(){
		return distTo;
	}

	public int[] getEdgeTo(){
		return edgeTo;
	}
}
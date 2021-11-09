

import java.util.*;

public class TesteDijkstrapShortestPath{
	public static void main(String []args){
		WeightedGraph graph = new WeightedUndirectedGraphAsMatrix(7);
		
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 3;
		int e = 4;
		int f = 5;
		int g = 6;
		
		graph.addEdge(a, b, 7);
		graph.addEdge(a, d, 5);
		
		graph.addEdge(b, c, 8);
		graph.addEdge(b, d, 9);
		graph.addEdge(b, e, 7);
		
		graph.addEdge(c, e, 5);
		
		graph.addEdge(d, e, 15);
		graph.addEdge(d, f, 6);
		
		graph.addEdge(e, f, 8);
		graph.addEdge(e, g, 9);
		
		graph.addEdge(f, g, 11);

		int source = a;
		DijkstrapShortesPath dijkstrap = new DijkstrapShortesPath(graph, source);
		
		
		List<Integer> vertices = graph.getVertices();
		for(Integer v : vertices){

				Collection<Integer> path = dijkstrap.pathTo(v);

				System.out.println("Caminho de " + source + " para " + v + " :" + path);
				System.out.println("Distancia é: " + dijkstrap.getDistanceTo(v));
		}
		
		//System.out.println(Arrays.toString(dijkstrap.getEdgeTo()));
		//System.out.println(Arrays.toString(dijkstrap.getDistTo()));
	}
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedUndirectedGraphAsMatrix extends WeightedGraph {

	public WeightedUndirectedGraphAsMatrix(int numberOfVertices) {
		super(numberOfVertices);
	}

	public WeightedUndirectedGraphAsMatrix(WeightedGraph graph) {
		super(graph.getNumberOfVertices());

		for (int i = 0; i < getNumberOfVertices(); i++) {
			for (int j = 0; j < getNumberOfVertices(); j++) {
				adj[i][j] = graph.adj[i][j];
			}
		}

		numberOfEdges = graph.getNumberOfEdges();
	}

	public void addEdge(int v, int w, int weighted) {
		adj[v][w] = weighted;
		adj[w][v] = weighted;

		numberOfEdges++;
	}

	public void removeEdge(int v, int w) {
		adj[v][w] = WeightedGraph.INFINITY;
		adj[w][v] = WeightedGraph.INFINITY;

		numberOfEdges--;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Set<String> edges = new HashSet<String>();

		for (Integer v : getVertices()) {
			for (Integer w : getAdjacents(v)) {
				if (v != w) {
					int min = Math.min(v, w);
					int max = Math.max(v, w);

					edges.add(min + "," + max + "," + getWeighted(v, w));
				}
			}
		}

		List<String> result = new ArrayList<String>(edges);
		Collections.sort(result);

		for (String edge : result) {
			builder.append(edge).append("\n");
		}

		return builder.toString();
	}
}

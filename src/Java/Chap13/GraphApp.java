import java.util.List;
import java.util.ArrayList;

class Graph {
    private int vertexCount;    // vCount
    private int[][] graph;      // adj

    // returns the cardinality of vertex set
    public int getVertexCount() {
        return vertexCount;
    }

    // returns the graph as in matrix form
    public int[][] getGraph() {
        return graph;
    }

    // creates a graph with weight of 0
    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        graph = new int[vertexCount][vertexCount];
        for (int u = 0; u < vertexCount; u++)
            for (int v = 0; v < vertexCount; v++)
                graph[u][v] = 0;
    }

    // adds the weight to the edge or can say creates a edge with weight 1
    public void addEdge(int u, int v) {
        graph[u][v] = 1;
    }

    // remove the the given edge
    public void removeEdge(int u, int v) {
        graph[u][v] = 0;
    }

    // checks if there exists a edge B/W u and v
    public boolean hasEdge(int u, int v) {
        return (graph[u][v] != 0);
    }

    // returns all the neighbours of the given vertex by traversing
    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int v = 0; v < vertexCount; v++) {
            if (hasEdge(vertex, v)) {
                edges.add(v);
            }
        }
        return edges;
    }

    public void printGraph() {
        for (int u = 0; u < vertexCount; u++) {
            List<Integer> edges = neighbours(u);
            System.out.println("\n" + u + ": ");
            for (Integer v : edges) {
                System.out.print(v + " ");
            }
        }
    }
}
public class GraphApp {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0,1);
		graph.addEdge(0,3);
		graph.addEdge(1,0);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,1);
		graph.addEdge(2,3);
		graph.addEdge(3,0);
		graph.addEdge(3,2);
		graph.addEdge(4,1);
		graph.addEdge(4,2);
		graph.printGraph();
	}
}

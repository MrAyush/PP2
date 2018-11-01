import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
        graph[v][u] = 1;
    }

    // remove the the given edge
    public void removeEdge(int u, int v) {
        graph[u][v] = 0;
    }

    // checks if there exists a edge B/W u and v
    public boolean hasEdge(int u, int v) {
        return (graph[u][v] == 1);
    }

    // returns all the neighbours of the given vertex by traversing
    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<>();
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
        System.out.println();
    }

    public void dfs() {
        boolean[] isVisited = new boolean[vertexCount];
        Arrays.fill(isVisited, false);
        for (int v = 0; v < vertexCount; v++)
            dfs(v, isVisited);
    }

    private void dfs(int v, boolean[] isVisited) {
        for (int i = 0; i < vertexCount; i++) {
            if (hasEdge(v, i) && !isVisited[i]) {
                System.out.println("Found: " + i);
                isVisited[i] = true;
                dfs(i, isVisited);
            }
        }
    }

    public void bfs() {
        boolean isVisited[] = new boolean[vertexCount];
        Arrays.fill(isVisited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        isVisited[0] = true;
        System.out.println("Found : " + 0);
        while (!q.isEmpty()) {
            int v1 = q.poll();
            List<Integer> connection = neighbours(v1);
            for (Integer v2 : connection) {
                if (!isVisited[v2]) {
                    q.add(v2);
                    isVisited[v2] = true;
                    System.out.println("Found : " + v2);
                }
            }
        }
    }
}

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        System.out.println("Graph: ");
        graph.printGraph();
        System.out.println("Graph traversing (BFS): ");
        graph.bfs();
        System.out.println("Graph traversing (DFS): ");
        graph.dfs();
    }
}

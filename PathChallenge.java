import java.io.IOException;
import java.lang.System;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PathChallenge {
    private static boolean visited[];
    private static Graph graph;

    public static List findPath(int w, int goal, List<Integer> path) {
        visited[w] = true;
        path.add(w);
        if (w == goal) {
            return path;
        }
        for (int i = 1; i <= graph.getVertices(); i++) {
            if (graph.hasPathBetween(w,i)) {
                if (!visited[i]) {
                    List returnPath = findPath(i, goal, path);
                    if (returnPath.size() > 0) {
                        return returnPath;
                    }
                }
            }
        }
        return new LinkedList();
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GraphInputHandler inputHandler = new GraphInputHandler();

        try {
            System.out.print("Start node :: ");
            Integer start = Integer.parseInt(reader.readLine());

            System.out.print("End node :: ");
            Integer end = Integer.parseInt(reader.readLine());

            graph = inputHandler.readInput(reader);

            visited = new boolean[graph.getVertices()+1];
            for (int i = 0; i < graph.getVertices(); ++i) {
                visited[i] = false;
            }
            List path = findPath(start, end, new LinkedList());
            ListIterator<Integer> listIterator = path.listIterator();
            System.out.println("Start path");
	        while (listIterator.hasNext()) {
	            System.out.println(listIterator.next());
	        }
            System.out.println("End path");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Graph {
    private boolean graph[][];
    private int vertices;
    private int edges;

    Graph(int vertices) {
        this.vertices = vertices;
        graph = new boolean[vertices+1][vertices+1];
    }

    public boolean hasPathBetween(int u, int v) {
        return this.graph[u][v];
    }

    public void addEdge(int u, int v) {
        this.graph[u][v] = true;
    }

    public int getVertices() {
        return this.vertices;
    }

    public int getEdges() {
        return this.edges;
    }

    void print() {
        for (int i = 1; i < vertices; ++i) {
            for (int j = 1; j < vertices; ++j) {
                System.out.print(graph[i][j]+"  ");
            }
            System.out.print("\n");
        }
    }

}


class GraphInputHandler {
    public Graph readInput(BufferedReader reader) throws IOException {
        System.out.print("Number of vertices: ");
        Integer vertices = Integer.parseInt(reader.readLine());

        Graph graph = new Graph(vertices);

        System.out.print("Number of edges: ");
        Integer edges = Integer.parseInt(reader.readLine());

        System.out.println("Write edges separated by a comma, one per line.");
        for (int i = 1; i <= edges; ++i) {
            System.out.print("Edge #" + i + " ");
            String line = reader.readLine();
            String[] splitted = line.split(",");
            graph.addEdge(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]));
        }

        return graph;
    }
}

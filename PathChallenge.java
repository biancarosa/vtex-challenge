import java.io.IOException;
import java.lang.System;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
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

        for (Integer i : graph.getVertices()) {
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
        Scanner scanner = new Scanner(System.in);
        GraphInputHandler inputHandler = new GraphInputHandler();

        try {
            System.out.print("Start node :: ");
            Integer start = scanner.nextInt();

            System.out.print("End node :: ");
            Integer end =  scanner.nextInt();

            graph = inputHandler.readInput(scanner);

            visited = new boolean[graph.getNumberOfVertices()+1];
            for (int i = 0; i < graph.getNumberOfVertices(); ++i) {
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
    private Map<Integer, LinkedList<Integer>> graph;
    private List<Integer> vertices;
    private int edges;

    Graph() {
        graph = new HashMap<Integer, LinkedList<Integer>>();
        vertices = new LinkedList<Integer>();
        edges = 0;
    }

    public boolean hasPathBetween(int u, int v) {
        LinkedList<Integer> list = graph.get(u);
        if (list != null) {
            return list.contains(v);
        }
        return false;
    }

    public void addEdge(int u, int v) {
        LinkedList<Integer> list;
        if (graph.get(u) == null) {
            list = new LinkedList<Integer>();
            graph.put((Integer) u, list);
            vertices.add(u);
        } else {
            list = graph.get(u);
        }
        list.add(v);
        vertices.add(v);
        edges++;
    }

    public List<Integer> getVertices() {
        return this.vertices;
    }

    public int getNumberOfVertices() {
        return this.vertices.size();
    }

    public int getNumberOfEdges() {
        return this.edges;
    }

}


class GraphInputHandler {
    public Graph readInput(Scanner scanner) throws IOException {

        Graph graph = new Graph();

        System.out.print("Write number of edges :: ");
        Integer edges = scanner.nextInt();

        System.out.println("Write vertices for each edge (1 1) ");
        for (int i = 1; i <= edges; ++i) {
            System.out.print("Edge #" + i + " ");
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        };

        return graph;
    }
}

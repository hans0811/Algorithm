package BFS.theory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class Vertex <T> {

    private final T data;

    private boolean visited;

    private List<Vertex<T>> neighbors = new LinkedList<>();

    public Vertex(T data, boolean visited) {
        this.data = data;
        this.visited = visited;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", visited=" + visited +
                '}';
    }
}

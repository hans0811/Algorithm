package BFS.theory;

import java.util.List;

/**
 * @author hans
 */
public class Node<T> {

    public String name;

    public List<T> children;

    public boolean visited;

    public Node(){

    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

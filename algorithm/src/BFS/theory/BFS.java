package BFS.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hans
 */
public class BFS {

    public static void dfs(Node node){
        if(node.isVisited()){
            return;
        }
        node.setVisited(true);
        System.out.print(node.getName() + " -> ");
        if( node.getChildren() == null || node.getChildren().size() == 0){
            return;
        }
        for(int i=0; i < node.getChildren().size(); i++){
            dfs((Node) node.getChildren().get(i));
        }
    }

    public static void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();

        node.setVisited(true);

        queue.offer(node);

        while(!queue.isEmpty()){

            Node temp = queue.peek();
            System.out.print(temp.getName() + " -> ");

            queue.poll();

            if(temp.getChildren() == null){
                continue;
            }

            for(int i=0; i < temp.getChildren().size(); i++){
                Node children = (Node) temp.getChildren().get(i);
                if(children.isVisited()){
                    continue;
                }
                children.setVisited(true);
                queue.add(children);

            }


        }


    }




    public static void main(String[] args) {


        Node n1 = new Node("0");
        Node n2 = new Node("1");
        Node n3 = new Node("4");
        Node n4 = new Node("5");

        Node n5 = new Node("2");
        Node n6 = new Node("3");

        ArrayList<Node> a = new ArrayList<>();
        a.add(n2);
        a.add(n3);
        a.add(n4);

        n1.setChildren(Arrays.asList(n2, n3, n4));
        n2.setChildren(Arrays.asList(n6, n3));
        n5.setChildren(Arrays.asList(n1));
        n6.setChildren(Arrays.asList(n3, n5));

        //dfs(n1);

        System.out.println();

        bfs(n1);
    }
}

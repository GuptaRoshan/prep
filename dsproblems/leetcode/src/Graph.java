import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

    static public Node cloneGraph(Node node) {
      
        if (node == null) {
            return node;
        }

    
        // BFS Implementation 

    /*  
        Queue<Node> queue = new LinkedList<Node>();
        HashMap<Integer, Node> visited = new HashMap<Integer, Node>();

        visited.put(node.val, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node root = queue.poll();
            Node copy = visited.get(root.val);

            List<Node> neighbors = root.neighbors;
            for (int i = 0; i < neighbors.size(); i++) {

                int val = neighbors.get(i).val;

                if (!visited.containsKey(val)) {
                    visited.put(val, new Node(val));
                    queue.add(neighbors.get(i));
                }

                copy.neighbors.add(visited.get(val));
            }
        }
        return visited.get(node.val);

      */

      return clone(node);

    }

    static HashMap<Node, Node> oldToNew = new HashMap<Node, Node>();

    static public Node clone(Node node) {

        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(clone(node.neighbors.get(i)));
        }

        return copy;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Graph.cloneGraph(node1);

    }

}

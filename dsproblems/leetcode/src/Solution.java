import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Solution {

    static class TreeNode {
        double data;
        TreeNode left, right;

        public TreeNode(int key) {
            data = key;
            left = right = null;
        }
    }

    static ArrayList<Double> BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Double> list = new ArrayList<Double>();

        if (root == null) {
            return list;
        }

        queue.add(root);
        int n;
        while (!queue.isEmpty()) {
            double sum = 0;
            n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.data;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sum / n);
        }

        return list;
    }

    static public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int minDepth = 0;
        int n = 0;

        while (!queue.isEmpty()) {
            n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left == null || node.right == null) {
                    return minDepth + 1;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            minDepth++;

        }

        return minDepth;

    }

    static int height(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int LH = height(root.left);
        int RH = height(root.right);
        int ans = Math.max(LH, RH) + 1;

        return ans;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // BFS(root);
        // System.out.println(height(root));
        System.out.println(minDepth(root));
    }
}

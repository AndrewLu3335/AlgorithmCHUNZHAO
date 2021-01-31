/**
 * @Author: Andrew Lu
 * @Description: No Description
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: N叉树的后续遍历
 */

public class NAryTreePostorderTraversal590 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Stack<ArrayList<Integer>> aStack = new Stack<ArrayList<Integer>>();
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        nodeQ.add(root);
        nodeQ.add(dummy);
        while(nodeQ.size() > 0){
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(nodeQ.peek() != dummy){
                TreeNode temp = nodeQ.poll();
                level.add(temp.val);
                if (temp.left != null) nodeQ.add(temp.left);
                if (temp.right != null) nodeQ.add(temp.right);
            }
            aStack.add(level);
            if (nodeQ.size() == 1 && nodeQ.peek() == dummy) break;
            nodeQ.add(nodeQ.poll());
        }
        while(!aStack.empty()){
            result.add(aStack.pop());
        }
        return result;
    }
}
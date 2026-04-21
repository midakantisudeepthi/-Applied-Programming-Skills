/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {

            // both nodes are in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // both nodes are in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // split point found
            else {
                return root;
            }
        }

        return null;
    }
}

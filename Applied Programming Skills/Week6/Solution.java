/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int c=0;
    TreeNode res=null;
    public int kthSmallest(TreeNode root, int k) {

        inorder(root,k);
        return res.val;
    }
    public void inorder(TreeNode r,int k)
    {
        if (r==null)
            return ;
        inorder(r.left,k);
        c++;
        if(c==k)
        {
            res=r;
            
        }
        inorder(r.right,k);
    }
    
}
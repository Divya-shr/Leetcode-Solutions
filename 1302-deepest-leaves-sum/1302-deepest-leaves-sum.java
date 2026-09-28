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
    int max=0;
    int sum=0;
    public int function(TreeNode root,int count)
    {
      if(root==null) return sum;
      if(root.left==null && root.right==null) 
      { 
        if(count > max)
        {
            sum=0;
            sum+=root.val;
        }
        if(count==max)
        {
            sum+=root.val;
        }
        max=Math.max(max,count);
        return 0;
      }
      function(root.left,count+1);
      function(root.right,count+1);
      return sum; 
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        int count=0;
        function(root,1);
        return sum;
    }
}
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
         int level = 0;
        while(!queue.isEmpty()){
             int size = queue.size();
             int currentodd = 0;
             int currenteven = Integer.MAX_VALUE;
             while(size>0){
                if((level & 1)==0){
                     TreeNode current = queue.poll();
                     if((current.val & 1) !=1 || current.val<=currentodd)return false;
                     currentodd = current.val;
                     if(current.left!=null)queue.add(current.left);
                     if(current.right!=null)queue.add(current.right);
                }
                else{
                    TreeNode current = queue.poll();
                    if((current.val & 1) !=0 || current.val>=currenteven)return false;
                    currenteven = current.val;
                    if(current.left!=null)queue.add(current.left);
                    if(current.right!=null)queue.add(current.right);
                }
                size--;
             }
             level++;
        }
        return true;
    }
}
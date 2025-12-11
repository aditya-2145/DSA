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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<Integer> imd = new ArrayList<>();
        checkFurther(root, imd, ans, targetSum, 0);
        return ans;
    }

    private void checkFurther(TreeNode root, List<Integer> imd, List<List<Integer>> ans, int target, int sum) {
        if (root == null)
            return;

        sum += root.val;
        imd.add(root.val);

        // If it's a leaf node and the path sum matches target
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(imd));
            }
            imd.removeLast(); // Backtrack before return
            return;
        }

        // Continue exploring left and right subtrees
        checkFurther(root.left, imd, ans, target, sum);
        checkFurther(root.right, imd, ans, target, sum);

        // Backtrack after exploring both sides
        imd.removeLast();
    }
}
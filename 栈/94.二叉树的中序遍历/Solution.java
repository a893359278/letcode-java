public class Solution {
    public List<Integer> inorderTraversa(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while(!stack.empty()) {
            root = stack.pop();
            while(root.left != null && !set.contains(root)) {
                set.add(root);
                stack.push(root);
                root = root.left;
            }
            list.add(root.val);
            if(root.right != null) {
                root = root.right;
                stack.push(root);
            }
        }
        return list;
    }
    /**
     * 更优解法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
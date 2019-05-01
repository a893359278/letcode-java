class Solution {

    /**
     *  基于广度优先算法，实现。
     *  该实现，还不是最优的，因为我用了2个队列
     *  完全可以只有1个队列实现
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            List<TreeNode> queue = new ArrayList<>();
            List<TreeNode> tmpQueue = new ArrayList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                TreeNode tmp = queue.get(size - 1);
                list.add(tmp.val);
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.get(i);
                    if(n.left != null) {
                        tmpQueue.add(n.left);
                    }
                    if(n.right != null) {
                        tmpQueue.add(n.right);
                    }
                }
                queue.clear();
                queue.addAll(tmpQueue);
                tmpQueue.clear();
            }
        }
        return list;
    }

    /**
     * 更优解，采用递归思想
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    public void dfs(TreeNode node, List<Integer> list, int level) {
        if(node == null) return;
        if(level == list.size()) {
            list.add(node.val);
        }
        dfs(node.right, list, level + 1);
        dfs(node.left, list, level + 1);
    }

}
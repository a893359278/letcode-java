class Solution {

    /**
     * 基于队列的求解
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        LinkedList<TreeNode> tmpQueue = new LinkedList();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < queue.size(i); i++) {
                TreeNode n = queue.get();
                tmp.add(n.val);
                if(n.left != null) {
                    tmpQueue.add(n.left);
                }
                if(n.right != null) {
                    tmpQueue.add(n.right);
                }
            }
            list.add(tmp);
            queue.clear();
            queue.addAll(tmpQueue);
            tmpQueue.clear();
        }
        return list;
    }

    /**
     * 更优解，采用 递归思想
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(root,list,0);
        return list;
    }

    public void bfs(TreeNode node, List<List<Integer>> list, int level) {
        if(node != null) {
            List<Integer> tmp = null;
            if(list.isEmpty() || list.size() <= level) {
                tmp = new ArrayList<>();
                list.add(tmp);
            } else {
                tmp = list.get(level);
            }
            tmp.add(node.val);
            bfs(node.left, list, ++level);
            bfs(node.right, list, level);
        }
    }
}
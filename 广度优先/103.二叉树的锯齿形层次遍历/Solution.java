class Solution {

    /**
     * 基于队列的求解;
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root != null) {
            List<Integer> tmp = new ArrayList<>();
            queue.add(root);
            boolean flag = true;
            while(!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> l = new ArrayList<>();
                while(n > 0) {
                    // 从右边遍历
                    if(!flag) {
                        TreeNode node = queue.removeLast();
                        l.add(node.val);
                        if(node.right != null) {
                            queue.addFirst(node.right);
                        }
                        if(node.left != null) {
                            queue.addFirst(node.left);
                        }
                    }else {
                        // 从左边遍历
                        TreeNode node = queue.remove();
                        l.add(node.val);
                        if(node.left != null) {
                            queue.addLast(node.left);
                        }
                        if(node.right != null) {
                            queue.addLast(node.right);
                        }
                    }
                    n--;
                }
                list.add(l);
                flag = !flag;
            }
        }
        return list;
    }

    /**
     *  采用递归思想
     *  递归的解法会更优一点
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(list, root, 0);
        return list;
    }

    public void bfs(List<List<Integer>> list,TreeNode root, int level) {
        if(root == null) return ;
        int size = list.size();
        if(size <= level) {
            list.add(new ArrayList<Integer>());
        }
        if(level % 2 == 0) {
            list.get(level).add(0,root.val);
        } else {
            list.get(level).add(root.val);
        }
        bfs(list, root.right, level + 1);
        bfs(list, root.left,  level + 1);
    }
}
public class Solution {

    /**
     * 我自己实现的算法
     * 基于队列~  题目标签 广度优先，上来就想着要用广度优先算法解~~
     * 看了别人的~~~坑啊
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            queue.add(root);
            while(queue.size() > 0) {
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.get(i);
                    if(node.left != null) {
                        l.add(node.left.val);
                        tmp.add(node.left);
                    } else {
                        l.add(null);
                    }
                    if(node.right != null) {
                        l.add(node.right.val);
                        tmp.add(node.right);
                    } else {
                        l.add(null);
                    }
                }
                queue.clear();
                queue.addAll(tmp);
                tmp.clear();
                if(l.size() % 2 != 0) {
                    return false;
                }
                if(l.size() == 0) {
                    continue;
                }
                int index = l.size() / 2 - 1;
                int tmpIndex = l.size() / 2;
                for(int i = index; i >= 0; i--) {
                    Integer tmp1 = l.get(i);
                    Integer tmp2 = l.get(tmpIndex);
                    if(tmp2 != null && !tmp2.equals(tmp1)) {
                        return false;
                    }
                    if(tmp1 != null && !tmp1.equals(tmp2)) {
                        return false;
                    }
                    tmpIndex++;
                }
            }
        }
        return true;
    }

    /**
     * 更优解
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isMicroTree(root.left, root.right);
    }

    public boolean isMicroTree(TreeNode left, TreeNode right) {
        if(left == null) {
            return right == null;
        }
        if(right == null) {
            return left == null;
        }
        return left.val == right.val && isMicroTree(left.left, right.right) && isMicroTree(left.right, right.left);
    }
}
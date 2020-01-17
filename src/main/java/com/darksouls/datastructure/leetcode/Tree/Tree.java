package com.darksouls.datastructure.leetcode.Tree;

import com.darksouls.datastructure.my.study.tree.BinarySearchTree;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Tree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
     *
     * 二叉搜索树保证具有唯一的值。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
     * 输出：32
     * 示例 2：
     *
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
     * 输出：23
     *
     * @param root
     * @param L
     * @param R
     */
    int ans;
    @Test
    public int q938(TreeNode root, int L, int R){
        ans = 0;
        q9381(root,L,R);
        return ans;
    }
    public void q9381(TreeNode node, int L, int R){
        if(node != null){
            if(node.val >= L && node.val <= R){
                ans += node.val;
            }
            if(L < node.val){
                q9381(node.left, L, R);
            }
            if (node.val < R){
                q9381(node.right, L, R);
            }

        }
    }

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * @param nums
     * @return
     */
    @Test
    public TreeNode q108(int[] nums){
        if(nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        int l = 0,r = nums.length;
        while (l < r){
            r = (l + r)/2;
            q1081(root,nums[r]);
        }
        l = 0;r = nums.length;
        while (l < r - 1){
            l = (l + r)/2;

            q1081(root,nums[l]);
        }
        return root;
    }

    private TreeNode q1081(TreeNode t,int x){
        if(t == null){
            t = new TreeNode(x);
            return t;
        }
        if(x > t.val){
            t.right = q1081(t.right,x);
        }else if(x < t.val) {
            t.left = q1081(t.left,x);
        }
        return t;
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    @Test
    public TreeNode q226(TreeNode root){
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> t = new LinkedList<>();
        t.add(root);
        while (t.size() != 0 ){
            TreeNode temp  = t.removeFirst();
            if(temp == null){
                continue;
            }
            if(temp.left == null && temp.right == null){
                continue;
            }
            TreeNode r;
            r = temp.left;
            temp.left = temp.right;
            temp.right = r;
            t.add(temp.left);
            t.add(temp.right);
        }
        return root;
    }

    /**
     *对二叉搜索树进行查找
     * @param root
     * @return
     */
    @Test
    public TreeNode q700(TreeNode root, int val) {
        TreeNode res;
        if(root == null){
            return null;
        }
        if(val > root.val){
            res= q700(root.right,val);
        }else if(val < root.val){
            res = q700(root.left,val);
        }else {
            return root;
        }
        return res;
    }

    /**
     * 查找二叉查找树的深度
     * @param root
     * @return
     */
    int deepLength = 0;
    int size = 1;
    @Test
    public int q104(TreeNode root) {
        if(root == null){
            if(size > deepLength){
                deepLength = size;
            }
            return deepLength;
        }
        size ++;
        if(root.left != null ){
           q104(root.left);
        }
        if(root.right != null){
            q104(root.right);
        }
        size --;
        return deepLength;
    }

    /**
     * q965 判断是不是单值二叉树
     * @param root
     * @return
     */
    boolean index = true;
    @Test
    public boolean isUnivalTree(TreeNode root) {

        if(root.left != null){
            if(root.val != root.left.val){
                index  = false;
            }
            isUnivalTree(root.left);
        }
        if(root.right != null){
            if(root.val != root.right.val){
                index  = false;
            }
            isUnivalTree(root.right);
        }
        return index;
    }

    /**
     * 合并二叉树
     * 经典
     * @param t1
     * @param t2
     * @return
     */
    @Test
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 检查有没有一条路径上和等于sum的
     */
    boolean hasPathSumRes = false;
    int count = 0;
    @Test
    public boolean hasPathSum(TreeNode root, int sum) {
            count += root.val;
        System.out.println(count);
        if(count == sum){
                hasPathSumRes = true;
            }
        if(root.left != null){
            hasPathSum(root.left,sum);
            count -= root.val;
        }
        if(root.right != null){
            hasPathSum(root.right,sum);
            count -= root.val;
        }
        return hasPathSumRes;
    }

    /**
     * q111
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *答案：
     * 2
     * @param root
     * @return
     */
    int minDeep = Integer.MAX_VALUE;
    int n = 1 ;
    @Test
    public int minDepth(TreeNode root) {
        if(root.left != null && root.right != null){
            if(n < minDeep){
                minDeep = n;
            }
            return minDeep;
        }
        n++;
        if(root.left != null){
            minDepth(root.left);
        }
        if(root.right != null){
            minDepth(root.right);
        }
        n--;
        return minDeep;
    }

    /**
     * 637. 二叉树的层平均值
     * @param root
     * @return
     */
    @Test
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> temp = new LinkedList<>();
        List<Double> res = new LinkedList<>();
        temp.add(root);
        while (temp.size() != 0){
            double t  = 0;
            double n = temp.size();
            System.out.println(t);
            System.out.println(n);
            for (TreeNode e : temp){
                t += e.val;
            }
            for (int i = 0; i < temp.size(); i++) {
                TreeNode e = ((LinkedList<TreeNode>) temp).removeFirst();
                if(e.left != null){
                    temp.add(e.left);
                }
               if(e.right != null){
                   temp.add(e.right);
               }
            }
            res.add(t/n);
        }
        return res;
    }

    /**
     * q107. 二叉树的层次遍历 II
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 答案：
     *[
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     * @param root
     * @return
     */
    @Test
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        List<TreeNode> temp = new LinkedList<>();
        if(root == null){
            return res;
        }
        temp.add(root);
        while (temp.size() != 0){
            int n = temp.size();
            List<Integer> t = new LinkedList<>();
            for (int i = 0; i < n; i++) {

                TreeNode e = ((LinkedList<TreeNode>) temp).removeFirst();
                t.add(e.val);
                if(e.left != null){
                    temp.add(e.left);
                }
                if(e.right != null){
                    temp.add(e.right);
                }
            }
            ((LinkedList<List<Integer>>) res).addFirst(t);
        }
        return res;
    }

    /**
     * q739
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * @param T
     * @return
     */
    @Test
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        boolean index = false;
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if(T[j] > T[i]){
                    index = true;
                    res[i] = j - i;
                    break;
                }
            }
            if(!index){
                res[i] = 0;
            }
            index =false;

        }
        return res;
    }

    /**
     * q897
     * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
     * @param root
     * @return
     */
    @Test
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<Integer> t = new LinkedList<>();
        increasingDFS(root,t);
        TreeNode res = new TreeNode(0),cur = res;
        for(int i : t){
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return res.right;
    }

    public void increasingDFS(TreeNode root,LinkedList<Integer> val){
        if(root.left != null){
            increasingDFS(root.left,val);
        }
        val.add(root.val);
        if(root.right != null){
            increasingDFS(root.right,val);
        }
    }

    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *q257
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root
     * @return
     */

//    @Test
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new LinkedList<>();
//        binaryTreePathDFS(root,res);
//        return res;
//    }
//    public void binaryTreePathDFS(TreeNode root,List<String>list){
//        StringBuilder r = new StringBuilder();
//        if(root.right != null && root.left != null){
//            list.add(r.toString());
//            r.deleteCharAt(r.length() - 1);
//        }
//        if(root.left != null){
//            binaryTreePathDFS(root.left,list);
//        }
//        r.append(root.val);
//        if(root.right != null){
//            binaryTreePathDFS(root.right,list);
//        }
//    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * @param root
     * @param p
     * @param q
     * @return
     */
//    @Test
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root.left != null){
//            lowestCommonAncestor(root.left,p,q);
//        }
//        if(root.right != null){
//            lowestCommonAncestor(root.right,p,q);
//        }
//    }

}

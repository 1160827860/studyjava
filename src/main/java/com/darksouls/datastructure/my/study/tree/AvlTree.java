package com.darksouls.datastructure.my.study.tree;

/**
 * Avl树是带有平衡条件的二叉查找树
 */
public class AvlTree<E extends Comparable<? super E> > implements tree<E>  {
    private AvlNode<E> root;
    //平衡因子
    private static final int ALLOWED_IMBALANCE = 1;
    /**
     * Avl树的节点和二叉树差不多，主要是多了树的因子
     * 主要辨析左旋转和右旋转，至于插入多个一样的值，可以采用如果等于0就直接删除
     * 如果大于0就减一
     * @param <E>
     */
    private static class AvlNode<E>{
        E element;
        AvlNode<E> left;
        AvlNode<E> right;
        int height;
        public AvlNode(E element) {
            this.element = element;
        }

        public AvlNode(E element, AvlNode<E> left, AvlNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 使树为空
     */
    @Override
    public void makeEmpety() {
        root = null;
    }

    /**
     * 检查树是否为空
     *
     * @return true 空
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 检查节点是否包含e这个元素
     *
     * @param e
     */
    @Override
    public boolean contains(E e) {
        return contains(e,root);
    }
    private boolean contains(E e,AvlNode<E> t){
        if(t == null){
            return false;
        }
        int  compareResult = e.compareTo(t.element);
        if(compareResult > 0){
            contains(e,t.right);
        }else if(compareResult < 0){
            contains(e,t.left);
        }else {
            return true;
        }
        return false;
    }
    /**
     * 找到树中的最小值
     */
    @Override
    public E findMin() {
        return findMin(root);
    }
    private E findMin(AvlNode<E> x){
        if(x.left == null){
            return x.element;
        }else if(x == null){
            return null;
        }
        return findMin(x.left);
    }

    /**
     * 找到树中的最大值
     *
     * @return
     */
    @Override
    public E findMax() {
        return findMax(root);
    }
    private E findMax(AvlNode<E> x){
        //返回树最右边的值，分为两种情况：只有根节点就直接返回了和有
        // 右节点才会递归运行，中间节点不管，只有尾节点才管。
        if(x.right == null){
            return x.element;
        }else if(x == null){
            //如果树的节点为null，就直接返回null
            return null;
        }
        //最后返回
        return findMax(x.right);
    }

    /**
     * 向树中插入元素
     * 也要检查平衡
     *
     * @param x 所插入的元素
     */
    @Override
    public void insert(E x) {
        root = insert(root,x);
    }
    private AvlNode<E> insert(AvlNode<E> t,E x){
        if (t == null){
            return new AvlNode<>(x,null,null);
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult > 0){
            t.right = insert(t.right,x);
        }else if(compareResult < 0){
            t.left = insert(t.left,x);
        }else {
            //没有采用惰性删除的策略
        }
        return balance(t);
    }

    /**
     * 用来平衡节点
     * @param t 节点
     * @return 已经平衡后的节点
     */
    private AvlNode<E> balance(AvlNode<E> t){
        //如果检查的结点为null直接返回
        if(t == null){
            return t;
        }
        //先检查左右结点高度一致不一致，如果大于1就是左边比右边高
        if(height(t.left) - height(t.right) > ALLOWED_IMBALANCE ){
            if(height(t.left.left) > height(t.left.right)){
                //LL单旋转
                t = rotateWithLeftChild(t);
            }else {
                //LR双旋转
                t = doubleWithLeftChiled(t);
            }
        }else if(height(t.right) - height(t.left) > ALLOWED_IMBALANCE){
            if(height(t.right.right) > height(t.right.left)){
                //RR单旋转
                t = rotateWithRightChild(t);
            }else {
                //RL双旋转
                t = doubleWithRightChiled(t);
            }
        }
        //现在判断左子树和右子树哪个高度高就给加一
        t.height = Math.max(height(t.left),height(t.right)) + 1;
        return t;
    }

    /**
     * 左旋转
     * @param k2
     * @return
     */
    private AvlNode<E> rotateWithLeftChild(AvlNode<E> k2){
        AvlNode<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left),k2.height) + 1;
        return k1;
    }

    /**
     * 右旋转
     * @param k2
     * @return
     */
    private AvlNode<E> rotateWithRightChild(AvlNode<E> k2){
        AvlNode<E> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right),k2.height) + 1;
        return k1;
    }

    /**
     * 双旋转LR
     * 先对左边的树进行右旋转，然后在对K3进行左旋转，因为LR其实可以看
     * 出是LRR，左部子树是RR情况，所以先把k1,k2RR转化为平衡，这样K3
     * 就是LL情况，再进行左旋转就平衡了
     * @param k3
     * @return
     */
    private AvlNode<E> doubleWithLeftChiled(AvlNode<E> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 双旋转RL
     * 就是RLL
     * @param k3
     * @return
     */
    private AvlNode<E> doubleWithRightChiled(AvlNode<E> k3){
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    /**
     * 获取节点的高度null为-1
     * @param t
     * @return
     */
    private int height(AvlNode<E> t){
        return t == null ? -1:t.height;
    }

    /**
     * 删除数中的某个元素
     *
     * @param x 所要删除的元素
     */
    @Override
    public E remove(E x) {
       return remove(x,root).element;
    }
    private AvlNode<E> remove(E x,AvlNode<E> t){
        if(t == null){
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult > 0){
            t.left = remove(x,t.left);
        }else if(compareResult < 0){
            t.right = remove(x,t.right);
        }else if(t.left != null && t.right != null){
            t.element = findMin(t.right);
            t.right = remove(t.element,t.right);
        }else {
            t = ( t.left  != null) ? t.left : t.right;
        }
        return balance(t);
    }

    /**
     * 输出所有数的元素
     */
    @Override
    public void printTree() {
        printTree(root);
    }
    private void printTree (AvlNode<E> t){
        if(t != null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    public static void main(String[] args) {
        AvlTree<Integer> t = new AvlTree<>();
        for (int i = 1; i <= 16; i++) {
            t.insert(i);
        }
        t.printTree();
    }

}

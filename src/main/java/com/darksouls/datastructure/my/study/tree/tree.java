package com.darksouls.datastructure.my.study.tree;

public interface tree<E extends Comparable<? super E>> {
    /**
     * 使树为空
     */
    void makeEmpety();

    /**
     * 检查树是否为空
     * @return true 空
     */
    boolean isEmpty();
    /**
     *检查节点是否包含e这个元素
     */
    boolean contains(E e);
    /**
     *找到树中的最小值
     */
    E findMin();

    /**
     * 找到树中的最大值
     * @return
     */
    E findMax();
    /**
     * 向树中插入元素
     * @param x 所插入的元素
     */
    void insert(E x);

    /**
     * 删除数中的某个元素
     * @param x 所要删除的元素
     */
    E remove(E x);

    /**
     * 输出所有数的元素
     */
    void printTree();


}

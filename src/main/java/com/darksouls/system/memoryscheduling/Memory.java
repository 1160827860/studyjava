package com.darksouls.system.memoryscheduling;

import java.util.LinkedList;

/**
 * @author 李正阳  17060208112
 * 内存
 */
public class Memory {
    /**
     * @param size 内存大小
     */
    static int size;
    /**
     * 空闲分区表
     * 和用户指令存储表
     * 作业分区
     */
    public static LinkedList<Order> orders = new LinkedList<>();

    public static LinkedList<Partition> table = new LinkedList<>();

    public static LinkedList<Partition> work = new LinkedList<>();

    public static void print(){
        for(Partition temp : table){
            System.out.println("空闲分区区大小：" + temp.getSize() + " 空闲分区起始地址 " + temp.getStart());
        }
    }

}

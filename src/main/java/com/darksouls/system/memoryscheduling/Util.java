package com.darksouls.system.memoryscheduling;

import java.util.Scanner;

/**
 * 封装初始化信息
 *
 */
public class Util {

    public static void choic(){
        Scanner in = new Scanner(System.in);
        System.out.println("请选择算法：");
        System.out.println("A.最佳适应算法");
        System.out.println("B.首次适应算法");
        System.out.println("C.循环首次适应算法");
        System.out.println("D.最坏适应算法");
        switch (in.next()){
            case "A": OA.start();break;
            case "B":FF.start();break;
            case "C":ADAPTS.start();break;
            case "D":WF.start();break;
        }
    }
    public static void initMemory(){
        Scanner in = new Scanner(System.in);
        System.out.println("分配内存大小");
        Memory.size = in.nextInt();
        System.out.println("请输入申请和释放的命令的个数");
        int n = in.nextInt();
        for(int i = 0;i < n; i++){
            System.out.println("请输入指令的id(例如内存申请id=1，释放" +
                    "内存id = 1，指令的类别（1代表申请，2代表释放），以" +
                    "及申请的内存大小");
            Memory.orders.add(new Order(in.nextInt(),in.nextInt(),in.nextInt()));
        }
        Memory.table.add(new Partition(Memory.size,0));
    }

    /**
     * 回收内存
     * @param order 回收内存指令得各种信息
     */
    public static void recoverMemory(Order order){
        /**
         * @param start 作业得起始地址
         * @param end 作业得结束地址
         * @param id 在作业队列中得id
         */
        int start = -1,end = -1,id = -1;
        /**
         *pre 上部pre是否为空闲分区 true 为空闲分区
         * next 下部是否为空闲分区 true 为空闲分区
         */
        boolean pre = true,next = true;
        /**
         * 代表了上下两个区在表中的位置
         */
        int prePt = -1,nexPt = -1;
        Partition work = new Partition();
        for (int i = 0; i < Memory.work.size(); i++) {
            Partition temp = Memory.work.get(i);
            if(order.getId() == temp.getName()){
                 start = temp.getStart();
                 end = temp.getStart() + temp.getSize();
                 id = temp.getName();
                work = temp;
                Memory.work.remove(temp);
                 break;
            }
        }
        for (int i = 0; i < Memory.work.size(); i++) {
            Partition temp = Memory.work.get(i);
            /**
             * 下不临，即下面为分配区
             */
            if( temp.getStart() == end){
                next = false;
                nexPt = i;
                break;
            }

            /**
             * 上不临现象，即上面是分配区
             */
            if( (temp.getStart() + temp.getSize()) == start){
                pre = false;
                prePt = i;
                break;
            }

        }
        for (int i = 0; i < Memory.table.size(); i++) {
            Partition temp = Memory.table.get(i);
//        for(Partition temp : Memory.table){
            /**
             * 下临，即下面为空闲区
             */
            if( temp.getStart() == end){
                next =true;
                nexPt = i;
                break;
            }
            /**
             * 上临现象，即上面是空闲区
             */
            if( (temp.getStart() + temp.getSize()) == start){
                pre = true;
                prePt = i;
                break;
            }
        }
        if(prePt == -1){
            pre = false;
        }
        if(nexPt == -1){
            next = false;
        }
        if(next == true && pre == true){
            downAndUp(work,prePt,nexPt);
        }else if(next == true && pre == false){
            downNotUp(work,nexPt);
        }else if(next == false && pre == true){
            upNotDown(work,prePt);
        }else {
            notDownNotUp(work,prePt);
        }
    }

    /**
     * prePt 代表是上面分区在表中的位置 -1代表当前作业在在内存首
     * nexPt 代表的是下面分区在表中的位置 -1代表当前作业在内存尾
     *
     * 回收内存的四种情况
     * n表示上面的空闲区
     * 上临空闲区下不临
     */
    private static void upNotDown(Partition work,int n){
        Partition temp = Memory.table.get(n);
        temp.setSize(temp.getSize() + work.getSize());
    }
    /**
     * 下临空闲区上不临
     */
    private static void downNotUp(Partition work,int n){
        Partition temp = Memory.table.get(n);
        temp.setStart(temp.getStart() - work.getSize());
        temp.setSize(temp.getSize() + work.getSize());
    }
    /**
     * pre为上面的空闲区
     * next 为下面的空闲区
     * 上临空闲区下面也临空闲区
     */
    private static void downAndUp(Partition work,int pre,int next){
        Partition temp = Memory.table.get(pre);
        temp.setStart(temp.getStart());
        temp.setSize(temp.getSize() + work.getSize()  + Memory.table.get(next).getSize());
        Memory.table.remove(next);
    }
    /**
     * 上不临空闲区，下不临空闲区
     * n为上面的分配区
     */
    private static void notDownNotUp(Partition work,int pre){

        if(pre == -1){
            Memory.table.add(new Partition(work.getSize(), 0));
        }else {
            Memory.table.add(new Partition(work.getSize(),
                    Memory.work.get(pre).getStart() +
                            Memory.work.get(pre).getSize()));
        }
    }
}

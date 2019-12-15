package com.darksouls.system.bank;


import java.util.LinkedList;
import java.util.Scanner;

public class Banker {
    public static LinkedList<WorkThread> workThreads = new LinkedList<>();
    public static LinkedList<Resource> available = new LinkedList<>();

    static {
        try {
                 for (int i = 0; i < Util.threads.size(); i++) {
                    workThreads.add((WorkThread) Util.threads.get(i).deepClone());
                 }
                for (int i = 0; i < Util.available.size(); i++) {
                    available.add((Resource) Util.available.get(i).deepClone());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    /**
     * 标志是否为安全序列
     */
    static boolean index = false;
    /**
     * 保存安全序列
     */
    public static LinkedList<String> res = new LinkedList<>();
    public static void checkSafe() throws Exception {
        checkResouce(workThreads,available);
    }

    private static void printRes(){
        System.out.print("安全序列是: ");
        for(String string :res){
            System.out.print(string + " ");
        }
        index =true;
    }
    /**
     * 一直试分配（递归），直到所有线程的都分配完，或者走到死路退回
     * @param  next 递归下一个线程链表
     */
    private static void checkResouce(LinkedList<WorkThread> next,LinkedList<Resource> rtemp) throws Exception {
        /**
         * 遍历线程资源
         */
        for (int i = 0; i < next.size(); i++) {
            /**
             * t代表线程
             */
            WorkThread t = next.get(i);
            if(checkFinish(next)){
                printRes();
            }
            /**
             * 试分配,检查是否有死路
             * rk代表现有资源
             */
                if (checkDeadRoad(next,rtemp)) {
                    /**
                     * 检查本线程是否可以进行分配
                     */
                    /**
                     * 分配资源后改变资源
                     */
                    if(checkGetRescource(t,rtemp) && !t.finish ){
                        for (int j = 0; j < t.need.size(); j++) {
                            Resource tr = t.need.get(j);
                            Resource ar = t.allocation.get(j);
                                /**
                                * 回收线程占有的资源
                                * tr代表需要的资源
                                */
                                for (Resource rr : rtemp) {
                                    if (ar.name.equals(rr.name)) {
                                        rr.count = rr.count + ar.count;
                                        break;
                                    }
                                }
                            tr.count = 0;
                        }
                        t.finish = true;
                        res.add(t.name);
                       checkResouce(next,rtemp);
                    }
            }else {
                    if(res.size() > 0){
                        String name = res.removeLast();
                        WorkThread temp = findThread(name);
                        next.set(findThreadIndex(name),temp) ;
                        reRescourse(rtemp,temp);
                        return;
                    }

                }
        }
        if(!index){
            System.out.println("没有找到安全序列");
        }
        if(res.size() != 0 ){
            String name = res.removeLast();
            WorkThread temp = findThread(name);
            next.set(findThreadIndex(name),temp) ;
            reRescourse(rtemp,temp);
        }
    }

    /**
     * 回收分配出去的资源，递归返回上一层
     * @param r
     * @param w
     */
    private static void reRescourse(LinkedList<Resource> r,WorkThread w){
        /**
         * wr 为该线程占有的资源
         */
        for(Resource wr : w.getAllocation()){
            /**
             * rr  为可分配资源
             */
            for (Resource rr : r ){
                if(wr.getName().equals(rr.getName())){
                    rr.setCount(rr.getCount() - wr.getCount());
                }
            }
        }
    }
    /**
     * 找到该名称的线程在链表中的索引
     * @param name 线程的名字
     * @return 线程在链表中的位置
     */
    private static int findThreadIndex(String name)  {
        for (int i = 0; i < Util.threads.size(); i++) {
            if(Util.threads.get(i).getName().equals( name)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 找到名字为name的线程
     * @param name 线程的名字
     * @return 线程
     * @throws Exception
     */
    private static WorkThread findThread(String name) throws Exception {
        for(WorkThread w : Util.threads){
            if(w.name.equals( name)){
                return (WorkThread) w.deepClone();
            }
        }
        return null;
    }



    /**
     * 检查是不是走入死路
     * @return true 还可以继续向下
     */
    private static boolean checkDeadRoad(LinkedList<WorkThread> w,LinkedList<Resource> r){
        boolean index = false;
        for (int i = 0; i < w.size(); i++) {
            /**
             * 已经完成的线程不论
             */
            WorkThread temp = w.get(i);
            if(temp.finish == true){
                continue;
            }

            boolean[] bt = new boolean[Util.available.size()];
            for (int j = 0; j < temp.need.size(); j++) {
                Resource nr = temp.need.get(j);
                for (int k = 0; k < r.size(); k++) {
                    Resource rr = r.get(k);
                    if(nr.name.equals(rr.name)){
                        if(nr.getCount() <= rr.getCount()){
                            bt[j] = true;
                            break;
                        }
                    }
                }
            }
            if(checkAllRescouce(bt)){
                return !index;
            }
        }
        return index;
    }
    /**
     * 检查当前进程是否可以获取资源
     * @return true 可以
     */
    private static boolean checkGetRescource(WorkThread w,LinkedList<Resource> r){
        boolean index = false;
            WorkThread temp = w;
            boolean[] bt = new boolean[Util.available.size()];
            for (int j = 0; j < temp.need.size(); j++) {
                Resource nr = temp.need.get(j);
                for (int k = 0; k < r.size(); k++) {
                    Resource rr = r.get(k);
                    if(nr.name.equals(rr.name)){
                        if(nr.getCount() <= rr.getCount()){
                            bt[j] = true;
                        }
                    }
                }
            }
            if(checkAllRescouce(bt)){
                return !index;
            }
        return index;
    }


    /**
     * 检查是否满足所有资源
     * @param bt 记录是否满足的数组
     * @return true 满足
     */
    private static boolean checkAllRescouce(boolean[] bt){
        /**
         * 检查这一个线程是不是每一类资源都可以满足
         */
        boolean total = false;
        for (boolean p : bt){
            /**
             * 不能满足
             */
            if(p == false){
                total = true;
            }
        }
        return !total;
    }
    /**
     * 检查所有进程是否都已经完成
     */
    private static boolean checkFinish(LinkedList<WorkThread> workThreads){
        boolean index = true;
        for(WorkThread temp : workThreads){
           if(temp.finish == false){
               index = false;
               break;
           }
        }
        if(index){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 检查请求是否允许
     */
    public static void checkRequest() throws Exception {
         LinkedList<WorkThread> w = new LinkedList<>();
         LinkedList<Resource> r = new LinkedList<>();
        LinkedList<WorkThread> nextW = new LinkedList<>();
        LinkedList<Resource> nextR = new LinkedList<>();
        /**
         * 复制一份数据
         */
        for (int i = 0; i < Util.threads.size(); i++) {
            w.add((WorkThread) workThreads.get(i).deepClone());
        }
        for (int i = 0; i < Util.available.size(); i++) {
            r.add((Resource)available.get(i).deepClone());
        }
        /**
         * 初始化需要申请的资源
         */
        String thName = initName();
        LinkedList<Resource> reList =initRequest();

        /**
         * 检查是否满足条件
         */
        if(checkNeed(reList,thName,w)){
            if(checkAvailable(reList,r)){
                updateThread(reList,thName,w,r);
                for (int i = 0; i < Util.threads.size(); i++) {
                    nextW.add((WorkThread) w.get(i).deepClone());
                }
                for (int i = 0; i < Util.available.size(); i++) {
                    nextR.add((Resource)r.get(i).deepClone());
                }
                checkResouce(w,r);
                if(index){
                    System.out.println();
                    System.out.println("可以申请资源");
                }else {
                    System.out.println("不可以申请资源");
                }
            }else {
                System.out.println("此次请求不被允许，因为请求资源大于可以分配的资源");
            }
        }else {
            System.out.println("此次请求不被允许，因为请求资源大于需要资源");
        }
        if(index){
            workThreads = nextW;
            available = nextR;
        }
        index =false;
    }

    private static WorkThread findThread(String name,LinkedList<WorkThread> wr){
        for(WorkThread w : wr){
            if(w.name.equals( name)){
                return (WorkThread) w;
            }
        }
        return null;
    }
    /**
     *
     * @param r 申请资源名
     * @param name 线程名称
     * @param w 全部线程
     * @param rr 可分配资源
     * @throws Exception
     */
    private static void updateThread(LinkedList<Resource> r,String name,LinkedList<WorkThread> w,LinkedList<Resource> rr) throws Exception {
        /**
         * 申请资源遍历
         */
        for(Resource rtemp : r){
            /**
             *
             */
            for(Resource rlist:rr){
                if(rlist.getName().equals(rtemp.getName())){
                    rlist.setCount(rlist.getCount() -rtemp.getCount()  );
                    break;
                }
            }
                for(Resource nr :  findThread(name,w).getNeed()){
                    if(nr.getName().equals(rtemp.getName())){
                        nr.setCount(nr.getCount() - rtemp.getCount() );
                        break;
                    }
                }

                for(Resource ar : findThread(name,w).getAllocation()){
                    if(ar.getName().equals(rtemp.getName())){
                        ar.setCount(ar.getCount() + rtemp.getCount() );
                        break;
                    }
                }


        }
//        WorkThread temp = w.get(findThreadIndex(name));
//
//        temp.setNeed(r);
    }
    private static boolean checkNeed(LinkedList<Resource> reList,String name,LinkedList<WorkThread> ww) throws Exception {
        boolean index = true;
        WorkThread w = findThread(name,ww);
        for(Resource r : w.getNeed()){
            for(Resource re : reList){
                if(re.getName().equals(r.getName())){
                    if(re.getCount() > r.getCount()){
                        index = false;
                        break;
                    }
                }
            }
        }
        return index;
    }

    /**
     * 检查申请是否满足分配资源
     * @param reList
     * @return
     */
    private static boolean checkAvailable(LinkedList<Resource> reList,LinkedList<Resource> rr){
        boolean index = true;
        for(Resource r : rr){
            for(Resource re : reList){
                if(re.getName().equals(r.getName())){
                    if(re.getCount() > r.getCount()){
                        index = false;
                        break;
                    }
                }
            }
        }
        return index;
    }
    /**
     * 返回资源请求的线程名
     * @return 线程名
     */
    private static String initName(){
        Scanner in = new Scanner(System.in);
        System.out.println("进入检查请求资源是否允许算法");
        System.out.println("请输入申请资源的线程的名字");
        String name = in.next();
        return name;
    }
    /**
     * 初始化请求资源
     * @return 返回请求资源的全部列表
     */
    private static LinkedList<Resource> initRequest(){
        Scanner in = new Scanner(System.in);
        LinkedList<Resource> reList = new LinkedList<>();
        for (int i = 0; i < Util.available.size(); i++) {
            System.out.println("输入请求各资源的名称和数量");
            reList.add(new Resource(in.next(),in.nextInt()));

        }
        return reList;
    }
}

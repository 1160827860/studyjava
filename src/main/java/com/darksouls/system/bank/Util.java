package com.darksouls.system.bank;

import java.util.LinkedList;
import java.util.Scanner;

public class Util implements Cloneable{
    public  static LinkedList<Resource> available = new LinkedList<>();
    public  static LinkedList<WorkThread> threads = new LinkedList<>();

    /**
     * 初始化个线程和各资源
     */
    public static void initResource() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入资源的有多少种");
        int n = checkCount(in.nextInt());

        for (int i = 0; i < n; i++) {
            System.out.println("各资源的名字，以及各资源目前可分配的数量");
            available.add(new Resource(in.next(),checkInt(in.nextInt())));
        }
        System.out.println("请输入进程的数量");
        int tn = checkCount(in.nextInt());
        for (int i = 0; i < tn; i++) {
            System.out.println("请输入进程的名字");
            WorkThread t = new WorkThread(in.next());
            /**
             * 录入线程Max数组（需要的总资源的数组）、Allocation数组（占有
             * 的资源）Need数组（代表了还需要的资源个数）
             */
            for (int i1 = 0; i1 < n; i1++) {
                System.out.println("请输入进程需要的资源的名称");
                String name = in.next();
                System.out.println("一共需要该资源多少(max数组)");
                System.out.println("请输入该资源在allocation数组（已经占有" +
                        "的资源）的个数");
                System.out.println("请输入该资源在need数组（需要分配此资源" +
                        "）的个数");
                t.max.add(new Resource(name,checkInt(in.nextInt())));
                t.allocation.add(new Resource(name,checkInt(in.nextInt())));
                t.need.add(new Resource(name,checkInt(in.nextInt())));
            }
            Util.threads.add(t);
        }
    }
    public static int checkCount(int n) throws Exception {
        if(n <= 0){
            throw new Exception("请不要输入负数和0");
        }else {
            return n;
        }
    }
    public static int checkInt(int n) throws Exception {
        if(n < 0){
            throw new Exception("请不要输入负数");
        }else {
            return n;
        }
    }

    public static void start() throws Exception {
        initResource();
    }
}

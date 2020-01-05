package com.darksouls.system.bank;


import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;

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

    /**
     * 找到所有的安全序列
     * @throws Exception
     */
    public static void checkAllSafe() throws Exception {
        checkResouce(workThreads,available);
        System.out.println();
    }

    /**
     * 安全性算法
     * @throws Exception
     */
    public static void check() throws Exception {
        if (!checkSafe()){
            System.out.println("未找到安全序列，系统目前不安全");
        }

    }
    /**
     * 安全性算法
     * @return true 安全
     */
    private static boolean checkSafe() throws Exception {
        //index代表系统安全还是不安全
        boolean index = false;
        //存放安全序列即进程的名字
        LinkedList<String> res = new LinkedList<>();
        //克隆两个表,检测安全性不更改原表,不然后续的请求不好处理
        LinkedList<WorkThread> w = cloneThread(workThreads);
        LinkedList<Resource> r = cloneRescourse(available);
        //对进程链表循环,直到无进程可以分配
        for(int i = 0;i < w.size() ; i++){
            //检查所有进程是不是都已经分配成功了,若是就跳出循环
//            if(checkFinish(w)){
//                break;
//            }
            //优化了一下,之前检测是否都已经完成需要O(n),现在是O(1)
            if(res.size() == w.size()){
                break;
            }
            //检查是不是已经无法继续分配资源,若是就直接返回index
            if(!checkDeadRoad(w,r)){
                return index;
            }
            //获得当前遍历到的进程
            WorkThread temp = w.get(i);
            //可以分配就分配,然后将分配后的可用资源链表更新占有加上现有的可分配资源
            if(checkGetRescource(temp,r) && !temp.isFinish()){
                //将已经完成的进程加入安全序列结果队列中
                res.add(temp.getName());
                //更新可用资源链表
                updateResource(temp,r);
                //将进程的完成标志置为true
                temp.setFinish(true);
                //从头开始循环
                i = -1;
            }
            //如果遍历到最后也从头开始,相当于死循环,循环终止由最开始的两个函数控制
            if(i == w.size()-1){
                i = -1;
            }
        }
        //将系统安全状态置为true
        index = true;
        //输出安全序列
        if(index){
            System.out.print("处于安全状况，安全序列为");
            for(String ThreadName : res){
                System.out.print(ThreadName+ " ");
            }
            System.out.println();
        }
        return index;
    }

    /**
     * 试分配，将资源分配给同时回收
     * 无分配过程，只有回收过程
     * @param w 需要分配的进程
     * @param r 资源列表
     */
    private static void updateResource(WorkThread w, LinkedList<Resource> r){
        LinkedList<Resource> allocation = w.getAllocation();
        //用来找到于资源结合
        HashMap<String,Integer> set = new HashMap<>();
        for (int i = 0; i < allocation.size(); i++) {
            String name = allocation.get(i).getName();
            int count = allocation.get(i).getCount();
            set.put(name,count);
        }
        for (Resource resource : r){
            resource.setCount(resource.getCount() + set.get(resource.getName()));
        }
    }

    /**
     * 服务安全性算法的回收算法
     */


    /**
     * 输出所有安全序列
     */
    private static void printRes(){
        System.out.print("安全序列是: ");
        for(String string :res){
            System.out.print(string + " ");
        }
        index =true;
    }
    private static void printRes(LinkedList<String> res){
        System.out.print("安全序列是: ");
        for(String string :res){
            System.out.print(string + " ");
        }
        index =true;
    }
    public static void printThread(List<WorkThread> res){
        for (WorkThread temp : res){
            System.out.print("进程名: " + temp.getName());
            System.out.print(" 进程需要的最大资源数目: ");
            for (Resource r : temp.getMax()){
                System.out.print(r.getName()+":" + r.getCount()+" ");
            }
            System.out.print("进程已经占有的资源数目: ");
            for (Resource r : temp.getAllocation()){
                System.out.print(r.getName()+":" + r.getCount()+" ");
            }
            System.out.print("进程还需要的资源数量");
            for (Resource r : temp.getNeed()){
                System.out.print(r.getName() +":"+ r.getCount()+" ");
            }
            System.out.println();
        }
    }
    public static void printResource(List<Resource> resources){
        System.out.print("目前系统还能分配的资源数目");
        for (Resource r :resources){
            System.out.print(r.getName()+":" + r.getCount()+" ");
        }
    }
    /**
     * 找到所有的安全序列
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
        for (int i = 0; i < workThreads.size(); i++) {
            if(workThreads.get(i).getName().equals( name)){
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
     * @return true 还可以继续向下 false 死路
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
     * 深度克隆进程表
     *  @param w
     *   @return
     *   @throws Exception
     */
    private static LinkedList<WorkThread> cloneThread(LinkedList<WorkThread> w) throws Exception {
        LinkedList<WorkThread> res = new LinkedList<>();
        for (WorkThread temp : w){
            res.add((WorkThread) temp.deepClone());
        }
        return res;
    }

    /**
     * 深度克隆资源链表
     * @param w
     * @return
     * @throws Exception
     */
    private static LinkedList<Resource> cloneRescourse(LinkedList<Resource> w) throws Exception {
        LinkedList<Resource> res = new LinkedList<>();
        for (Resource temp : w){
            res.add((Resource) temp.deepClone());
        }
        return res;
    }

    /**
     * 回收已经完成的进程
     * @param w 当前的进程队列
     * @param r 当前的资源队列
     */
    private static void reFinishThread(LinkedList<WorkThread> w,LinkedList<Resource> r){
        HashMap<String ,Integer> map = new HashMap<>();
        List<WorkThread> re = new LinkedList<>();
        //对正在迭代的集合修改会报错！！！
        for(WorkThread temp : w){
            if(checkFinishThrad(temp)){
                for(Resource rr : temp.getAllocation()){
                    map.put(rr.getName(),rr.getCount());
                }
                for(Resource rr : r){
                    rr.setCount(map.get(rr.getName())+ rr.getCount());
                }
                map.clear();
                re.add(temp);
            }
        }
        for(WorkThread temp:re){
            w.remove(temp);
        }

    }

    /**
     * 检查进程的需要是不是都已经变成了0，也就是可以回收了
     * @param w 当前进程
     */
    private static boolean checkFinishThrad(WorkThread w){
        int index = 0;
        for(Resource r: w.getNeed()){
            index = index | r.getCount();
        }
        if(index == 0){
            return true;
        }
        return false;
    }
    /**
     * 银行家算法
     */
    public static void checkRequest() throws Exception {
        index = false;
        //克隆2个一样的进程表和2个一样的资源表
        LinkedList<WorkThread> w = new LinkedList<>();
        LinkedList<Resource> r = new LinkedList<>();
        LinkedList<WorkThread> nextW = new LinkedList<>();
        LinkedList<Resource> nextR = new LinkedList<>();

        //深克隆的过程
        for (int i = 0; i < workThreads.size(); i++) {
            w.add((WorkThread) workThreads.get(i).deepClone());
        }
        for (int i = 0; i < available.size(); i++) {
            r.add((Resource)available.get(i).deepClone());
        }

       //初始化需要申请的资源
        String thName = initName();
        LinkedList<Resource> reList =initRequest();
        //检查是否有进程需要已经变为了0，那样的话就需要将进程回收
        reFinishThread(w,r);
        //检查是否请求资源是否大于需要资源
        if(checkNeed(reList,thName,w)){
            //检查请求资源是否大于可分配资源
            if(checkAvailable(reList,r)){
                //发现条件都满足就更新进程资源，并且将w,r表克隆一份
                updateThread(reList,thName,w,r);
                //检查是否有完成的进程，将它回收
                reFinishThread(w,r);
                for (int i = 0; i < w.size(); i++) {
                    nextW.add((WorkThread) w.get(i).deepClone());
                }
                for (int i = 0; i < r.size(); i++) {
                    nextR.add((Resource)r.get(i).deepClone());
                }
                //安全性算法检测
                checkResouce(w,r);
                //根据安全性算法检测提示是否可以请求资源
                if(index){
                    System.out.println();
                    System.out.println("可以申请资源");
                }else {
                    System.out.println("不可以申请资源");
                }

            }else {
                System.out.println("此次请求不被允许，因为请求资源大于系统可以分配的资源");
            }

        }else {
            System.out.println("此次请求不被允许，因为请求资源大于进程需要资源");
        }
        //如果请求被允许，就更新目前的进程表。
        if(index){
            //更新进程表
            workThreads = nextW;
            available = nextR;
            //输出目前进程表和资源表的信息
            printThread(workThreads);
            printResource(available);
        }
        //由于index是全局变量，检查过一次请求之后应该将其置为false
        index =false;
    }

    private static WorkThread findThread(String name,LinkedList<WorkThread> wr){
        for(WorkThread w : wr){
            if(w.name.equals( name)){
                return w;
            }
        }
        return null;
    }

    /**
     *修改目前进程的资源
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
    private static LinkedList<Resource> initRequest() throws Exception {
        Scanner in = new Scanner(System.in);
        LinkedList<Resource> reList = new LinkedList<>();
        for (int i = 0; i < available.size(); i++) {
            System.out.println("输入请求各资源的名称和数量");
            reList.add(new Resource(in.next(),Util.checkInt(in.nextInt())));
        }
        return reList;
    }
}

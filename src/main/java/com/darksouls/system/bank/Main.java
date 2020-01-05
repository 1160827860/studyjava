package com.darksouls.system.bank;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author 李正阳 17060208112
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Util.start();
        Scanner in = new Scanner(System.in);
        System.out.println("1.为检查T0时刻是否安全(可以输出所有安全序列)2.检查请求是否允许3.单纯检查T0时刻是否安全4.输出当前进程表和资源表5.退出功能");
        System.out.println();
        while (in.hasNext()){
            System.out.println("1.为检查T0时刻是否安全(可以输出所有安全序列)2.检查请求是否允许3.单纯检查T0时刻是否安全4.输出当前进程表和资源表5.退出功能");
            int n = in.nextInt();
            if(n == 1){
                Banker.checkAllSafe();
            }else if (n == 2){
                Banker.checkRequest();
            }else if (n == 3){
                Banker.check();
            }else if(n == 4){
                Banker.printThread(Banker.workThreads);
                Banker.printResource(Banker.available);
            }else if (n == 5){
                break;
            }else {
                System.out.println("输入错误");
                continue;
            }
        }
    }
}
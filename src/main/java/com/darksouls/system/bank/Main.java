package com.darksouls.system.bank;

import java.util.Scanner;

/**
 * @author 李正阳 17060208112
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Util.start();
        Scanner in = new Scanner(System.in);
        System.out.println("1.为检查T0时刻是否安全2.检查请求是否允许");
        while (in.hasNext()){
            if(in.nextInt() == 1){
                Banker.checkSafe();
            }else {
                Banker.checkRequest();
            }
        }
    }
}

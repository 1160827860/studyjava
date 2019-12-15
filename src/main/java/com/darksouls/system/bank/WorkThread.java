package com.darksouls.system.bank;

import java.io.*;
import java.util.LinkedList;

/**
 * 线程的抽象
 * @author 李正阳  17060208112
 */
public class WorkThread implements Serializable {

    String name;
    LinkedList<Resource> max = new LinkedList<>();
    LinkedList<Resource> allocation = new LinkedList<>();
    LinkedList<Resource> need = new LinkedList<>();
    boolean finish = false;

    public WorkThread(String name, LinkedList<Resource> max, LinkedList<Resource> allocation, LinkedList<Resource> need) {
        this.name = name;
        this.max = max;
        this.allocation = allocation;
        this.need = need;
    }

    public WorkThread() {
    }

    public WorkThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Resource> getMax() {
        return max;
    }

    public void setMax(LinkedList<Resource> max) {
        this.max = max;
    }

    public LinkedList<Resource> getAllocation() {
        return allocation;
    }

    public void setAllocation(LinkedList<Resource> allocation) {
        this.allocation = allocation;
    }

    public LinkedList<Resource> getNeed() {
        return need;
    }

    public void setNeed(LinkedList<Resource> need) {
        this.need = need;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }


    public Object deepClone() throws Exception{
        /**
         * 写入流
         */
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        /**
         * 读出流
         */
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }
}

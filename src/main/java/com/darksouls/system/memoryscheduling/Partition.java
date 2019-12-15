package com.darksouls.system.memoryscheduling;

/**
 * @author 李正阳  17060208112
 * 分区的抽象
 */
public class Partition {

    /**
     * @param name 区号
     * @param size 分区大小
     * @param start 起始地址
     */
    public int name;
    public int size;
    public int start;

    public Partition(int size, int start) {
        this.size = size;
        this.start = start;
    }

    public Partition() {
    }

    public Partition(int name, int size, int start) {
        this.name = name;
        this.size = size;
        this.start = start;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}

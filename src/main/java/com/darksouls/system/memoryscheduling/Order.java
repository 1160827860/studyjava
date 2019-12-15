package com.darksouls.system.memoryscheduling;

/**
 * @author 李正阳  17060208112
 * 对于用户输入指令的存储
 */
public class Order {
    /**
     * @param type 1为申请 2为释放
     * @param size 申请和释放内存的大小
     * @param id 作业的编号
     */
    int type;
    int size;
    int id;

    public Order( int id,int type,int size) {
        this.type = type;
        this.size = size;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order(int type, int size) {
        this.type = type;
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

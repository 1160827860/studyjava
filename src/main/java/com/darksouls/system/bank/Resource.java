package com.darksouls.system.bank;

import java.io.*;

/**
 * 资源抽象
 * @author 李正阳  17060208112
 */
public class Resource implements Serializable {
    String name;
    int count;
    @Override
    public Object clone(){
        Resource r = new Resource();
        r.setCount(count);
        r.setName(name);
        return r;
    }

    public Resource() {
    }

    public Resource(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

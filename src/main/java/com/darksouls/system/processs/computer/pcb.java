package com.darksouls.system.processs.computer;
/**
 * @author 李正阳 17060208112
 * 定义进程信息
 */
public class pcb {
    /**
     * @param name 进程的名字
     * @param arrive_time 到达时间
     * @param total_time 任务完成需要的时间
     * @param start_time 任务执行的时间
     * @param finish_time 完成任务的时间
     * @param into_time 进入内存时间
     * @param cycling _time 周转时间
     * @param authorized_turnaround_time 带权周转时间
     * @param  priority 优先级
     */
    public String name;
    public int arrive_time;
    public int total_time;
    public int start_time;
    public  int finish_time;
    public double cycling_time;
    public int into_time;
    public  double authorized_turnaround_time;
    public int priority;
    public int finish_level = 0;

    public double getAuthorized_turnaround_time() {
        return authorized_turnaround_time;
    }

    public void setAuthorized_turnaround_time(double authorized_turnaround_time) {
        this.authorized_turnaround_time = authorized_turnaround_time;
    }

    public int getInto_time() {
        return into_time;
    }

    public void setInto_time(int into_time) {
        this.into_time = into_time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getFinish_level() {
        return finish_level;
    }

    public void setFinish_level(int finish_level) {
        this.finish_level = finish_level;
    }

    public double getCycling_time() {
        return cycling_time;
    }

    public void setCycling_time(double cycling_time) {
        this.cycling_time = cycling_time;
    }

    @Override
    public String toString(){
        String res = "进程名" + name + " : 到达时间 ：" + arrive_time +
                " 估计运行时间 : " + total_time + "优先数 ：" + priority +
                "进入内存时间 ： " + into_time + "完成时间 : " + finish_time +
                "周转时间 : " + cycling_time + "带权周转时间 ： " +
                authorized_turnaround_time;
        return res;
    }

    public pcb(){}
    public pcb(String name, int arrive_time, int total_time, int priority) {
        this.name = name;
        this.arrive_time = arrive_time;
        this.total_time = total_time;
        this.priority = priority;
    }
    public pcb(String name, int arrive_time, int total_time) {
        this.name = name;
        this.arrive_time = arrive_time;
        this.total_time = total_time;
     
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(int arrive_time) {
        this.arrive_time = arrive_time;
    }

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(int finish_time) {
        this.finish_time = finish_time;
    }



    public void setCycling_time(int cycling_time) {
        this.cycling_time = cycling_time;
    }


    public void setAuthorized_turnaround_time(int authorized_turnaround_time) {
        this.authorized_turnaround_time = authorized_turnaround_time;
    }
}

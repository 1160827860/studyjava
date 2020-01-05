//package com.darksouls.system.processs;
//
//import com.system.processs.computer.cpu;
//import com.system.processs.computer.pcb;
//import com.system.processs.control.Util;
//
//import java.util.LinkedList;
//
//public class StartInArrive {
//	static LinkedList<pcb> res = new LinkedList<pcb>();
//	public static void start(){
//        LinkedList<pcb> external = Util.initProcess();
//        external = Util.initProcess();
//        finish(external);
//        Util.print(res);
//    }
//	private static void finish( LinkedList<pcb> p){
//		/**
//         * 作业还没有完全到达、作业没有全部做完、
//         */
//		while (p.size() != 0 || cpu.external.size() != 0 ||  cpu.queue.size() != 0) {
//
//			for (int i = 0; i < p.size(); i++) {
//	                pcb temp = p.get(i);
//	                /**
//	                 *模拟作业到达，进入等待队列
//	                 */
//	                if (temp.getArrive_time() == cpu.time) {
//	                    cpu.external.add(temp);
//	                    p.remove(temp);
//	                }
//	            }
//
//			  while (cpu.external.size() != 0){
//	                pcb temp = cpu.external.getFirst();
//	                /**
//	                 * 模拟作业进入内存（只有两个道）
//	                 */
//	                if (cpu.queue.size() < cpu.queue_length) {
//
//	                    /**
//	                     * 记录进入内存的时间
//	                     */
//	                    if (temp.getFinish_level() == 0) {
//	                        temp.setInto_time(cpu.time);
//	                    }
//	                    /**
//	                     * 进入内存的过程，并且删除外存中的进程
//	                     */
//	                    cpu.queue.add(temp);
//	                    cpu.external.remove(temp);
//	                }else {
//	                    break;
//	                }
//	            }
//			  pcb head = cpu.queue.getFirst();
//			  head.finish_level ++;
//			  cpu.time ++;
//			  if (head.getTotal_time() == head.getFinish_level()) {
//	                head.setFinish_time(cpu.time);
//	                head.setCycling_time(head.getFinish_time() - head.arrive_time);
//	                head.setAuthorized_turnaround_time(head.getCycling_time() / head.getTotal_time());
//	                res.add(cpu.queue.removeFirst());
//			  }
//		}
//
//
//	}
//
//}

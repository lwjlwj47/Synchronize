package Mythread;

import java.util.Random;

public class Mythread extends Thread{
     CDstore one;
     Mythread(CDstore one)
     {
    	 this.one=one;
     }
     public void run()
     {
    	 while(true)
    	 {
   	          one.Sell();
        	 Random random=new Random(); 
        	 int time=random.nextInt(200);
        	 try {
 				Mythread.sleep(time);
 			} catch (InterruptedException e) {
 				// TODO 自动生成的 catch 块
 				e.printStackTrace();
 			}
    	 }
    }
}

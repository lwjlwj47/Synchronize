package Mythread;

import java.util.Random;

public class Mythread2 extends Thread{
    CDstore one;
    Mythread2(CDstore one)
    {
    	this.one=one;
    }
    public void run()
    {
    	while(true)
    	{
    		Random random=new Random(); 
       	    int time1=random.nextInt(200);
       	 try {
 			Mythread2.sleep(time1);
 		} catch (InterruptedException e) {
 			// TODO �Զ����ɵ� catch ��
 			e.printStackTrace();
 		}
    	   int k=one.Rent();
   	    int time=random.nextInt(100)+200;
    	try {
			Mythread2.sleep(time);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	one.back(k);
       }
    } 
}

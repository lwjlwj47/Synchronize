package Mythread;

public class Mythread1 extends Thread{
     CDstore one;
     Mythread1(CDstore one)
     {
    	 this.one=one;
     }
     public void run()
     {
    	 while(true)
    	 {
    	 one.stack();
    	 //one.notify();
    	 try {
			Mythread1.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	 }
     }
}

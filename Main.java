package Mythread;

public class Main {

	public static void main(String[] args) {
		CDstore one=new CDstore();
		Mythread t1=new Mythread(one);
		Mythread t2=new Mythread(one);
		Mythread1 t4=new Mythread1(one);
		Mythread2 t3=new Mythread2(one);
		Mythread2 t5=new Mythread2(one);
		long startTime = System.currentTimeMillis(); 
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		long endTime = System.currentTimeMillis(); 
		while(endTime-startTime<=120000)
		{
			endTime = System.currentTimeMillis(); 
		}
		t1.yield();
		t2.yield();
		t3.yield();
		t4.yield();
		t5.yield();
		one.close();
	}

}

package Mythread;
import java.util.Random;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
public class CDstore {
	int[] rent;//租用CD
	int[] sell;//可售CD
	PrintStream ps;
	CDstore()
	{
		try {
			ps = new PrintStream("C:\\JAVA\\2.txt");
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.setOut(ps);
		rent=new int[10];
		sell=new int[10];
		for(int i=0;i<10;i++)
		{
			rent[i]=10;
			sell[i]=10;
		}
	}
	boolean lack()
	{
		for(int i=0;i<10;i++)
			if(sell[i]==0)
				return true;
		return false;
	}
	synchronized void stack()
	{
		for(int i=0;i<10;i++)
			sell[i]=10;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("进货时间："+formatter.format(date));
		notifyAll();
	}
	synchronized void Sell()
	{
		//while(true)
		//{
			Random random=new Random();
			//int time=random.nextInt(200);
			int number=random.nextInt(5);
			int kind=random.nextInt(10)+1;
			boolean want=random.nextBoolean();
			/*try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}*/
		     if(number>sell[kind-1])
		    	 if(want)
		    	 {
		    		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		    		Date date = new Date(System.currentTimeMillis());
		    		System.out.println("购买时间："+formatter.format(date)+"       购买类别："+kind+"            购买数量："+number+"            数量不足放弃");
		    	 }
		    	 else
		    		 {
		    		   try {
						wait();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
		    		    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			    		Date date = new Date(System.currentTimeMillis());
			    		System.out.println("购买时间："+formatter.format(date)+"       购买类别："+kind+"            购买数量："+number+"            成功");
			    		 sell[kind-1]-=number;
		    		 }
		     else
		    	 {
		    	 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		    		Date date = new Date(System.currentTimeMillis());
		    		System.out.println("购买时间："+formatter.format(date)+"       购买类别："+kind+"            购买数量："+number+"            成功");
		    	    sell[kind-1]-=number;
		    	 
		    	 }
		//}
	}
	synchronized int Rent()
	{
		Random random=new Random();
		int kind=random.nextInt(10)+1;
		boolean want=random.nextBoolean();
		/*try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
	     if(1>sell[kind-1])
	    	 if(want)
	    	 {
	    		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	    		Date date = new Date(System.currentTimeMillis());
	    		System.out.println("租用时间："+formatter.format(date)+"       租用类别："+kind+"           数量不足放弃");
	    	 }
	    	 else
	    		 {
	    		   try {
					wait();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	    		    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		    		Date date = new Date(System.currentTimeMillis());
		    		System.out.println("租用时间："+formatter.format(date)+"       租用类别："+kind+"            成功");
		    		 rent[kind-1]-=1;
	    		 }
	     else
	    	 {
	    	    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	    		Date date = new Date(System.currentTimeMillis());
	    		System.out.println("租用时间："+formatter.format(date)+"       租用类别："+kind+"            成功");
	    	    rent[kind-1]-=1;
	    	 
	    	 }
	     return kind;
	}
	synchronized void back(int i)
	{
		rent[i-1]+=1;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("归还时间："+formatter.format(date)+"       归还类别："+i+"            成功");
	}
	void close()
	{
		ps.close();
	}

}

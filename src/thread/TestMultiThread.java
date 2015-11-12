package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMultiThread implements Runnable {
    
    private static volatile int vi = 0;  
      
    private static AtomicInteger ai = new AtomicInteger();  
      
    private static Integer si = new Integer(0);  
      
    private static int ri;  
      
    private static AtomicInteger flag = new AtomicInteger();  
      
    private  Lock lock =null;  
      
    public TestMultiThread(Lock lock){
    	this.lock = lock;
    }
    @Override  
    public void run() {  
        for(int k=0;k<200000;k++){  
            vi++;  
            ai.incrementAndGet();  
            synchronized(this){  
                si++;  
            }  
            lock.lock();  
            try{  
                ri++;  
            }finally{  
                lock.unlock();  
            }  
              
        }  
        flag.incrementAndGet();  
    }  
      
    public static void main(String[] args) throws InterruptedException{  
    	Lock lock1= new ReentrantLock();
        TestMultiThread t1 = new TestMultiThread(lock1);  
        TestMultiThread t2 = new TestMultiThread(lock1);  
        ExecutorService exec1 = Executors.newCachedThreadPool();  
        exec1.execute(t1);  
        exec1.execute(t2);  
        while(true){  
            if(flag.intValue()==2){  
                System.out.println("vi>>>>>"+vi);  
                System.out.println("ai>>>>>"+ai);  
                System.out.println("si>>>>>"+si);      
                System.out.println("ri>>>>>"+ri);      
                break;  
            }  
            Thread.sleep(50);  
        }  
        /*
         * 结论：sychromized和lock只针对同一个对象，当对象不同的时候则不会生效
         */
          
    }  
}

package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThread implements Runnable{

	Logger logger = Logger.getGlobal();
	int time;
	boolean flag = true;
	
	public RunnableThread(int time) {
		this.time = time;
	}
	
	public RunnableThread() {
		
	}
	
	@Override
	public void run() {
//		logger.log(Level.INFO,"Thread name : "+Thread.currentThread().getName());
//		logger.log(Level.INFO,"Thread Priority :"+ Thread.currentThread().getPriority());
//		logger.log(Level.INFO,"Thread State 3 : "+Thread.currentThread().getState());
		
		while(flag) {
//			synchronized (RunnableThread.class) {
				try {
					logger.log(Level.INFO,"The Message Before delay : Going to Sleep"+Thread.currentThread().getName());
					Thread.sleep(time);
					logger.log(Level.INFO,"The Message after delay : "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			}
		}
		
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

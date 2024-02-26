package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendedThread extends Thread{
	
	int time;
	boolean flag = true;
	Logger logger = Logger.getGlobal();
	
	public ExtendedThread(int time) {
		this.time = time;
	}
	
	public ExtendedThread() {
	}
	
	@Override
	public void run() {
//			logger.log(Level.INFO,"Thread name : "+Thread.currentThread().getName());
//			logger.log(Level.INFO,"Thread Priority :"+ Thread.currentThread().getPriority());
//			logger.log(Level.INFO,"Thread State 3: "+Thread.currentThread().getState());
		
		while(flag) {
			try {
				logger.log(Level.INFO,"Theard Message Before Delay : Going to Sleep:\n"+ Thread.currentThread().getName());
				Thread.sleep(time);
				logger.log(Level.INFO,"Theard Message after Delay "+ Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}

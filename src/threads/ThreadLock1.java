package threads;

import java.util.logging.Logger;

public class ThreadLock1 extends Thread {
	Logger logger = Logger.getGlobal();
	Object obj1;
	Object obj2;
	
	public ThreadLock1(Object obj1,Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj1) {
			logger.info("ThreadLock1 add method obtained obj1");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (obj2) {
				logger.info("ThreadLock1 add method Obtained obj2");
			}
		}
	}
}

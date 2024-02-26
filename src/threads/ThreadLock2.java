package threads;

import java.util.logging.Logger;

public class ThreadLock2 extends Thread {
	Logger logger = Logger.getGlobal();
	Object obj1;
	Object obj2;
	
	public ThreadLock2(Object obj1,Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj2) {
			logger.info("ThreadLock2 add method obtained obj2");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (obj1) {
				logger.info("ThreadLock2 add method Obtained obj1");
			}
		}
	}
}

package runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import threads.ExtendedThread;
import threads.RunnableThread;
import threads.StoreDump;
import threads.ThreadLock1;
import threads.ThreadLock2;

public class ThreadRunner {
	static Logger logger = Logger.getGlobal();
	public static void main(String... args) throws InterruptedException {
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new  Scanner(System.in);
		int choice =0;
		do {
			try {
				threatOperation();
				choice = scanner.nextInt();
				switch(choice) {
					case 1:{
						Thread extendedThread = new ExtendedThread(5000);
						extendedThread.setName("ExtendedThread");
						logger.log(Level.INFO,"Thread name 1: "+extendedThread.getName());
						logger.log(Level.INFO,"Thread Priority 1:"+extendedThread.getPriority());
						logger.log(Level.INFO,"Thread State 1: "+extendedThread.getState());
						
						extendedThread.start();
						
						logger.log(Level.INFO,"Thread State 2: "+extendedThread.getState());
						logger.log(Level.INFO,"Thread name 2: "+extendedThread.getName());
						logger.log(Level.INFO,"Thread Priority 2:"+extendedThread.getPriority());
//						Thread.sleep(0);
						logger.log(Level.INFO,"Thread State 2: "+extendedThread.getState());
						logger.log(Level.INFO,"Thread State 2: "+extendedThread.getState());
						logger.log(Level.INFO,"Thread State 2: "+extendedThread.getState());
						break;
					}
					case 2:{
						Thread runnableThread = new Thread(new RunnableThread(3000));
						runnableThread.setName("RunnableThread");
						logger.log(Level.INFO,"Thread name : "+runnableThread.getName());
						logger.log(Level.INFO,"Thread Priority :"+ runnableThread.getPriority());
						logger.log(Level.INFO,"Thread State 1: "+runnableThread.getState());
						
						runnableThread.start();
						
						logger.log(Level.INFO,"Thread name : "+runnableThread.getName());
						logger.log(Level.INFO,"Thread Priority :"+ runnableThread.getPriority());
						logger.log(Level.INFO,"Thread State2 : "+runnableThread.getState());
						break;
					}
					case 3:{
						List<Thread> listOfExtendedThreads = new ArrayList<>();
						int ETime = 60000;
						int n=5;
						for(int i=0;i<n;i++) {
							listOfExtendedThreads.add(new ExtendedThread(ETime));
							listOfExtendedThreads.get(i).setName("ExtendedThread"+(i+1));
						}
						
						List<Thread> listOfRunnableThreads = new ArrayList<>();
						int Rtime = 45000;
						for(int i=0;i<n;i++) {
							listOfRunnableThreads.add(new Thread(new RunnableThread(Rtime)));
							listOfRunnableThreads.get(i).setName("RunnableThread"+(i+1));
						}
						
						for(int i=0;i<n;i++) {
							listOfExtendedThreads.get(i).start();
						}
						
						for(int i=0;i<n;i++) {
							listOfRunnableThreads.get(i).start();
						}
						break;
					}
					case 4:{
						RunnableThread runnableobj = new RunnableThread(1000);
						ExtendedThread extendedThread = new ExtendedThread(2000);
						StoreDump dumpThread = new StoreDump(1000);
						extendedThread.setName("ExtendedThread");
						Thread runnableThread = new Thread(runnableobj);
						runnableThread.setName("RunnableThread");
						
						extendedThread.start();
						dumpThread.start();
						runnableThread.start();
						
						Thread.sleep(60000);

						dumpThread.setFlag(false);
						extendedThread.setFlag(false);
						runnableobj.setFlag(false);
						
						try {
							dumpThread.appendDump();
						} catch (CustomException e) {
							e.printStackTrace();
						}
						
						logger.log(Level.WARNING,"Exited or toggled the thread");
						break;
					}
					case 5:{
						Object obj1 = new Object();
						Object obj2 = new Object();
						
						ThreadLock1 threadLock1 = new ThreadLock1(obj1, obj2);
						ThreadLock2 threadLock2 = new ThreadLock2(obj1, obj2);
						
						
						threadLock1.start();
						threadLock2.start();
						
						
						
						break;
					}
				}
			}
			catch(InputMismatchException e) {
				logger.log(Level.SEVERE,"Error Occured InputMisMatch : ",e);
			}
		}
		while(choice != 0);
		logger.log(Level.WARNING,"Exited Successfully");
		scanner.close();
	}
	
	static void threatOperation() {
		logger.log(Level.INFO,"==== Thread operations ====");
		logger.log(Level.INFO,"1. Create a class ExtendedThread extending Thread.\n"
				+"In its run method, print current thread details.\n"
				+"In the runner class, spawn a new thread using ExtendedThread,"
				+ "print thread details before and after calling start()\n");
		logger.log(Level.INFO,"2. Threads\n"
				+ "1. Write a class(ExtendedThread) which extends Thread. Inside the run methods print\n"
				+ "the current thread name, priority & its state. In the runner class Spawn a new thread\n"
				+ "using the ExtendedThread class. Print the current thread name, priority & its state in\n"
				+ "the runner class before & after calling the thread.start() method.\n"
				+ "2. Write a class (RunnableThread) which implements Runnable. Inside the run\n"
				+ "methods print the current thread name, priority & its state. In the runner class Spawn\n"
				+ "a new thread using the RunnableThread class.Print the current thread name, priority\n"
				+ "& its state in the runner class before & after calling the thread.start() method.\n");
		logger.log(Level.INFO,"3. In the run method of ExtendedThread, print a message “Going to Sleep:\n"
				+ "threadName. After that sleep for 60 secs. Then print After sleeping:\n"
				+ "threadName.In the run method of RunnableThread,print a message “Going to\n"
				+ "Sleep: “+threadName. After that sleep for45 secs. Then print After sleeping:\n"
				+ "threadName.From the runner class spawn 5 ExtendedThreads with your custom\n"
				+ "Thread name for each thread & 5 more RunnableThreads with your custom name for\n"
				+ "each Thread. Observe what happens by analysing the output prints.\n");
		logger.log(Level.INFO,"4. Toggle While case for breaking the runnable\n");
		logger.log(Level.INFO,"5. DeadLock Scenerio\n");
	}
}

package threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

import customException.CustomException;
import helper.BasicProgrammingHelper;

public class StoreDump extends Thread {

	static List<String> dumpListMain =  new ArrayList<>();
	BasicProgrammingHelper fileHelper = new BasicProgrammingHelper();
	boolean flag = true;
	int time;
	public StoreDump(int time) {
		this.time = time;
	}

	@SuppressWarnings("unused")
	@Override
	  public void run() {
		  while(flag) {
			  ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
			  	dumpListMain.add(Thread.getAllStackTraces().toString());
			    ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true,true);
			    for (ThreadInfo threadInfo : threadInfos) {
//			    	dumpListMain.add(threadInfo.toString());
//			    	dumpList.add("Thread name: " + threadInfo.getThreadName());
//			    	dumpList.add("Thread state: " + threadInfo.getThreadState());
//			    	dumpList.add("Thread stack trace: ");
//			      for (StackTraceElement stackTraceElement : threadInfo.getStackTrace()) {
//			    	  dumpList.add("  " + stackTraceElement);
//			      }
//				    System.out.println(threadInfo);

			    }
			    
			    try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  }
	  }
	
	public void appendDump() throws CustomException {
		
//		for(String a : dumpListMain) {
//			System.out.println(a);
//		}
//		
		fileHelper.createFile(dumpListMain, "dump.txt", "dumpedStackFolder");
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
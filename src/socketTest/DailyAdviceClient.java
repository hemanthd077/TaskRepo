package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
	
	
	public void go() {
		
		try (Socket s = new Socket("192.168.10.146",4242)) {
			InputStreamReader str = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(str);
			
			String advice = reader.readLine();
			System.out.print("Today you should:" + advice);
			
			reader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}

}
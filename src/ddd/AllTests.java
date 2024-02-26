package ddd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Test1.class})
public class AllTests {
	public static void main(String[] args) {
		Test1 obj = new Test1();  
		obj.test2();
	}
}

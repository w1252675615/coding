package Important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HelloThread extends Thread {

	String name;

	public HelloThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Hello, " + name + "!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Goodbye, " + name + "!");
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		List<Thread> threads = new ArrayList<>();
		for (String name : Arrays.asList("Bob", "Alice", "Tom")) {
			threads.add(new HelloThread(name));
		}
		System.out.println("START");
		threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
		threads.get(0).join();

		threads.get(1).join();

		threads.get(2).join();

		System.out.println("END");
	}
}

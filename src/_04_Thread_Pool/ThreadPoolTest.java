package _04_Thread_Pool;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

//1. Fill in the ThreadPool and Worker classes and the Task interface according to the Thread Pool UML Diagram.

public class ThreadPoolTest {

	@Test
	public void test() {
		int total = 1000000;
		
		ThreadPool tp = new ThreadPool(4);
		char[] chars = new char[total];
		
		for(int i = 0; i < total; i++){
			chars[i] = (char)(new Random().nextInt(25) + 97);
		}
				
		int count = (int) Math.sqrt(total);
		
		for(int i = 0; i < count; i++){
			int x = i * count;
			tp.addTask(()->{
				for(int j = 0; j < count; j++){
					chars[x + j] = Character.toUpperCase(chars[x + j]);
				}
			});
		}

		long start = System.currentTimeMillis();
		
		tp.start();
		
		long end = System.currentTimeMillis() - start;
		System.out.println("Total time: " + end);
		
		for(char c : chars){
			assertTrue(Character.isUpperCase(c));
		}	
	}
}

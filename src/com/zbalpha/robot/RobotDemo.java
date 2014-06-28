package com.zbalpha.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


/**模拟键盘操作**/
public class RobotDemo {

	//无参构造
	public RobotDemo(){
		
	}
	
	
	public static void pressKey(Robot r,int[] ks,int delay){
		for(int i=0;i<ks.length;i++){
			r.keyPress(ks[i]);
			r.delay(10);
			r.keyRelease(ks[i]);
			r.delay(delay);
		}
	}
	
	
	public static void main(String[] args) {
		final Robot rb;		
		try {
			rb = new Robot();
			
			new Thread(){
				public void run(){
					rb.delay(8000);
					for(int i=0;i<290;i++){
						rb.keyPress(KeyEvent.VK_CONTEXT_MENU);
						rb.keyRelease(KeyEvent.VK_CONTEXT_MENU);
						rb.delay(50);
						rb.keyPress(KeyEvent.VK_UP);
						rb.keyRelease(KeyEvent.VK_UP);
						rb.delay(50);
						rb.keyPress(KeyEvent.VK_UP);
						rb.keyRelease(KeyEvent.VK_UP);
						rb.delay(50);
						rb.keyPress(KeyEvent.VK_UP);
						rb.keyRelease(KeyEvent.VK_UP);
						rb.delay(50);					
						rb.keyPress(KeyEvent.VK_UP);
						rb.keyRelease(KeyEvent.VK_UP);
						rb.delay(50);					
						rb.keyPress(KeyEvent.VK_ENTER);
						rb.keyRelease(KeyEvent.VK_ENTER);
						rb.delay(50);					
						rb.keyPress(KeyEvent.VK_ENTER);
						rb.keyRelease(KeyEvent.VK_ENTER);
						rb.delay(50);					
					}
				}
			}.start();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}

}

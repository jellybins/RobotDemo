package com.jellybins.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

/**
 * 
 * 重复粘贴剪切板文字到光标所在窗口后发送 
 * @author Jelly
 * 
 */
public class RobotDemo implements HotkeyListener {

	/** 常用组合按键 */
	@SuppressWarnings("unused")
	private static final CombineKeys ctrlEnter = new CombineKeys(
			KeyEvent.VK_CONTROL, KeyEvent.VK_ENTER);// Ctrl+Enter

	@SuppressWarnings("unused")
	private static final CombineKeys altS = new CombineKeys(KeyEvent.VK_ALT,
			KeyEvent.VK_S);// ALT+S

	private static final CombineKeys ctrlV = new CombineKeys(
			KeyEvent.VK_CONTROL, KeyEvent.VK_V);// Ctrl+V

	/** 每 （keyDelay*5） 毫秒完成一次消息发送动作 */
	private static final int keyDelay = 20;//按键延迟

	private static boolean runFlag = false;//运行标志位
	
	private String repeatContent = "小娜抱抱";//刷屏内容

	public RobotDemo() {

		/** 注册热键 */
		JIntellitype.getInstance().registerHotKey(KeyEvent.VK_R,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, KeyEvent.VK_R);
		JIntellitype.getInstance().registerHotKey(KeyEvent.VK_S,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, KeyEvent.VK_S);
		JIntellitype.getInstance().registerHotKey(KeyEvent.VK_X,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, KeyEvent.VK_X);

		JIntellitype.getInstance().addHotKeyListener(this);
	}

	public static void main(String[] args) throws Exception {
		try {
			// 初始化
			new RobotDemo().init();
			Robot robot = new Robot();
			while (true) {
				while (runFlag) {
					pressCombineKeys(robot, ctrlV);
					pressKey(robot, KeyEvent.VK_ENTER);
				}
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	private void init(){
		/** 注册热键 */
		JIntellitype.getInstance().registerHotKey(KeyEvent.VK_R,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, KeyEvent.VK_R);
		JIntellitype.getInstance().registerHotKey(KeyEvent.VK_S,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, KeyEvent.VK_S);
		JIntellitype.getInstance().registerHotKey(KeyEvent.VK_X,
				JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, KeyEvent.VK_X);

		JIntellitype.getInstance().addHotKeyListener(this);
		
		/** 设置刷屏内容 */
		setSystemClipboard(this.repeatContent);
	}

	private static void pressKey(Robot robot, int keyvalue) {
		robot.delay(keyDelay);
		robot.keyPress(keyvalue);
		robot.delay(keyDelay);
		robot.keyRelease(keyvalue);
	}

	private static void pressCombineKeys(Robot robot, CombineKeys combineKeys) {
		robot.delay(keyDelay);
		robot.keyPress(combineKeys.getKey1());
		robot.delay(keyDelay);
		robot.keyPress(combineKeys.getKey2());
		robot.keyRelease(combineKeys.getKey2());
		robot.delay(keyDelay);
		robot.keyRelease(combineKeys.getKey1());
	}

	@Override
	public void onHotKey(int key) {
		switch (key) {
		case KeyEvent.VK_R:
			RobotDemo.runFlag = true;
			break;
		case KeyEvent.VK_S:
			RobotDemo.runFlag = false;
			break;
		case KeyEvent.VK_X:
			//停止运行后解除热键注册			
			RobotDemo.runFlag = false;
			this.destroy();
		}
	}

	/** 设置剪切板内容 */
	private static void setSystemClipboard(String refContent) {
		StringSelection ss = new StringSelection(refContent.trim());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}
	
	
	private void destroy() {
		JIntellitype.getInstance().unregisterHotKey(KeyEvent.VK_R);
		JIntellitype.getInstance().unregisterHotKey(KeyEvent.VK_S);
		JIntellitype.getInstance().unregisterHotKey(KeyEvent.VK_X);
		System.exit(0);
	}
	
}

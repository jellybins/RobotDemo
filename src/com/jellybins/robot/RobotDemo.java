package com.jellybins.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

/**
 * 
 * 重复粘贴剪切板文字到光标�?��窗口后发�? * @author Jelly
 * 
 */
public class RobotDemo implements HotkeyListener {

	/** 常用组合按键 */
	public static final CombineKeys ctrlEnter = new CombineKeys(
			KeyEvent.VK_CONTROL, KeyEvent.VK_ENTER);// Ctrl+Enter

	public static final CombineKeys altS = new CombineKeys(KeyEvent.VK_ALT,
			KeyEvent.VK_S);// ALT+S

	public static final CombineKeys ctrlV = new CombineKeys(
			KeyEvent.VK_CONTROL, KeyEvent.VK_V);// Ctrl+V

	//按键延迟
	public static final int keyDelay = 1 * 100;// 毫秒

	public static boolean runFlag = false;

	public RobotDemo() {

		// 注册热键
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

			RobotDemo rbDemo = new RobotDemo();

			Robot robot = new Robot();

			while (true) {

				while (runFlag) {
					rbDemo.pressCombineKeys(robot, ctrlV);
					rbDemo.pressKey(robot, KeyEvent.VK_ENTER);
				}

			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void pressKey(Robot robot, int keyvalue) {
		robot.keyPress(keyvalue);
		robot.keyRelease(keyvalue);
		robot.delay(keyDelay);
	}

	public static void pressCombineKeys(Robot robot, CombineKeys combineKeys) {
		robot.keyPress(combineKeys.getKey1());
		robot.keyPress(combineKeys.getKey2());
		robot.keyRelease(combineKeys.getKey2());
		robot.keyRelease(combineKeys.getKey2());
		robot.delay(keyDelay);
	}

	@Override
	public void onHotKey(int key) {
		switch (key) {
		case KeyEvent.VK_R:
			this.runFlag = true;
			break;
		case KeyEvent.VK_S:
			this.runFlag = false;
			break;
		case KeyEvent.VK_X:
			//停止运行后销毁			
			this.runFlag = false;
			this.destroy();
		}
	}

	void destroy() {
		JIntellitype.getInstance().unregisterHotKey(KeyEvent.VK_R);
		JIntellitype.getInstance().unregisterHotKey(KeyEvent.VK_S);
		JIntellitype.getInstance().unregisterHotKey(KeyEvent.VK_X);
		System.exit(0);
	}

}

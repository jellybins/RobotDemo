package com.jellybins.robot;

/**
 * 
 * 组合热键
 * @author Jelly
 *
 */
public class CombineKeys {
	
	/** 热键1 */
	private int key1;
	/** 热键2 */
	private int key2;
	
	/**
	 * 无参构造
	 */
	public CombineKeys(){}
	
	public CombineKeys(int key1, int key2){
		this.key1 = key1;
		this.key2 = key2;
	}

	public int getKey1() {
		return key1;
	}

	public void setKey1(int key1) {
		this.key1 = key1;
	}

	public int getKey2() {
		return key2;
	}

	public void setKey2(int key2) {
		this.key2 = key2;
	}
	
	
	
}

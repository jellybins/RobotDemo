package com.jellybins.robot;

/**
 * 
 * ��ϰ���
 * @author Jelly
 *
 */
public class CombineKeys {
	
	/** ��ϼ�1 */
	private int key1;
	/** ��ϼ�2 */
	private int key2;
	
	/**
	 * �޲ι���
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

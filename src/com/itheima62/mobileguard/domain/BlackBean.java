package com.itheima62.mobileguard.domain;

/**
 * @author Administrator
 * ���������ݵķ�װ��
 */
public class BlackBean {
	private String phone;
	private int mode;
	@Override
	public String toString() {
		return "[phone=" + phone + ", mode=" + mode + "]";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
}

package com.itheima62.mobileguard.unittest;

import com.itheima62.mobileguard.engine.ReadContantsEngine;
import com.itheima62.mobileguard.utils.ServiceUtils;

import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {
	public void testReadContants(){
		ReadContantsEngine.readContants(getContext());//��ȡ�����������
	}
	
	public void testRunningService(){
		ServiceUtils.isServiceRunning(getContext(), "");
	}
}

package com.itheima62.mobileguard.activities;

import com.itheima62.mobileguard.R;
import com.itheima62.mobileguard.utils.MyConstants;
import com.itheima62.mobileguard.utils.SpTools;
import com.itheima62.mobileguard.view.SettingCenterItemView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SettingCenterActivity extends Activity {
	private SettingCenterItemView sciv_autoupdata;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		initView();//初始化界面
		initEvent();//初始化组件的事件
	}

	private void initEvent(){
		sciv_autoupdata.setItemClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//原来的复选框的功能不变，可以添加自己新的功能
				//功能扩展
				sciv_autoupdata.setChecked(!sciv_autoupdata.isClickable());
				//记录复选框的状态
				SpTools.putBoolean(getApplicationContext(), MyConstants.AUTOUPDATA, sciv_autoupdata.isChecked());
				
			}
		});
		
	}

	private void initView() {
		setContentView(R.layout.activity_settingcenter);
		//获取自动更新的自定义控件
 		sciv_autoupdata = (SettingCenterItemView) findViewById(R.id.sciv_setting_center_autoupdata);
	}
}

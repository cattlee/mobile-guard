package com.itheima62.mobileguard.engine;

import java.util.ArrayList;
import java.util.List;

import com.itheima62.mobileguard.domain.ContantBean;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * @author Administrator
 * ��ȡ�ֻ���ϵ�˵Ĺ�����
 */
public class ReadContantsEngine {
	/**
	 * ��ȡ�ֻ���ϵ��
	 */
	public static List<ContantBean> readContants(Context context){
		List<ContantBean> datas = new ArrayList<ContantBean>();
		Uri uriContants = Uri.parse("content://com.android.contacts/contacts");
		Uri uriDatas = Uri.parse("content://com.android.contacts/data");
		
		Cursor cursor = context.getContentResolver().query(uriContants, new String[]{"_id"}, null, null, null);
		//ѭ��ȡ���� 
		while(cursor.moveToNext()){
			//������Ϣ�ķ�װbean
			ContantBean bean = new ContantBean();
			//ֱ�Ӵ�ӡid
			String id = cursor.getString(0);//��ȡ����ϵ�˵�id
			
			Cursor cursor2 = context.getContentResolver().query(uriDatas,new String[]{"data1","mimetype"}, " raw_contact_id = ? ", new String[]{id}, null);
			
			//ѭ��ÿ��������Ϣ����һ�����ѵ�һ������Ϣ
			while(cursor2.moveToNext()) {
				String data  = cursor2.getString(0);
				String mimeType = cursor2.getString(1);
				

				if (mimeType.equals("vnd.android.cursor.item/name")) {
					System.out.println("��" +id + "���û������֣�" + data);
					bean.setName(data);
				} else if (mimeType.equals("vnd.android.cursor.item/phone_v2")) {
					System.out.println("��" +id + "���û����绰��" + data);
					bean.setPhone(data);
				}
			}
			cursor2.close();//�ر��α��ͷ���Դ
			datas.add(bean);//��һ��������Ϣ
		}
		cursor.close();
		return datas;
	}
}
package com.itheima62.mobileguard.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itheima62.mobileguard.db.BlackDB;
import com.itheima62.mobileguard.domain.BlackBean;
import com.itheima62.mobileguard.domain.BlackTable;

/**
 * @author Administrator
 * ���������ݵ�ҵ���װ��
 */
public class BlackDao {
	private BlackDB blackDB;
	
	public BlackDao(Context context){
		this.blackDB = new BlackDB(context);
	}
	
	
	
	/**
	 * @return
	 *   �������еĺ���������
	 */
	public List<BlackBean> getAllDatas(){
		List<BlackBean> datas = new ArrayList<BlackBean>();
		SQLiteDatabase database = blackDB.getReadableDatabase();
		//��ȡblacktb�����������α�
		Cursor cursor = database.rawQuery("select " + BlackTable.PHONE + ","
		+ BlackTable.MODE + " from " + BlackTable.BLACKTABLE, null);
		
		while (cursor.moveToNext()) {
			//�����ݣ����ݷ�װ
			BlackBean bean = new BlackBean();
			
			//��װ����������
			bean.setPhone(cursor.getString(0));
			
			//��װ����ģʽ
			bean.setMode(cursor.getInt(1));
			
			//������ݵ�������
			datas.add(bean);
		}
		
		cursor.close();//�ر��α�
		database.close();//�ر����ݿ�
		
		return datas;
	}
	
	
	/**
	 * ɾ������������
	 * @param phone
	 *    Ҫɾ���ĺ���������
	 */
	public void delete(String phone){
		SQLiteDatabase db = this.blackDB.getWritableDatabase();
		//���ݺ��������룬��ɾ������������
		db.delete(BlackTable.BLACKTABLE, BlackTable.PHONE + "=?", new String[]{phone});
		db.close();
	}
	
	/**
	 * @param phone
	 *    �޸ĵĺ���������
	 * @param mode
	 *    �޸ĵ��µ�����ģʽ
	 */
	public void update(String phone,int mode){
		SQLiteDatabase db = this.blackDB.getWritableDatabase();
		
		ContentValues values = new ContentValues();//�޸��µ�����ֵ
		//�����µ�����ģʽ
		values.put(BlackTable.MODE, mode);
		
		//���ݺ�������µ�ģʽ
		db.update(BlackTable.BLACKTABLE, values , BlackTable.PHONE + "=?", new String[]{phone});
		
		db.close();//�ر����ݿ�
		
	}
	
	/**
	 * ��Ӻ���������
	 * @param bean
	 *     ��������Ϣ�ķ�װbean
	 */
	public void add(BlackBean bean){
		add(bean.getPhone(),bean.getMode());
	}
	
	/**
	 * ��Ӻ���������
	 * @param phone
	 *     ����������
	 * @param mode
	 *    ����ģʽ
	 */
	public void add(String phone,int mode){
		//��ȡ���������ݿ�
		SQLiteDatabase db = blackDB.getWritableDatabase();
		ContentValues values = new ContentValues();
		//���ú���������
		values.put(BlackTable.PHONE, phone);
		
		//���ú���������ģʽ
		values.put(BlackTable.MODE, mode);
		
		//�����������в���һ����¼
		db.insert(BlackTable.BLACKTABLE, null, values );
		
		//�ر����ݿ�
		db.close();
	}
}

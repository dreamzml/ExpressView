package com.example.expressview.json;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import android.graphics.Paint.Join;
import android.util.Log;

public class jsonTool {

	public jsonTool() {
		// ���캯��
	}

	public static String JoinJson(String sepatator, String jsonString) {
		try {
			JSONObject object = new JSONObject(jsonString);
			JSONArray expressList = object.getJSONArray("express");//��ȡJSONArray  
            int length = expressList.length();  
            
            String aa = "";  
            for(int i = 0; i < length; i++){//����JSONArray  
                Log.d("debugTest",Integer.toString(i));  
                JSONObject oj = expressList.getJSONObject(i);  
                aa = aa + oj.getString("time")+"\n"+oj.getString("address")+"\n\n";  
            } 
            if(aa=="")
            	aa = "�޲�ѯ���";
			return aa;
		} catch (Exception e) {
			// �����쳣
			Log.e("JsonTool", e.toString());
		}
		return  "�޲�ѯ���";
	}


	/*
	 * public static Person getPerson(String key,String jsonString){ Person
	 * pseson = new Person(); try{ JSONObject jsonObject =
	 * JSONObject(jsonString); JSONObject personObject =
	 * jsonObject.getJSONObject("person");
	 * 
	 * } catch (Exception e) { //�����쳣 } }
	 */
}

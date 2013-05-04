package com.example.expressview.json;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import android.graphics.Paint.Join;
import android.util.Log;

public class jsonTool {

	public jsonTool() {
		// 构造函数
	}

	public static String JoinJson(String sepatator, String jsonString) {
		try {
			JSONObject object = new JSONObject(jsonString);
			JSONArray expressList = object.getJSONArray("express");//获取JSONArray  
            int length = expressList.length();  
            
            String aa = "";  
            for(int i = 0; i < length; i++){//遍历JSONArray  
                Log.d("debugTest",Integer.toString(i));  
                JSONObject oj = expressList.getJSONObject(i);  
                aa = aa + oj.getString("time")+"\n"+oj.getString("address")+"\n\n";  
            } 
            if(aa=="")
            	aa = "无查询结果";
			return aa;
		} catch (Exception e) {
			// 捕获异常
			Log.e("JsonTool", e.toString());
		}
		return  "无查询结果";
	}


	/*
	 * public static Person getPerson(String key,String jsonString){ Person
	 * pseson = new Person(); try{ JSONObject jsonObject =
	 * JSONObject(jsonString); JSONObject personObject =
	 * jsonObject.getJSONObject("person");
	 * 
	 * } catch (Exception e) { //捕获异常 } }
	 */
}

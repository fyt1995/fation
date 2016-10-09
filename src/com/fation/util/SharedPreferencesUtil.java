package com.fation.util;

import java.util.Map;

import com.fation.FationApplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/** 
 * @author  Arvin: 
 * @version 2016年5月27日 下午1:07:42 
 * 
 */
public class SharedPreferencesUtil {
	/**
	 * 基于SharePreferences保存数据
	 * @param mContext
	 * @param arg0
	 * @param maps
	 */
	public static void saveSharePreferences(Context mContext, String arg0, Map<String, Object> maps) {
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		Editor mEditor = share.edit();
	        
        for (String key : maps.keySet()) {  
        	Object value = maps.get(key);  
        	
        	if (value instanceof String){
        		mEditor.putString(key, value.toString());
        	} else if (value instanceof Integer){
        		mEditor.putInt(key, ((Integer) value).intValue());
        	} else if (value instanceof Boolean){
        		mEditor.putBoolean(key, ((Boolean) value).booleanValue());
        	} else if (value instanceof Boolean){
        		mEditor.putLong(key, Long.parseLong((String) value));
        	}
        }
        
        mEditor.commit();
        share = null;
    }
	
	public static void saveSharePreference(String arg0, String key, String val) {
		saveSharePreference(FationApplication.mInstance.getBaseContext(), arg0, key, val);
	}
	
	public static void saveSharePreference(Context mContext, String arg0, String key, String val) {
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		Editor mEditor = share.edit();
	        
		mEditor.putString(key, val);
        
        mEditor.commit();
        share = null;
    }
	
	/**
	 * 基于SharePreferences，根据key获取对应的值
	 * @param mContext
	 * @param arg0
	 * @param key
	 * @return
	 */
	public static String getSharePreferencesByKey(Context mContext, String arg0, String key){
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		String val = share.getString(key, "");
		
		return val;
	}
	
	/**
	 * 基于SharePreferences，根据key获取对应的值
	 * @param mContext
	 * @param arg0
	 * @param key
	 * @return
	 */
	public static boolean getSharePreferencesByKeyForBoolean(Context mContext, String arg0, String key){
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		boolean val = share.getBoolean(key, false);
		
		return val;
	}
}

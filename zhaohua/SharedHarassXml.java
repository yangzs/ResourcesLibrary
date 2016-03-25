package com.zc.jxcrtech.android.utils.storage;

import android.content.Context;

/**
 * 骚扰拦截XML文件名
 * @author damon
 */
public class SharedHarassXml extends SharedPreferencesUtil {

	/**
	 * 定义骚扰拦截XML文件名
	 */
	public SharedHarassXml( ) {
		super( "ZC_USER_HARASS" );
	}
	
	/**
	 * 定义局部处理
	 * @param context
	 * @param type
	 * @return
	 */
	public boolean putData( Context context, Type type ){
		return putData( context, type.getKey(), type.getDefult() );
	}
	
	/**
	 * 
	 * @param fileName
	 * @param context
	 * @param type
	 * @return
	 */
	public Object getData( Context context, Type type ){
		return getData( context, type.getKey(), type.getDefult() );
	}
	
	/**
	 * 定义骚扰拦截数据存储KEY
	 * @author damon
	 */
	public enum Type{

		/** 骚扰拦截开关 */
		USER_HARASS_SWITCH( "harass_switch", "1" ),
		USER_HARASS_LANJIE( "harass_lanjie", true ),
		USER_HARASS_CALL( "harass_call", true ),
		USER_HARASS_NOTIFICATION( "harass_notification", true ),
		USER_HARASS_MODE( "harass_mode", 1 ),
		USER_HARASS_RETURNSOUND( "harass_retursond", 0 ),
		USER_HARASS_MXP( "harass_mxp", 0 ),
		USER_HARASS_NUM( "harass_num", 0 ),
		;
		Type( String key, Object defult ){
			this.key = key;
			this.defult = defult;
		}
		
		String key;
		
		Object defult;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getDefult() {
			return defult;
		}

		public void setDefult(Object defult) {
			this.defult = defult;
		}
	}
}

package com.zc.jxcrtech.android.utils.storage;

import java.util.Map;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * XML数据存储
 * @author damon
 */
public abstract class SharedPreferencesUtil {

	/** 个人骚扰拦截设置 */
	private String XML_FILE_NAME = "ZC_USER_HARASS";
	
	public SharedPreferencesUtil( String name ){
		this.XML_FILE_NAME = name;
	}
	
	/**
	 * 设置存储
	 * @param file
	 * @param context
	 * @param keys
	 * @param object
	 * @return
	 */
	public boolean putData( Context context, String keys, Object object ){
		return put( XML_FILE_NAME, context, keys, object );
	}
	
	/**
	 * 获取设置数据
	 * @param file
	 * @param context
	 * @param keys
	 * @param defValue 默认值
	 * @return
	 */
	public Object getData( Context context, String keys, Object defValue ){
		return get( XML_FILE_NAME, context, keys, defValue );
	}
	
	/**
	 * 获取设置数据
	 * @param file
	 * @param context
	 * @param keys
	 * @return
	 */
	public Object getData( Context context, String keys ){
		return get( XML_FILE_NAME, context, keys );
	}
	
	/**
	 * 清除数据存储文件
	 * @param file
	 * @param context
	 * @return
	 */
	public boolean cleanData( Context context ){
		return clear( XML_FILE_NAME, context );
	}
	
	/**
	 * 删除数据中单项数据
	 * @param file
	 * @param context
	 * @param keys
	 * @return
	 */
	public boolean removeDate( Context context, String keys ){
		return remove( XML_FILE_NAME, context, keys );
	}
	
	/**
	 * 根据文件获取当前设置全部数据
	 * @param file
	 * @param context
	 * @return
	 */
	public Map<String, ?> getAllData( Context context ){
		return getAll( XML_FILE_NAME, context );
	}
	
	
	
	/**
	 * 同步写数据至XML
	 * @param fileName
	 * @param context
	 * @param keys
	 * @param object
	 * @return
	 */
	private boolean put( String fileName, Context context, String keys, Object object ){
		if( object == null ){
			return false;
		}
		final SharedPreferences sp = context.getSharedPreferences( fileName, Context.MODE_PRIVATE );  
		final SharedPreferences.Editor editor = sp.edit();
		if( object instanceof String ){
			editor.putString( keys, String.valueOf( object ) );
		} else if( object instanceof Integer ){
			editor.putInt( keys, (Integer)object );
		} else if( object instanceof Float ){
			editor.putFloat( keys, (Float)object );
		} else if( object instanceof Boolean ){
			editor.putBoolean( keys, (Boolean)object );
		} else if( object instanceof Long ){
			editor.putLong( keys, (Long)object );
		} else {
			editor.putString( keys, String.valueOf( object ) );
		}
		return editor.commit();
	}
	
	/**
	 * 根据KEY获取数据
	 * @param fileName
	 * @param context
	 * @param keys
	 * @param defValue
	 * @return
	 */
	private Object get( String fileName, Context context, String keys, Object defValue ){
		final SharedPreferences sp = context.getSharedPreferences( fileName, Context.MODE_PRIVATE );
		if( defValue instanceof String ){
			return sp.getString( keys, String.valueOf( defValue ) );
		} else if( defValue instanceof Integer ){
			return sp.getInt( keys, (Integer)defValue );
		} else if( defValue instanceof Float ){
			return sp.getFloat( keys, (Float)defValue );
		} else if( defValue instanceof Boolean ){
			return sp.getBoolean( keys, (Boolean)defValue );
		} else if( defValue instanceof Long ){
			return sp.getLong( keys, (Long)defValue );
		}
		return null;
	}
	
	/**
	 * 根据KEY获取数据
	 * @param fileName
	 * @param context
	 * @param keys
	 * @return Object
	 */
	private Object get( String fileName, Context context, String keys ){
		final SharedPreferences sp = context.getSharedPreferences( fileName, Context.MODE_PRIVATE );
		return sp.getString( keys, null );
	}
	
	/**
	 * 删除单个键值数据
	 * @param fileName
	 * @param context
	 * @param keys
	 * @return
	 */
	private boolean remove( String fileName, Context context, String keys ){  
        final SharedPreferences sp = context.getSharedPreferences( fileName, Context.MODE_PRIVATE);  
        final SharedPreferences.Editor editor = sp.edit();  
        editor.remove( keys );
        return editor.commit();
    }
	
	/**
	 * 清除某文件所有数据
	 * @param fileName
	 * @param context
	 * @return
	 */
	private boolean clear( String fileName, Context context ) {
        final SharedPreferences sp = context.getSharedPreferences( fileName, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }
	
	/**
	 * 返回（fileName）该文件所有的键值对
	 * @param fileName
	 * @param context
	 * @return
	 */
	public Map<String, ?> getAll( String fileName, Context context ){
		final SharedPreferences sp = context.getSharedPreferences( fileName, Context.MODE_PRIVATE );
		return sp.getAll();
	}
}

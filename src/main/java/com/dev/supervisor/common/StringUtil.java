package com.dev.supervisor.common;

import java.util.HashMap;

public class StringUtil {
	/**
	 * HashMap Key Trans String or defaultStr
	 * @param input
	 * @param key
	 * @param defaultStr
	 * @return
	 */
	public String getString(HashMap<String, Object> input, String key, String defaultStr){
		String result = "";
		if(input != null && !input.isEmpty() && input.containsKey(key)){
			result = input.get(key).toString();
		}else{
			result = defaultStr;
		}

		return result;
	}
	
	/**
	 * HashMap Key Trans String or ""
	 * @param input
	 * @param key
	 * @return
	 */
	public String getString(HashMap<String, Object> input, String key){
		String result = "";
		if(input != null && !input.isEmpty() && input.containsKey(key)){
			result = input.get(key).toString();
		}else{
			result = "";
		}

		return result;
	}
}

package com.qa.util;

import java.util.HashMap;
import java.util.Map;

public class ParameterMap {
	String Key;
	String Value;

	static Map<String, String> map = new HashMap<String, String>();

	public static Map<String, String> getParameter() {
		
		map.put("q", "London");
		map.put("appid", "673c5650a20311041c26d61291b186ae");
		return map;

	}

	// key and value from map

	public String getKey() {
		for (Map.Entry<String, String> mapobj : map.entrySet()) {
			Key = mapobj.getKey();
		}
		return Key;
	}

	public String getValue() {
		for (Map.Entry<String, String> mapobj : map.entrySet()) {
			Value = mapobj.getValue();
		}
		return Value;
	}

}

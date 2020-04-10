package com.Servlet;


import org.json.JSONException;
import org.json.JSONObject;

public class JsonTools {
public static String  createJsonString(String key,Object value) throws JSONException{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
		}
}

package com.cn.hnust.util;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class JsonUtil {

	private static Gson gson = new Gson();

	/**
	 * @MethodName : toJson
	 * @Description : ������תΪJSON�����˷����ܹ�����󲿷�����
	 * @param src
	 *            :��Ҫ��ת���Ķ���
	 * @return :ת�����JSON��
	 */
	public static String toJson(Object src) {
		if (src == null) {
			return gson.toJson(JsonNull.INSTANCE);
		}
		return gson.toJson(src);
	}
}
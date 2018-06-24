package com.asdi.hris.util;

import java.io.StringWriter;

import com.asdi.hris.exception.JSONToStringException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONUtil {

	public static String toJSONString(Object obj) throws JSONToStringException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter json = new StringWriter();
		try {
			objectMapper.writeValue(json, obj);
		} catch (Exception e) {
			throw new JSONToStringException("Error : " + e);
		}
		System.out.println("RESPONSE : " + json.toString());

		return json.toString();
	}
}

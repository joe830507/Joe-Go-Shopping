package com.lin.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class BeanUtil {

	private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	public static <T> T copyPropertiesWithoutNull(T source, T target) {
		Field[] fields = source.getClass().getDeclaredFields();
		List<String> ignoredList = new ArrayList<>();
		for (int i = 0; i < fields.length; i++) {
			Field singleField = fields[i];
			singleField.setAccessible(true);
			try {
				if (singleField.get(source) == null) {
					String fieldName = singleField.getName();
					ignoredList.add(fieldName);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				logger.error("error occurs when copying properties ", e);
			}
		}
		BeanUtils.copyProperties(source, target, ignoredList.toArray(new String[ignoredList.size()]));
		return target;
	}
}

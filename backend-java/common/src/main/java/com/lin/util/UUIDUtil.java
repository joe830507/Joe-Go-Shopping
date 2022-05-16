package com.lin.util;

import java.util.UUID;

public class UUIDUtil {

	public static String getIdWithoutDashes() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}

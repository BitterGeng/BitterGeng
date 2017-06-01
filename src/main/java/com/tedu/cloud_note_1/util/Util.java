package com.tedu.cloud_note_1.util;

import java.util.UUID;

public class Util {
	public static String createId(){
		UUID uuId = UUID.randomUUID();
		String id = uuId.toString();
		return id;
	}
	
	public static void main(String[] args) {
		String id = createId();
		System.out.println(id);
	}
}

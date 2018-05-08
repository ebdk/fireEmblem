package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

public class Messages {
	
	static List<String> messages = new ArrayList<String>();

	private Messages() {
	}

	public static List<String> getMessages() {
		return messages;
	}
	public static void addMessage(String message) {
		messages.add(message);
	}
	public static void empty() {
		messages.clear();
	}
	
	public static String getMessage0() {
		return messages.get(0);
	}
	public static String getMessage1() {
		return messages.get(1);
	}
	public static String getMessage2() {
		return messages.get(2);
	}
	public static String getMessage3() {
		return messages.get(3);
	}
	

}

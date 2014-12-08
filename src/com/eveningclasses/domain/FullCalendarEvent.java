package com.eveningclasses.domain;

public class FullCalendarEvent {
	private String title;
	private String start;
	private String end;
	private boolean allDay;
	private String backgroundColor;
	
	public FullCalendarEvent(String title, String start, String end, boolean allDay, String backgroundColor) {
		this.title = title;
		this.start = start;
		this.end = end;
		this.allDay = allDay;
		this.backgroundColor = backgroundColor;
	}
}
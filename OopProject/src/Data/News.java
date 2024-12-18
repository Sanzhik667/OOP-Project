package Data;

import java.io.Serializable;

import time.LocalTime

public class News() implements Serializable{
	
	private static final long serialVersionUID = -3687448572749462892L;
	
	private String title;
	private String content;
	private LocalTime timestamp;
	
	public News(String title, String content, LocalDateTime timestamp) {
		this.title = title;
		this.content = content;
		this.timestamp = LocalTime.now();
	}
	
	@Override
	public String toString() {
		return "[" + timestamp + "]" + title + "\n" + content;
	}
	
	//
}
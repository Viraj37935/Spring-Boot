package com.Project.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResDTO {
	
	private Long id;
    private String content;
    private LocalDateTime timestamp;
    
	public MessageResDTO(Long id, String content, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.content = content;
		this.timestamp = timestamp;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
    
}

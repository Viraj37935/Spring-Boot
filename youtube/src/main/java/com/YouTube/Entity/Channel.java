package com.YouTube.Entity;

//import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelid;

	private String channelName;

	@Size(min = 6, max = 8, message = "Please Insert 6 Characters Password!")
	private String password;

	@OneToOne()
	@JoinColumn(name = "creator_id")
	private Creator creator;
	

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public int getChannelid() {
		return channelid;
	}

	public void setChannelid(int channelid) {
		this.channelid = channelid;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

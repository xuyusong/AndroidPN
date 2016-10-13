package org.androidpn.server.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.io.filefilter.FalseFileFilter;
/**
 * 离线消息推送
 * @author xuyusong
 *
 */
@Entity
@Table(name = "apn_notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	@Column(name ="uuid",length=64 ,nullable = false ,unique = true)
	private String uuid;
	
	@Column(name = "api_key",length = 64)
	private String apiKey;
	//一个用户可以拥有多条离线消息
	@Column(name = "user_name",nullable = false, length = 64)
	private String username;
	
	@Column(name = "title",nullable = false, length = 64)
	private String title;
	
	@Column(name = "message", nullable = false,length = 1000)
	private String message;
	
	@Column(name = "uri", length = 256)
	private String uri;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}

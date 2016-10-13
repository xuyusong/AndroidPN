package org.androidpn.server.dao;

import java.util.List;

import org.androidpn.server.model.Notification;


public interface NotificationDao {
	public void saveNotification(Notification notification);
	
	public List<Notification> findNotificationsByUsername(String username);
	
	public void deleteNotification(Notification notification);
	
	public void deleteNotificationByUuid(String UUID);
}

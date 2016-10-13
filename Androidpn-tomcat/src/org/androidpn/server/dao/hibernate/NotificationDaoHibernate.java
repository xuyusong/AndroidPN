package org.androidpn.server.dao.hibernate;

import java.util.List;

import org.androidpn.server.dao.NotificationDao;
import org.androidpn.server.model.Notification;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class NotificationDaoHibernate extends HibernateDaoSupport implements NotificationDao {

	public void saveNotification(Notification notification) {
		getHibernateTemplate().saveOrUpdate(notification);
		getHibernateTemplate().flush();
	}

	public List<Notification> findNotificationsByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<Notification> list = getHibernateTemplate().find("from Notification where username=?",username);
		if(list!=null&&list.size()>0){
			return list;
		}else {
			return null;
		}
	}
	
	public void deleteNotification(Notification notification) {
		getHibernateTemplate().delete(notification);
	}

	public void deleteNotificationByUuid(String UUID) {
		List<Notification> list = getHibernateTemplate().find("from Notification where uuid=?",UUID);
		if(list!=null&&list.size()>0){
			getHibernateTemplate().delete(list.get(0));
		}
	}

}

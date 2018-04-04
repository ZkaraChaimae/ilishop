package util;

import org.hibernate.Session;

// Singleton pattern :
public class SessionClass {
	private static Session session = HibernateUtil.getSession();
	
	public static Session getSession()	{
		if (session != null || session.isOpen()) {
	        return session;
	    } else {
	        session = HibernateUtil.getSession();
	        return session;
	    }
	}
}

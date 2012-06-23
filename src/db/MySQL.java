package db;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author thorsten
 */
public class MySQL {
	private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public static Session getSession() {
		return session;
	}
	
	public static synchronized Object execute(String query, int... maxResults) {
		session.beginTransaction();
		Query q = session.createQuery(query);
		if(maxResults.length > 0) q.setMaxResults(maxResults[0]);
		session.getTransaction().commit();

		if(q.list().size() > 0) {
			return (q.list().size() > 1) ? q.list() : q.list().get(0);
		} else {
			return null;
		}
	}
}

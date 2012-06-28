package db;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * MySQL helper class to easily manage the HQL-Queries
 * 
 * @author thorsten
 */
public class MySQL {
	private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	/**
	 * Retrieve the current database session object
	 * 
	 * @return Session
	 */
	public static Session getSession() {
		return session;
	}
	
	/**
	 * Executes a HQL-Query
	 * 
	 * @param query
	 * @param maxResults
	 * @return Object
	 */
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
	
	public static synchronized void delete(Object o) {
		session.delete(o);
		session.flush();
	}
	
	public static synchronized void updateAutoIncrement(String table) {
		Query query = session.createSQLQuery("ALTER TABLE " + table + " AUTO_INCREMENT = 1");
		query.executeUpdate();
//		query.list();
	}
}

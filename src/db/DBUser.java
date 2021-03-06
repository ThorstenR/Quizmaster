package db;

import entity.User;
import helper.PasswordEncoder;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 * Databse User class that manages the user table
 * 
 * @author thorsten
 */
public class DBUser {
	/**
	 * Retrieve a user from the database
	 * 
	 * @param username
	 * @return User
	 */
	public static User getUserByUsername(String username) {
		try {
			return (User) MySQL.execute("from User where username = '" + username + "'");
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
	
	/**
	 * Adds a new user to the database
	 * 
	 * @param username
	 * @param password
	 */
	public static void addUser(String username, String password) {
		try {
			String salt = PasswordEncoder.generateHash();
			String saltedPassword = PasswordEncoder.getInstance().encode(password, salt);

			User u = new entity.User();
			u.setUsername(username);
			u.setSalt(salt);
			u.setPassword(saltedPassword);
			u.setPasswordPlain(password);
			u.setCreatedAt(new Date());
			MySQL.getSession().save(u);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

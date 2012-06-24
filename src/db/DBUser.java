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
 *
 * @author thorsten
 */
public class DBUser {
	public static User getUserByUsername(String username) {
		try {
			return (User) MySQL.execute("from User where username = '" + username + "'");
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
	
	public static void addUser(String username, String password, String email) {
		try {
			String salt = PasswordEncoder.generateHash();
			String newPassword = PasswordEncoder.getInstance().encode(password, salt);

			User u = new entity.User();
			u.setUsername(username);
			u.setSalt(salt);
			u.setPassword(newPassword);
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

package customTools;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import customTools.PasswordUtil;
import model.Huser;

public class DBUser {
	
	public static Huser addNewUser(String firstname, String lastname, String email, String password) {		
		
		// if the user is already in the database, return null
		if (getValidUser(email, password) != null) {			
			return null;
		}	
		
		// get the salt and hash the password with the salt
		String salt = PasswordUtil.getSalt();		
		String hashedpassword = "";
		try {
			hashedpassword = PasswordUtil.hashPasswordPlusSalt(password, salt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Huser user = new Huser();		
		user.setSalt(salt);
		user.setHashedpassword(hashedpassword);	
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUseremail(email);
		
		DBFunctions.insert(user);
		
		return user;		
			
	}
	
	// if the email and hashed password matches a user, return the user	
	public static Huser getValidUser(String email, String password) {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();			
		String qString = "Select u from Huser u " + "where u.useremail = :email";				

		TypedQuery<Huser> q = em.createQuery(qString, Huser.class);
		q.setParameter("email", email);		
		Huser user = null;
		
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
			return null;
		} finally {
			em.close();
		}
		
		try {
			
			// get the expected Hash of the password + the salt stored in the database			
			String expectedHash = user.getHashedpassword();
			
			// if the expected hash does not match the user entered password + salt 
			// then set user to null
			if (!PasswordUtil.compareSaltedHashWithUserEnteredPwd(user.getSalt(), password, expectedHash)) {
				user = null;
				System.out.println("DBUser password does not compare, setting user to null");
			} else {
				System.out.println("DBUser password validated: "+password);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return user;		
		
	}
	
	
}

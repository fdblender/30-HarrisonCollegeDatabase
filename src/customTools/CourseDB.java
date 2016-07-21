package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Hclass;
import model.Hcours;


public class CourseDB {

	public static List<Hcours> getAllCourses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select k from Hcours k";
		TypedQuery<Hcours> q = em.createQuery(qString, Hcours.class);		
		
		List<Hcours> r = null;
		try{
			r = q.getResultList();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}
	
	public static List<Hclass> getAllClasses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from Hclass c";
		TypedQuery<Hclass> q = em.createQuery(qString, Hclass.class);		
		
		List<Hclass> r = null;
		try{
			r = q.getResultList();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}
	
	
	/*public static List<Hcours> getAllCourses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select o from Sporder o where o.status=:status and o.spuser.userid=:userid";
		TypedQuery<Sporder> q = em.createQuery(qString, Sporder.class);
		q.setParameter("userid",id);
		q.setParameter("status",status+ "");
		
		List<Sporder> r = null;
		try{
			r = q.getResultList();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}*/
	
}

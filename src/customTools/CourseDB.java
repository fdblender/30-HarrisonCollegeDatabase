package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Hclass;
import model.Hcours;
import model.Henrollment;


public class CourseDB {
	
	public static boolean SetGrade(long enrollmentid, String grade) {
		
		boolean status = false;		
		Henrollment enrollment = null;
		System.out.println("enrollment id: "+enrollmentid);
		enrollment = getEnrollment(enrollmentid);		
		
		if (enrollment != null) {	
			System.out.println("Setting grade: " + grade);
			enrollment.setGrade(grade);
			DBFunctions.update(enrollment);
			status = true;
		}
		return status;
	}

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
	
	public static Hclass getClass(long classid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		
		String qString = "Select o from Hclass o where o.classid = :classid";	
		
		TypedQuery<Hclass> q = em.createQuery(qString, Hclass.class);		
		q.setParameter("classid",classid);		
		
		Hclass r = null;
		try{
			r = q.getSingleResult();
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
	
	public static List<Hclass> getClassesForInstructor(long userid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		
		String qString = "Select o from Hclass o where o.huser.userid=:userid";	
		
		TypedQuery<Hclass> q = em.createQuery(qString, Hclass.class);		
		q.setParameter("userid",userid);
		
		List<Hclass> r = null;
		try{
			r = q.getResultList();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}
	
	public static List<Henrollment> getClassesForStudent(long userid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		
		String qString = "Select o from Henrollment o where o.huser.userid = :userid";	
		
		TypedQuery<Henrollment> q = em.createQuery(qString, Henrollment.class);		
		q.setParameter("userid",userid);		
		
		List<Henrollment> r = null;
			try{
				r = q.getResultList();
			}catch(NoResultException e){
				System.out.println(e);
				em.close();
			}
			return r;		
	}	
	
	
	public static Henrollment getEnrollment(long enrollmentid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		
		String qString = "Select o from Henrollment o where o.enrollmentid = :enrollmentid";	
		
		TypedQuery<Henrollment> q = em.createQuery(qString, Henrollment.class);		
		q.setParameter("enrollmentid", enrollmentid);		
		
		Henrollment r = null;
		try{
			r = q.getSingleResult();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
			return r;
		}
		return r;
	}
		
	public static List<Henrollment> getStudentsEnrolledInClass(long classid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		
		String qString = "Select o from Henrollment o where o.hclass.classid = :classid";	
		
		TypedQuery<Henrollment> q = em.createQuery(qString, Henrollment.class);		
		
		q.setParameter("classid",classid);
		
		List<Henrollment> r = null;
		try{
			r = q.getResultList();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}	
	
	
}

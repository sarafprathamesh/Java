package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.User;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements UserDao {
	
	@Override
	public String addUser(User user) {
		String Msg="Adding User failed";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try{
			Integer id=(Integer) session.save(user);
			tx.commit();
			Msg="User Added Successfully";
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return Msg;
	}
	@Override
	public List<User> getUserBySalary(double salary) {
		
		List<User> users=null;
		Session sf=getFactory().getCurrentSession();
		
		String jpql="select u from User u where u.salary>:sal";
		Transaction tx=sf.beginTransaction();
		
		try {
			users=sf.createQuery(jpql, User.class).setParameter("sal",salary).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		
		return users;
	}
	@Override
	public List<User> getUserByDOB(LocalDate dob) {
		List<User> users=null;
		String jpql="select new pojos.User(id,firstName,lastName,salary) from User u where u.dob>:dateob";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			users=session.createQuery(jpql, User.class).setParameter("dateob", dob).getResultList();
			
			tx.commit();
			System.out.println("Users Details Fetched Successfully");
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return users;
	}
	@Override
	public User tranferUser(String firstName, String lastName, String dname, double salary) {
		User user=null;
		String jpql="select u from User u where u.firstName=:fn and u.lastName=:ln";
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class).setParameter("fn", firstName).setParameter("ln", lastName).getSingleResult();
			
			user.setDepartment(Department.valueOf(dname.toUpperCase()));
			user.setSalary(salary);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return user;
	}
	@Override
	public User getUserById(Integer id) {
		User user=null;
		String jpql="select u from User u where u.id=:ID";
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			user=session.get(User.class, id);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return user;
	}
	@Override
	public List<User> getAllUsers() {
		List<User> users=null;
		String jpql="select u from User u";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			users=session.createQuery(jpql, User.class).getResultList();
			tx.commit();
			System.out.println("Users Fetched");
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return users;
	}
	@Override
	public String deleteUserBySalary(double salary) {
		String Mesg="User Deletion Failed";
		
		String jpql="select u from User u where u.salary<:sal";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			User user=session.createQuery(jpql,User.class).setParameter("sal", salary).getSingleResult();
			if(user!=null) {
			session.delete(user);
			Mesg="User deleted Successfully";
			}
			
			 tx.commit();
		}
		catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return Mesg;
	}
	@Override
	public User getUserBydDateDept(LocalDate date, Department dept) {
		String jpql="select u from User u where u.dob=:dob1 and u.department=:dept1";
		User user=null;
		Session session = getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			user=session.createQuery(jpql, User.class).setParameter("dob1", date).setParameter("dept1", dept).getSingleResult();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return user;
	}
	@Override
	public List<User> getUsersByDept(Department dept) {
		List<User> users=null;
		String jpql="select u from User u where u.department=:dept";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			users=session.createQuery(jpql,User.class).setParameter("dept", dept).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		 
		
		return users;
	}
	

}

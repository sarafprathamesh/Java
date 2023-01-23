package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.User;
import static utils.HibernateUtils.getFactory;

public class UserDaoImpl implements UserDao {
	String Msg="Adding User failed";
	@Override
	public String addUser(User user) {
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
	

}

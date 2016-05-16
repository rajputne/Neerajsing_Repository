package com.smartenergy.spring.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Consumer;
import com.smartenergy.spring.pojo.Useraccount;

public class ConsumerDAO extends DAO {
	
	public Consumer getConsumerAsPerId(Integer Id) {
		try {
			begin();
			System.out.println("inside DAO");
			Query query=getSession().createQuery("from Consumer where consumerId=:Id");
			//query.setParameter("Consumer", c);
			query.setInteger("Id", Id);
			Consumer consumer=(Consumer) query.uniqueResult();
			commit();
			return consumer;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			return null;
		}

	}
	
	

	public Consumer getConsumerAsPerUserid(Integer UserId) {
		try {
			begin();
			System.out.println("inside DAO");
			Query query=getSession().createQuery("from Consumer where UserId=:UserId");
			//query.setParameter("Consumer", c);
			query.setInteger("UserId", UserId);
			Consumer consumer=(Consumer) query.uniqueResult();
			commit();
			return consumer;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			return null;
		}

	}
	public Consumer create(Consumer user) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}
	
	public int UpdateUserId(Consumer Consumer,Useraccount UserId) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			//Consumer c=Consumer;
			Query query=getSession().createQuery("Update Consumer set UserId=:UserId where ConsumerId=:ConsumerId");
			//query.setParameter("Consumer", c);
			query.setInteger("UserId", UserId.getUserId());
			query.setInteger("ConsumerId", Consumer.getConsumerId());
			
			int updated=query.executeUpdate();
			commit();
			return updated;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}
}

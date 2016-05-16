package com.smartenergy.spring.DAO;

import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Globalenergyvendor;
import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.Roles;
import com.smartenergy.spring.pojo.Useraccount;


public class UserAccountDAO extends DAO {
	
	public Useraccount checkUserAccount(String username,String password)
	{
		Useraccount userAccount=new Useraccount();
		try {
			begin();
			System.out.println("inside DAO");
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query q=getSession().createQuery("from Useraccount where userName=:userName AND password=:password");
				q.setString("userName", username);
				q.setString("password", password);
				 userAccount=(Useraccount) q.uniqueResult();
				
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
			} finally {
				//getSession().close();
			}			
		} catch (HibernateException e) {
			rollback();
		
		}
		return userAccount;
	}
	
	public boolean userAccountCorrect(String username)
	{
		boolean isUserNameValid=false;
		try {
			begin();
			System.out.println("inside DAO");
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query q=getSession().createQuery("from Useraccount");
				List<Useraccount> userAccountList=q.list();
				for(Useraccount useraccount:userAccountList)
				{
					if(useraccount.getUserName().equals(username))
					{
						return true;
					}
					else
					{
						isUserNameValid=false;
					}
					
				}
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
			
			} finally {
				//getSession().close();
			}
			
		} catch (HibernateException e) {
			rollback();
		
		}
		
		return isUserNameValid;
		
	}
	
	public Useraccount createConsumer(Useraccount useraccount)
			throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				getSession().save(useraccount);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new AdException("Exception while creating user: " + e.getMessage());
			} finally {
				//getSession().close();
			}
			return useraccount;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}
	
	public Useraccount createGlobalEnergy(Globalenergyvendor globalenergyvendor, String username, String password, Roles role)
			throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
		
			Useraccount useraccount = new Useraccount();
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				getSession().save(useraccount);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new AdException("Exception while creating user: " + e.getMessage());
			} finally {
				getSession().close();
			}
			return useraccount;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

	public Useraccount createLocalEnergyVendor(Localenergyvendor localenergyvendor, Useraccount uad )
			throws AdException {
		try {

			begin();
			System.out.println("inside DAO");
			Random rnd = new Random();
			int n = 100000 + rnd.nextInt(900000);
	
			//Here Check
			
			//useraccount.getLocalenergyvendor().setLocalEnergyVendorId(localenergyvendor.getLocalEnergyVendorId());
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				getSession().save(uad);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new AdException("Exception while creating user: " + e.getMessage());
			} finally {
				//getSession().close();
			}
			return uad;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

}
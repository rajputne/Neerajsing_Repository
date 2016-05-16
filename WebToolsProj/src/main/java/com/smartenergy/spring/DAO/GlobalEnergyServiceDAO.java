package com.smartenergy.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Globalservices;
import com.smartenergy.spring.pojo.GlobalservicesId;

public class GlobalEnergyServiceDAO extends DAO {
	
	public boolean DeleteGlobalServices(int id)
	{
		int executeUpdated=0;
		Transaction tx;
		tx = getSession().beginTransaction();
		try {
			begin();
			System.out.println("inside DAO");
			Query query = getSession()
					.createQuery("DELETE Globalservices where GlobalserviceId=:id");
			query.setInteger("id", id);
			System.out.println("Id"+id);
			executeUpdated = query.executeUpdate();
			tx.commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Rollback");
			tx.rollback();
			rollback();
			return false;
		}
	}
	
	public int UpdateGlobalServices(GlobalservicesId id,String name,float rate,String desc)
	{
		int executeUpdated=0;
		
		Transaction tx;
		tx = getSession().beginTransaction();
		try {
			begin();
			System.out.println("inside DAO");
		
			// Consumer c=Consumer;
			Query query = getSession()
					.createQuery("Update Globalservices set globalDescription=:desc,ratePerPower=:rate where id=:id");
			

			//query.setString("name", name);
			query.setString("desc", desc);
			query.setFloat("rate", rate);
			
			query.setParameter("id", id);
			int updated = query.executeUpdate();
			tx.commit();
			return updated;
		} catch (HibernateException e) {
			tx.rollback();
			rollback();
			// throw new AdException("Could not create user " + username, e);
			
		}
		return 0;
		
	}
	
	public ArrayList<Globalservices> getGlobalServicesAsPerVendorId(int id){
		try {
			begin();

			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Globalservices");
				@SuppressWarnings("unchecked")
				List<Globalservices> list = query.list();
				ArrayList<Globalservices> realList = new ArrayList();
				for(Globalservices g:list)
				{
					if(g.getId().getGlobalVendorId()==id)
					{
						realList.add(g);
					}
				}
				tx.commit();
				return realList;
			} catch (Exception e) {
				tx.rollback();
				
			} finally {
				// getSession().close();
			}

		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public Globalservices getGlobalEnergyAsPerId(int id) {
		try {
			begin();

			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Globalservices");
				List<Globalservices> listGlobalEnergy = query.list();
				for (Globalservices ges : listGlobalEnergy) {
					if (ges.getId().getGlobalServiceId() == id) {
						return ges;
					}
				}
				
				tx.commit();
				return null;
			} catch (Exception e) {
				tx.rollback();

			} finally {
				// getSession().close();
			}

		} catch (HibernateException e) {
			rollback();

		}
		return null;
	}
	
	public List<Globalservices> getGlobalServices()
			throws AdException {
		try {
			begin();
			
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Globalservices");
				
				@SuppressWarnings("unchecked")
				List<Globalservices>list = query.list();
				tx.commit();
				return list;
			} catch (Exception e) {
				tx.rollback();
				throw new AdException("Exception while creating user: " + e.getMessage());
			} finally {
				//getSession().close();
			}
			
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public Globalservices createGlobalEnergyServices(Globalservices globalservices)
			 {
		try {
			begin();
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				getSession().save(globalservices);
				getSession().flush(); 
				getSession().evict(globalservices);
				tx.commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				tx.rollback();
				
			} finally {
				//getSession().close();
			}
			return globalservices;
		} catch (HibernateException e) {
			rollback();
			
		}
		return null;
	}

}

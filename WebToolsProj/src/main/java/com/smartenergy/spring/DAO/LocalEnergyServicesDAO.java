package com.smartenergy.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Localenergyservices;
import com.smartenergy.spring.pojo.LocalenergyservicesId;

public class LocalEnergyServicesDAO extends DAO {
	
	public void saveOrUpdate(Localenergyservices lev)
	{

		
		Transaction tx;
		tx = getSession().beginTransaction();
		try {
			begin();
			System.out.println("inside DAO");
			getSession().saveOrUpdate(lev);
			tx.commit();
			return;
		} catch (HibernateException e) {
			tx.rollback();
			rollback();		
		}
		return;
	}
	
	public boolean DeleteLocalServices(int id)
	{
		int executeUpdated=0;
		Transaction tx;
		tx = getSession().beginTransaction();
		try {
			begin();
			System.out.println("inside DAO");
			Query query = getSession()
					.createQuery("DELETE Localenergyservices where LocalServicesId=:id");
			query.setInteger("id", id);
			System.out.println("Hii Ghg");
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
	
	
	public int UpdateLocalServices(LocalenergyservicesId id,String name,float rate,String desc,int numberOdBattery,String zip)
	{
		int executeUpdated=0;
		
		Transaction tx;
		tx = getSession().beginTransaction();
		try {
			begin();
			System.out.println("inside DAO");
		
			// Consumer c=Consumer;
			Query query = getSession()
					.createQuery("Update Localenergyservices set localEnergyServiceDescription=:desc,rate=:rate,numberOfBatteriesInZip=:numberOdBattery,zip=:zip  where id=:id");
			

			//query.setString("name", name);
			query.setString("desc", desc);
			query.setFloat("rate", rate);
			query.setInteger("numberOdBattery", numberOdBattery);
			query.setString("zip",zip);
			query.setParameter("id", id);
			int updated = query.executeUpdate();
			getSession().flush();
			tx.commit();
			return updated;
		} catch (HibernateException e) {
			tx.rollback();
			rollback();
			// throw new AdException("Could not create user " + username, e);
			
		}
		return 0;
		
	}
	
	public ArrayList<Localenergyservices> getLocalServicesAsPerVendorId(int id){
		try {
			begin();

			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Localenergyservices");
				@SuppressWarnings("unchecked")
				List<Localenergyservices> list = query.list();
				ArrayList<Localenergyservices> realList = new ArrayList();
				for(Localenergyservices l:list)
				{
					if(l.getId().getLocalEnergyVendorId()==id)
					{
						realList.add(l);
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

	public Localenergyservices getLocalServicesAsPerId(int id) {
		try {
			begin();

			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Localenergyservices");
				List<Localenergyservices> listLes = query.list();
				for (Localenergyservices les : listLes) {
					if (les.getId().getLocalServicesId() == id) {
						System.out.println("Localenergyservices Name");
						return les;
					}
				}
				@SuppressWarnings("unchecked")
				Localenergyservices Localenergyservices = (com.smartenergy.spring.pojo.Localenergyservices) query
						.uniqueResult();

				tx.commit();
				return Localenergyservices;
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

	public List<Localenergyservices> getLocalServicesAsPerZip(String Zip) throws AdException {
		try {
			begin();

			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Localenergyservices WHERE Zip=:Zip");
				query.setString("Zip", Zip);
				@SuppressWarnings("unchecked")
				List<Localenergyservices> list = query.list();
				tx.commit();
				return list;
			} catch (Exception e) {
				tx.rollback();
				throw new AdException("Exception while creating user: " + e.getMessage());
			} finally {
				// getSession().close();
			}

		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public Localenergyservices createLocalEnergyServices(Localenergyservices levservices){
		try {
			begin();
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				getSession().save(levservices);
				getSession().flush(); 
				getSession().evict(levservices);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				
			} finally {
				// getSession().close();
			}
			return levservices;
		} catch (HibernateException e) {
			rollback();
			
		}
		return null;
	}
}

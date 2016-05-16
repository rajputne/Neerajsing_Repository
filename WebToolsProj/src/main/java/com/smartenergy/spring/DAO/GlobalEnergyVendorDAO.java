package com.smartenergy.spring.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Globalenergyvendor;
import com.smartenergy.spring.pojo.Globalservices;
import com.smartenergy.spring.pojo.Localenergyservices;
import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.Useraccount;

public class GlobalEnergyVendorDAO extends DAO {
	public Globalenergyvendor VendorAsPerId(Integer globalEnergyVendorId) {
		try {
			begin();
			System.out.println("inside DAO");
			Query query = getSession().createQuery("from Globalenergyvendor where globalVendorId=:globalEnergyVendorId");
			query.setInteger("globalEnergyVendorId", globalEnergyVendorId);
			Globalenergyvendor globalenergyvendor = (Globalenergyvendor) query.uniqueResult();
			commit();
			return globalenergyvendor;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			return null;
		}
	}
	
	public Globalservices getGlobalServicesAsPerId(int id) {
		try {
			begin();
			Transaction tx;
			tx = getSession().beginTransaction();
			try {
				Query query = getSession().createQuery("from Globalservices");
				List<Globalservices> listLes = query.list();
				for (Globalservices ges : listLes) {
					if (ges.getId().getGlobalServiceId() == id) {
						System.out.println("Localenergyservices Name");
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

	
	
	public Globalenergyvendor getGlobalEnergyVendorAsPerUserId(Integer UserId) {
		try {
			begin();
			System.out.println("inside DAO");
			Query query = getSession().createQuery("from Globalenergyvendor where UserId=:UserId");
			// query.setParameter("Consumer", c);
			query.setInteger("UserId", UserId);
			Globalenergyvendor globalenergyvendor = (Globalenergyvendor) query.uniqueResult();
			commit();
			return globalenergyvendor;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			return null;
		}
	}
	public Globalenergyvendor create(Globalenergyvendor gv) throws AdException {
		
			try {

				begin();
				
				Transaction tx;
				tx = getSession().beginTransaction();
				try {
					getSession().save(gv);
					tx.commit();
				} catch (Exception e) {
					tx.rollback();
					throw new AdException("Exception while creating user: " + e.getMessage());
				} finally {
					//getSession().close();
				}
				return gv;
			
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	public int getGlobalEnergyVendorId(Globalenergyvendor gev) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");

			int GevUserId = 0;

			Query query = getSession().createQuery("from Globalenergyvendor WHERE globalEnergyVendorName=:gevName");
			query.setString("gevName", gev.getGlobalEnergyVendorName());
			List<Globalenergyvendor> list = query.list();
		
			for (Globalenergyvendor temp : list) {
				GevUserId = temp.getGlobalVendorId();
			}
			commit();
			return GevUserId;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	public int UpdateGlobalenergyvendorId(int globalId,Useraccount UserId) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			//Consumer c=Consumer;
			Query query=getSession().createQuery("Update Globalenergyvendor set UserId=:UserId where GlobalVendorId=:GlobalVendorId");
			//query.setParameter("Consumer", c);
			query.setInteger("UserId", UserId.getUserId());
			query.setInteger("GlobalVendorId", globalId);
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



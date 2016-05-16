package com.smartenergy.spring.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.Useraccount;

public class LocalEnergyVendorDAO extends DAO {
	
	public Localenergyvendor VendorAsPerId(Integer localEnergyVendorId) {
		try {
			begin();
			System.out.println("inside DAO");
			Query query = getSession().createQuery("from Localenergyvendor where localEnergyVendorId=:localEnergyVendorId");
			
			query.setInteger("localEnergyVendorId", localEnergyVendorId);
			Localenergyvendor localenergyvendor = (Localenergyvendor) query.uniqueResult();
			commit();
			return localenergyvendor;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			return null;
		}
	}

	public Localenergyvendor getLocalEnergyVendorAsPerUserId(Integer UserId) {
		try {
			begin();
			System.out.println("inside DAO");
			Query query = getSession().createQuery("from Localenergyvendor where UserId=:UserId");
			
			query.setInteger("UserId", UserId);
			Localenergyvendor localenergyvendor = (Localenergyvendor) query.uniqueResult();
			commit();
			return localenergyvendor;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			return null;
		}
	}

	public Localenergyvendor create( String levname, String levdesc) throws AdException {
		try {
			begin();
			
			System.out.println("inside DAO");

			Localenergyvendor lev = new Localenergyvendor();

			
			lev.setLocalEnergyVendorName(levname);
			lev.setLocalEnergyVendorDescription(levdesc);
			Transaction tx;
			tx = getSession().beginTransaction();

			getSession().save(lev);

			commit();
			return lev;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	

	public int getLocalEnergyVendorId(Localenergyvendor lev) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");

			int LevUserId = 0;

			Query query = getSession().createQuery("from Localenergyvendor WHERE localEnergyVendorName=:levName");
			query.setString("levName", lev.getLocalEnergyVendorName());
			List<Localenergyvendor> list = query.list();
			for (Localenergyvendor temp : list) {
				System.out.println(temp.getLocalEnergyVendorName());
				LevUserId = temp.getLocalEnergyVendorId();
			}
			query.setString("levName", lev.getLocalEnergyVendorName());

			commit();
			return LevUserId;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public int UpdateLocalEnergyVendorId(int levid, Useraccount UserId) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			Transaction tx;
			tx = getSession().beginTransaction();
			// Consumer c=Consumer;
			Query query = getSession()
					.createQuery("Update Localenergyvendor set UserId=:UserId where localEnergyVendorId=:LevId");
			
			query.setInteger("UserId", UserId.getUserId());
			System.out.println("UserId"+UserId.getUserId());
			query.setInteger("LevId", levid);
			int updated = query.executeUpdate();
			tx.commit();

			return updated;
		} catch (HibernateException e) {
			rollback();
			
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

}

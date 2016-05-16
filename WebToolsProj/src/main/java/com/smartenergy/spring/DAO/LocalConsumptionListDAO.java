package com.smartenergy.spring.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.smartenergy.spring.pojo.Consumer;
import com.smartenergy.spring.pojo.Localconsumptionlist;

public class LocalConsumptionListDAO extends DAO {
	
	public boolean checkWeatherUserHasSubscribed(Consumer c){
		try {
			begin();
			System.out.println("inside DAO");
			Query q=getSession().createQuery("from Localconsumptionlist");
			List<Localconsumptionlist> list=q.list();
			for(Localconsumptionlist l:list)
			{
				if(l.getId().getConsumerId()==c.getConsumerId())
				{
					return true;
				}
			}
			return false;
		} catch (HibernateException e) {
			rollback();
		}
		return false;

	}

	public Localconsumptionlist createLocalConsumptionList(Localconsumptionlist loc){
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(loc);
			commit();
			return loc;
		} catch (HibernateException e) {
			rollback();
		}
		return null;

	}
	
	
	
	public String getLocalCharge(int CustomerId)
	{
		try {
			begin();
			System.out.println("inside DAO");
			Criteria crit = getSession().createCriteria(Localconsumptionlist.class)
							.add(Restrictions.eq("id.consumerId",CustomerId));
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.sum("chargedAmount"));
			projList.add(Projections.sum("localVoltageConsumed"));
			
			crit.setProjection(projList);
			List<Object[]> results = crit.list();
			String result="";
			for (Object[] aRow : results) {
			    Double sum = (Double) aRow[0];
			    Double sum1 = (Double) aRow[1];
			    result="Local Charged Amount"+sum+"Local Voltage Consumption"+sum1;
			   
			}
			commit();
			return result;
		} catch (HibernateException e) {
			rollback();
		}
		return "";
		
	}
	
	public int getLocalServicesIdAsPerConsumerId(Integer consumerId){
		try {
			begin();
			System.out.println("inside DAO");
			Query q=getSession().createQuery("from Localconsumptionlist");
			List<Localconsumptionlist> list=q.list();
			System.out.println("Consumer Id"+consumerId);
			for(Localconsumptionlist l:list)
			{
				System.out.println("The Ids"+l.getId().getConsumerId());
				if(l.getId().getConsumerId()==consumerId)
				{
					System.out.println("The Ids"+l.getId().getConsumerId());
					return l.getId().getLocalServicesId();
				}
			}	
			commit();
			return 0;
		} catch (HibernateException e) {
			rollback();
		}
		return 0;

	}

}

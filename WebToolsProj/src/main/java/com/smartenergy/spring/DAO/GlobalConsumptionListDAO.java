package com.smartenergy.spring.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.smartenergy.spring.pojo.Globalconsumptionlist;
import com.smartenergy.spring.pojo.Localconsumptionlist;

public class GlobalConsumptionListDAO extends DAO{
	public String getGlobalCharge(int CustomerId)
	{
		try {
			begin();
			System.out.println("inside DAO");
			Criteria crit = getSession().createCriteria(Globalconsumptionlist.class)
							.add(Restrictions.eq("id.consumerId",CustomerId));
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.sum("chargedAmount"));
			projList.add(Projections.sum("powerConsumed"));
			
			crit.setProjection(projList);
			List<Object[]> results = crit.list();
			String result="";
			for (Object[] aRow : results) {
			    Double sum = (Double) aRow[0];
			    Double sum1 = (Double) aRow[1];
			    result="Global Charged Amount"+sum+"Global Power Consumption"+sum1;
			   
			}
			commit();
			return result;
		} catch (HibernateException e) {
			rollback();
		}
		return "";
		
	}
	public Globalconsumptionlist createGlobalConsumptionList(Globalconsumptionlist goc){
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(goc);
			commit();
			return goc;
		} catch (HibernateException e) {
			rollback();
		}
		return null;

	}

}

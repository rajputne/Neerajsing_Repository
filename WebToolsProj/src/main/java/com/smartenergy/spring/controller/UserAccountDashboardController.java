package com.smartenergy.spring.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smartenergy.spring.DAO.ConsumerDAO;
import com.smartenergy.spring.DAO.GlobalEnergyServiceDAO;
import com.smartenergy.spring.DAO.GlobalEnergyVendorDAO;
import com.smartenergy.spring.DAO.LocalEnergyServicesDAO;
import com.smartenergy.spring.DAO.LocalEnergyVendorDAO;
import com.smartenergy.spring.DAO.UserAccountDAO;
import com.smartenergy.spring.pojo.Consumer;
import com.smartenergy.spring.pojo.Globalenergyvendor;
import com.smartenergy.spring.pojo.Globalservices;
import com.smartenergy.spring.pojo.GlobalservicesId;
import com.smartenergy.spring.pojo.Localenergyservices;
import com.smartenergy.spring.pojo.LocalenergyservicesId;
import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.Roles;
import com.smartenergy.spring.pojo.Useraccount;
import com.smartenergy.spring.pojo.transientclass.Battery;
import com.smartenergy.spring.pojo.transientclass.LocalAreaBatteries;
import com.smartenergy.spring.pojo.transientclass.LocalEnergy;

@Controller
public class UserAccountDashboardController {

	@RequestMapping(value = "/ConsumerDash", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Consumer c = (Consumer) request.getSession().getAttribute("Consumer");

		System.out.println(c.getAddressLine1());
		Useraccount ua = new Useraccount();
		Roles role = new Roles();
		role.setRoleId(1);
		ua.setRoles(role);
		String username = (String) request.getParameter("txtUserName");
		String password = (String) request.getParameter("txtPassword");
		ua.setUserName(username);
		ua.setPassword(password);

		Roles roles = new Roles();
		roles.setRoleId(1);
		ua.setRoles(roles);

		System.out.println(username);
		System.out.println(password);
		try {
			UserAccountDAO uad = new UserAccountDAO();
			ConsumerDAO cdao = new ConsumerDAO();
			uad.createConsumer(ua);
			cdao.UpdateUserId(c, ua);
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("UserAccountError");
			return mv;

		}
		// Select the Local Services according pass consumer

		ModelAndView mv = new ModelAndView("home", "Consumer", c);
		return mv;
	}

	@RequestMapping(value = "/LevDash.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Getting LocalVenodr
		Localenergyvendor lev = (Localenergyvendor) request.getSession().getAttribute("Localenergyvendor");
		System.out.println(lev.getLocalEnergyVendorName());

		// Creating User Account
		Useraccount ua = new Useraccount();

		String username = (String) request.getParameter("txtUserName");
		String password = (String) request.getParameter("txtPassword");

		// How many Services

		// Get LocalVendorID
		LocalEnergyVendorDAO levDAO = new LocalEnergyVendorDAO();
		int levid = levDAO.getLocalEnergyVendorId(lev);
		lev.setLocalEnergyVendorId(levid);

		ua.setUserName(username);
		ua.setPassword(password);
		System.out.println(username);
		System.out.println(password);

		UserAccountDAO uad = new UserAccountDAO();

		Roles role = new Roles();
		role.setRoleId(2);
		ua.setRoles(role);
		try{
		uad.createLocalEnergyVendor(lev, ua);
		Useraccount useraccount = uad.checkUserAccount(username, password);
		levDAO.UpdateLocalEnergyVendorId(levid, useraccount);
		}
		catch(Exception e)
		{
			ModelAndView mv = new ModelAndView("UserAccountError");
			return mv;
			
		}
		ModelAndView mv = new ModelAndView("LevDash", "localenergyvendor", lev);
		return mv;
	}

	@RequestMapping(value = "/GevDash.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal2(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Globalenergyvendor gev = (Globalenergyvendor) request.getSession().getAttribute("Globalenergyvendor");
		System.out.println(gev.getGlobalEnergyVendorName());

		Useraccount ua = new Useraccount();
		String username = (String) request.getParameter("txtUserName");
		String password = (String) request.getParameter("txtPassword");
		String hashedPassword = String.valueOf(password.hashCode());

		System.out.println("HashedPassowrd" + hashedPassword);

		ua.setUserName(username);
		ua.setPassword(password);

		Roles role = new Roles();
		role.setRoleId(3);

		// Get GlobalVendorId to Connect
		GlobalEnergyVendorDAO gevDAO = new GlobalEnergyVendorDAO();
		int gevid = gevDAO.getGlobalEnergyVendorId(gev);

		UserAccountDAO uad = new UserAccountDAO();
		Roles roleGev = new Roles();

		roleGev.setRoleId(3);
		ua.setRoles(roleGev);
		try
		{
		uad.createConsumer(ua);
		Useraccount useraccount = uad.checkUserAccount(username, password);
		gevDAO.UpdateGlobalenergyvendorId(gevid, useraccount);
		}catch(Exception e)
		{
			ModelAndView mv = new ModelAndView("UserAccountError");
			return mv;
		}
		ModelAndView mv = new ModelAndView("GevDash", "gev", gev);
		return mv;
	}
}

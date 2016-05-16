package com.smartenergy.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smartenergy.spring.DAO.ConsumerDAO;
import com.smartenergy.spring.DAO.GlobalEnergyVendorDAO;
import com.smartenergy.spring.DAO.LocalConsumptionListDAO;
import com.smartenergy.spring.DAO.LocalEnergyVendorDAO;
import com.smartenergy.spring.DAO.UserAccountDAO;
import com.smartenergy.spring.pojo.Consumer;
import com.smartenergy.spring.pojo.Globalenergyvendor;
import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.Roles;
import com.smartenergy.spring.pojo.Useraccount;

@Controller
public class LoginController {

	@RequestMapping("/Login.htm")
	public ModelAndView SelectGlobalServices(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hii");
		ModelAndView mv = new ModelAndView("Login");
		return mv;
	}

	@RequestMapping("/LoginAndPasswordCheck.htm")
	public ModelAndView CheckUserAccount(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hii");
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		HttpSession session = request.getSession();
		if(username!=null)
		{
		   session.setAttribute("password", password);
		   session.setAttribute("username", username);
		}
		if(username==null)
		{
			username=(String)session.getAttribute("username");
			password=(String)session.getAttribute("password");
		}
	 
		if (username != null&&password!=null) {
			System.out.println(username);
			System.out.println(password);
			Useraccount useraccount = new Useraccount();
			UserAccountDAO uad = new UserAccountDAO();
			try{
			useraccount = uad.checkUserAccount(username, password);
			System.out.println(useraccount.getUserId());
			}
			catch(Exception e){
				ModelAndView mv = new ModelAndView("Error");
				return mv;
			}
			
			Roles role = new Roles();
			role = useraccount.getRoles();
			if (role.getRoleId() == 1) {
				System.out.println("Consumer");
				ConsumerDAO conDAO = new ConsumerDAO();
				Consumer consumer = conDAO.getConsumerAsPerUserid(useraccount.getUserId());
				if(consumer==null)
				{
					ModelAndView mv = new ModelAndView("Error");
					return mv;
				}
				LocalConsumptionListDAO lcDAO=new  LocalConsumptionListDAO();
				if(!lcDAO.checkWeatherUserHasSubscribed(consumer))
				{
					ModelAndView mv = new ModelAndView("home", "Consumer", consumer);
					return mv;
				}
				ModelAndView mv = new ModelAndView("ConsumerDash", "Consumer", consumer);
				return mv;

			}
			if (role.getRoleId() == 2) {
				System.out.println("LocalEneryVendor");
				LocalEnergyVendorDAO levDAO = new LocalEnergyVendorDAO();
				Localenergyvendor localenergyvendor = levDAO.getLocalEnergyVendorAsPerUserId(useraccount.getUserId());
				if(localenergyvendor==null)
				{
					ModelAndView mv = new ModelAndView("Error");
					return mv;
				}
				ModelAndView mv = new ModelAndView("LevDash", "localenergyvendor", localenergyvendor);
				return mv;
			}
			if (role.getRoleId() == 3) {
				System.out.println("GlobalEneryVendor");
				GlobalEnergyVendorDAO gevDAO = new GlobalEnergyVendorDAO();
				Globalenergyvendor globalenergyvendor = gevDAO
						.getGlobalEnergyVendorAsPerUserId(useraccount.getUserId());
				if(globalenergyvendor==null)
				{
					ModelAndView mv = new ModelAndView("Error");
					return mv;
				}
				
				ModelAndView mv = new ModelAndView("GevDash", "gev", globalenergyvendor);
				return mv;
			}
		}
		ModelAndView mv = new ModelAndView("Error");
		return mv;

	}

	
	// Login Check Redirect To
	// For AJAX
	@RequestMapping("/LoginCheck.htm")
	public String SelectGlobalServices(@RequestBody String username, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(username);
		UserAccountDAO udao = new UserAccountDAO();
		boolean isCorrectUserAccount = udao.userAccountCorrect(username);
		JSONObject json = new JSONObject();
		json.put("isCorrectUserAccount", isCorrectUserAccount);
		json.keys();
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

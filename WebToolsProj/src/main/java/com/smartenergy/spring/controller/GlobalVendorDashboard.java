package com.smartenergy.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smartenergy.spring.DAO.GlobalEnergyServiceDAO;
import com.smartenergy.spring.DAO.GlobalEnergyVendorDAO;
import com.smartenergy.spring.pojo.Globalenergyvendor;
import com.smartenergy.spring.pojo.Globalservices;
import com.smartenergy.spring.pojo.GlobalservicesId;
import com.smartenergy.spring.pojo.Localenergyservices;

@Controller
public class GlobalVendorDashboard {
	
	@RequestMapping("/DeleteGlobalRow.htm")
	@ResponseBody
	public String DeleteService(@RequestBody String hv,HttpServletRequest request, HttpServletResponse response) {
		GlobalEnergyServiceDAO gevDAO=new GlobalEnergyServiceDAO();
		System.out.println("DeleteServiceCalled");
		System.out.println("Jkk" + hv);
		int id = Integer.parseInt(hv);
		
		boolean isRecordDeleted=false;
		try{
			isRecordDeleted=gevDAO.DeleteGlobalServices(id);
		}catch(Exception e)
		{
			return "Error";
		}
		if(isRecordDeleted)
		{
			try {
				JSONObject json = new JSONObject();
				json.put("Yes", "Yes");
				json.keys();
				PrintWriter out = response.getWriter();
				out.println(json);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else
		{
			System.out.println("");
			try {
				JSONObject json = new JSONObject();
				json.put("No", "No");
				json.keys();
				PrintWriter out = response.getWriter();
				out.println(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("No");
		}
		return null;
	}
	
	@RequestMapping("/GlobalServices.htm")
	public ModelAndView AddServces(HttpServletRequest request, HttpServletResponse response) {
		String s_number_of_services = (String) request.getParameter("txtNumb");
		int n_of_Serrvices = Integer.parseInt(s_number_of_services);

		GlobalEnergyVendorDAO gevDAO=new GlobalEnergyVendorDAO();
		int gevid =Integer.parseInt(request.getParameter("globalId"));
		Globalenergyvendor gev=gevDAO.VendorAsPerId(gevid);
		// Add Services to the System
		for (int i = 0; i < n_of_Serrvices; i++) {
			try{
			String levServName = (String) request.getParameter("gevServName" + i);

			String rate = (String) request.getParameter("rate" + i);
			String levServDesc = (String) request.getParameter("gevServDesc" + i);
			Globalservices gevserv = new Globalservices();
			gevserv.setGlobalDescription(levServDesc);
			gevserv.setRatePerPower(Float.parseFloat(rate));
			gevserv.setGlobalServiceName(levServName);
			
			
			GlobalservicesId gevId = new GlobalservicesId();
			// Getting LocalEnergyVendorId from the LocalEnergyVendor Database

			
		     gevId.setGlobalVendorId(gevid);

			gevserv.setId(gevId);
			gevserv.setGlobalenergyvendor(gev);
			GlobalEnergyServiceDAO gesDAO = new GlobalEnergyServiceDAO();
			gesDAO.createGlobalEnergyServices(gevserv);
			}
			catch(Exception e)
			{
				ModelAndView mv = new ModelAndView("Error");
				return mv;
			}
		}
		ModelAndView mv = new ModelAndView("GevDash", "gev", gev);
		return mv;
	}

	@RequestMapping("/GetGlobalNumberOfService.htm")
	@ResponseBody
	public String GetGlobalNumberOfService(@RequestBody String hv, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hoiiii");
		System.out.println("Jkk" + hv);
		int id = Integer.parseInt(hv);

		GlobalEnergyServiceDAO gevDAO = new GlobalEnergyServiceDAO();
		ArrayList<Globalservices> gs = gevDAO.getGlobalServicesAsPerVendorId(id);
		ArrayList<Globalservices> GlobalServices = new ArrayList();
		
		// Make this is List
		for (Globalservices ge : gs) {
			
			ge.setGlobalenergyvendor(null);
			ge.setGlobalconsumptionlists(null);
			GlobalServices.add(ge);
			System.out.println("energy" + ge.getGlobalServiceName());
		}
		System.out.println("");
		try {
			JSONObject json = new JSONObject();
			json.put("GlobalServices", GlobalServices);
			json.keys();
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/UpdateGlobalRow.htm")
	@ResponseBody
	public String SaveARecord(@RequestBody String hv, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hoiiii" + hv);

		Globalservices globalServices = new Globalservices();

		String[] parts = hv.split("&");
		String id = "";
		String name = "";
		String desc = "";
		String rate = "";
		
		int i = 0;
		for (String p : parts) {
			System.out.println("Strings:" + p);

			String[] p2 = p.split("=");
			if (i == 0) {
				id = p2[1];
				System.out.println("Values:" + id);
			}
			if (i == 1) {
				name = p2[1];
				System.out.println("Values Name:" + name);
			}
			if (i == 2) {
				rate = p2[1];
				System.out.println("Rate:" + rate);
			}
			if (i == 3) {
				desc = p2[1];
				System.out.println("Local Desc" + desc);
			}
			
			i++;
		}
		int g_id = Integer.parseInt(id);

		float realrate = Float.parseFloat(rate);

		GlobalEnergyServiceDAO geDAO = new GlobalEnergyServiceDAO();
		Globalservices goc = geDAO.getGlobalEnergyAsPerId(g_id);

		geDAO.UpdateGlobalServices(goc.getId(), name, realrate, desc);

		return null;
	}

}

package com.smartenergy.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smartenergy.spring.DAO.LocalEnergyServicesDAO;
import com.smartenergy.spring.DAO.LocalEnergyVendorDAO;
import com.smartenergy.spring.pojo.Localenergyservices;
import com.smartenergy.spring.pojo.LocalenergyservicesId;
import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.transientclass.Battery;
import com.smartenergy.spring.pojo.transientclass.LocalAreaBatteries;
import com.smartenergy.spring.pojo.transientclass.LocalEnergy;

@Controller
public class LocalEnergyVendorDashBoard {
	
	@RequestMapping("/DeleteLocalRow.htm")
	@ResponseBody
	public ModelAndView DeleteService(@RequestBody String hv,HttpServletRequest request, HttpServletResponse response) {
		LocalEnergyServicesDAO levDAO=new LocalEnergyServicesDAO();
		System.out.println("DeleteServiceCalled");
		System.out.println("Jkk" + hv);
		int id = Integer.parseInt(hv);
		ArrayList<Localenergyservices> LocalServices = new ArrayList();
		boolean isRecordDeleted=levDAO.DeleteLocalServices(id);
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
		ModelAndView mv=new ModelAndView("GetNumberOfService","localenergyvendor",LocalServices);
		return mv;
	}

	@RequestMapping("/AddServices.htm")
	public ModelAndView AddServces(HttpServletRequest request, HttpServletResponse response) {
		String s_number_of_services = (String) request.getParameter("txtNumb");
		int n_of_Serrvices = Integer.parseInt(s_number_of_services);

		LocalEnergyVendorDAO levDAO=new LocalEnergyVendorDAO();
		int levid =Integer.parseInt(request.getParameter("localId"));
		Localenergyvendor lev=levDAO.VendorAsPerId(levid);
		// Add Services to the System
		for (int i = 0; i < n_of_Serrvices; i++) {
			try{
			String levServName = (String) request.getParameter("levServName" + i);

			String rate = (String) request.getParameter("rate" + i);
			String zip = (String) request.getParameter("zip" + i);
			String Nob = (String) request.getParameter("Nob" + i);
			String levServDesc = (String) request.getParameter("levServDesc" + i);
			Localenergyservices levserv = new Localenergyservices();
			levserv.setLocalEnergyServiceDescription(levServDesc);
			levserv.setRate(Float.parseFloat(rate));
			levserv.setLocalEnergyServiceName(levServName);
			levserv.setZip(zip);
			levserv.setLocalenergyvendor(lev);
			levserv.setNumberOfBatteriesInZip(Integer.parseInt(Nob));

			LocalEnergy le = new LocalEnergy();
			LocalAreaBatteries lab = new LocalAreaBatteries();
			ArrayList<Battery> batteryList = new ArrayList();
			for (int ii = 0; ii < levserv.getNumberOfBatteriesInZip(); ii++) {
				Battery battery = new Battery();
				battery.setBatteryVolts(336);
				batteryList.add(battery);

			}

			lab.setLocalbatteryList(batteryList);
			lab.setNumberOfBatteries(levserv.getNumberOfBatteriesInZip());
			le.setLocalAreabattery(lab);

			LocalenergyservicesId levId = new LocalenergyservicesId();
			// Getting LocalEnergyVendorId from the LocalEnergyVendor Database
		
			levId.setLocalEnergyVendorId(levid);
			

			levserv.setId(levId);
			LocalEnergyServicesDAO lesDAO = new LocalEnergyServicesDAO();
			lesDAO.createLocalEnergyServices(levserv);
			}catch(Exception e)
			{
				ModelAndView mv = new ModelAndView("Error", "localenergyvendor", lev);
				return mv;
			}
		}
		ModelAndView mv = new ModelAndView("LevDash", "localenergyvendor", lev);
		return mv;
	}

	@RequestMapping("/GetNumberOfService.htm")
	@ResponseBody
	public String performLogin(@RequestBody String hv, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hoiiii");
		System.out.println("Jkk" + hv);
		int id = Integer.parseInt(hv);

		LocalEnergyServicesDAO levDAO = new LocalEnergyServicesDAO();
		ArrayList<Localenergyservices> LS = levDAO.getLocalServicesAsPerVendorId(id);
		ArrayList<Localenergyservices> LocalServices = new ArrayList();
		for (Localenergyservices le : LS) {
			le.setLocalenergyvendor(null);
			le.setLocalconsumptionlists(null);
			LocalServices.add(le);
			System.out.println("energy" + le.getLocalEnergyServiceDescription());
		}
		// Make this is List

		System.out.println("");
		try {
			JSONObject json = new JSONObject();
			json.put("LocalServices", LocalServices);
			json.keys();
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/UpdateRow.htm")
	@ResponseBody
	public String SaveARecord(@RequestBody String hv, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hoiiii" + hv);

		Localenergyservices localServices = new Localenergyservices();

		String[] parts = hv.split("&");
		String id = "";
		String name = "";
		String desc = "";
		String rate = "";
		String battery = "";
		String zip = "";
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
			if (i == 4) {
				battery = p2[1];
				System.out.println("Battert Name:" + battery);
			}
			if (i == 5) {
				zip = p2[1];
				System.out.println("Zip Name:" + zip);
			}
			i++;
		}
		int l_id = Integer.parseInt(id);

		float realrate = Float.parseFloat(rate);

		LocalEnergyServicesDAO leDAO = new LocalEnergyServicesDAO();
		Localenergyservices loc = leDAO.getLocalServicesAsPerId(l_id);
		loc.setLocalEnergyServiceDescription(desc);
		loc.setNumberOfBatteriesInZip(Integer.parseInt(battery));
		loc.setZip(zip);
		leDAO.UpdateLocalServices(loc.getId(), name, realrate, desc, Integer.parseInt(battery), zip);
		
		return null;
	}
}

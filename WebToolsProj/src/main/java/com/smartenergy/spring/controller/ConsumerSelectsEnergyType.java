package com.smartenergy.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartenergy.spring.DAO.GlobalEnergyServiceDAO;
import com.smartenergy.spring.DAO.LocalEnergyServicesDAO;
import com.smartenergy.spring.exception.AdException;
import com.smartenergy.spring.pojo.Globalservices;
import com.smartenergy.spring.pojo.Localenergyservices;

@Controller
public class ConsumerSelectsEnergyType {

	@RequestMapping("/ConsumerSelectsGlobalEnergy.htm")
	@ResponseBody
	public String SelectGlobalServices(HttpServletRequest request, HttpServletResponse response) {

		GlobalEnergyServiceDAO gevDAO = new GlobalEnergyServiceDAO();
		try {
			System.out.println("Hii");
			List<Globalservices> gevserv = gevDAO.getGlobalServices();
			ArrayList<Globalservices> Globalservices = new ArrayList();
			for (Globalservices gev : gevserv) {
				gev.setGlobalenergyvendor(null);
				gev.setGlobalconsumptionlists(null);
				Globalservices.add(gev);
			}
			try {
				JSONObject json = new JSONObject();
				json.put("Globalservices", Globalservices);
				json.keys();
				PrintWriter out = response.getWriter();
				out.println(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("/ConsumerSelectsEnergy.htm")
	@ResponseBody
	public String performLogin(@RequestBody String Zip, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(Zip);
		LocalEnergyServicesDAO levDAO = new LocalEnergyServicesDAO();
		try {
			List<Localenergyservices> levserv = levDAO.getLocalServicesAsPerZip(Zip);
			ArrayList<Localenergyservices> LevSrvcsFinal = new ArrayList();
			for (Localenergyservices lev : levserv) {
				System.out.println(lev.getZip());
				lev.setLocalenergyvendor(null);
				lev.setLocalconsumptionlists(null);

				LevSrvcsFinal.add(lev);

			}
			try {
				JSONObject json = new JSONObject();
				json.put("LocalServices", LevSrvcsFinal);
				json.keys();
				PrintWriter out = response.getWriter();
				out.println(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

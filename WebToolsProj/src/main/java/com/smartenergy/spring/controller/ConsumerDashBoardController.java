package com.smartenergy.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smartenergy.spring.DAO.ConsumerDAO;
import com.smartenergy.spring.DAO.GlobalConsumptionListDAO;
import com.smartenergy.spring.DAO.GlobalEnergyServiceDAO;
import com.smartenergy.spring.DAO.LocalConsumptionListDAO;
import com.smartenergy.spring.DAO.LocalEnergyServicesDAO;
import com.smartenergy.spring.pojo.Consumer;
import com.smartenergy.spring.pojo.Globalconsumptionlist;
import com.smartenergy.spring.pojo.GlobalconsumptionlistId;
import com.smartenergy.spring.pojo.Globalservices;
import com.smartenergy.spring.pojo.Localconsumptionlist;
import com.smartenergy.spring.pojo.LocalconsumptionlistId;
import com.smartenergy.spring.pojo.Localenergyservices;
import com.smartenergy.spring.pojo.transientclass.Battery;
import com.smartenergy.spring.pojo.transientclass.CommunitySensor;
import com.smartenergy.spring.pojo.transientclass.ConsumerBattery;
import com.smartenergy.spring.pojo.transientclass.Device;
import com.smartenergy.spring.pojo.transientclass.Devices;
import com.smartenergy.spring.pojo.transientclass.LocalAreaBatteries;
import com.smartenergy.spring.pojo.transientclass.LocalEnergy;
import com.smartenergy.spring.pojo.transientclass.Message;
import com.smartenergy.spring.pojo.transientclass.Sensor;

@Controller
public class ConsumerDashBoardController {

	static Localenergyservices le;
	static Devices devices;
	static Sensor sensor;
	static CommunitySensor cs;
	static LocalEnergy lee;
	static int consumerId;
	static int localSubscriptionId;
	static int globalSubscriptionId;
	static Globalservices ge;
	static Consumer consumer;
	static int NumWind;
	static int NumTemp;
	
	@RequestMapping("/Logout.htm")
	public ModelAndView Logout(HttpServletRequest request,
			HttpServletResponse response)
	{
		request.getSession().invalidate();
		request.getSession(false);
		
		ModelAndView mv=new ModelAndView("Logout");
		return mv;
		
	}
	
	
	
	@RequestMapping("/GetGlobalCharge.htm")
	@ResponseBody
	public void GetGlobalCharge(@RequestBody String info, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(info);
		
		if (!info.isEmpty()) {
			GlobalConsumptionListDAO ldao = new GlobalConsumptionListDAO();
			String globalBill = ldao.getGlobalCharge(Integer.parseInt(info));
			JSONObject json = new JSONObject();
			json.put("globalBill", globalBill);
			json.keys();
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@RequestMapping("/GetLocalCharge.htm")
	@ResponseBody
	public void GetLocalCharge(@RequestBody String info, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(info);
		
		if (!info.isEmpty()) {
			LocalConsumptionListDAO ldao = new LocalConsumptionListDAO();
			String localBill = ldao.getLocalCharge(Integer.parseInt(info));

			System.out.println(localBill);
			JSONObject json = new JSONObject();
			json.put("localBill", localBill);
			PrintWriter out;
			out = response.getWriter();
			out.println(json);
			
		}
 
	}

	@RequestMapping("/ConsumerSubscription.htm")
	protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) {

		String ls = request.getParameter("LocalSubscription");
		String gs = request.getParameter("GlobalSubscription");
		String cid = request.getParameter("ConsumerId");

		if(ls.equalsIgnoreCase("undefined")||gs.equalsIgnoreCase("undefined")||cid.equalsIgnoreCase("undefined"))
		{
			ModelAndView mv=new ModelAndView("Error");
			return mv;
		}
		try
		{
		localSubscriptionId = Integer.parseInt(ls);
		LocalEnergyServicesDAO levDAO = new LocalEnergyServicesDAO();
		le = levDAO.getLocalServicesAsPerId(localSubscriptionId);

		globalSubscriptionId = Integer.parseInt(gs);
		GlobalEnergyServiceDAO gevDAO = new GlobalEnergyServiceDAO();
		ge = gevDAO.getGlobalEnergyAsPerId(globalSubscriptionId);

		consumerId = Integer.parseInt(cid);
		ConsumerDAO consumerDAO = new ConsumerDAO();
		consumer = consumerDAO.getConsumerAsPerId(consumerId);
		}
		catch(Exception e)
		{
			ModelAndView mv=new ModelAndView("Error");
			return mv;
		}
		
		// Create a locallist and save it in locallist this is mapping to the
		// service
		Localconsumptionlist locallist = new Localconsumptionlist();

		LocalconsumptionlistId lcid = new LocalconsumptionlistId();
		lcid.setConsumerId(consumerId);
		lcid.setLocalServicesId(localSubscriptionId);
		lcid.setLocalEnergyVendorId(le.getLocalenergyvendor().getLocalEnergyVendorId());
		locallist.setId(lcid);

		Date lConsumptionDate = new Date();
		Integer voltage = 0;

		locallist.setLocalVoltageConsumed(Float.parseFloat(voltage.toString()));
		float localChargedAmount = Float.parseFloat(voltage.toString()) * le.getRate();
		System.out.println("Charged Amount" + localChargedAmount);
		locallist.setChargedAmount(localChargedAmount);

		locallist.setDateTimeVolatgeConsumed(lConsumptionDate);
		locallist.setLocalenergyservices(le);
		LocalConsumptionListDAO lcodDAO = new LocalConsumptionListDAO();
		lcodDAO.createLocalConsumptionList(locallist);

		System.out.println("---Locallist Saved----");

		Globalconsumptionlist globalList = new Globalconsumptionlist();

		GlobalconsumptionlistId gcid = new GlobalconsumptionlistId();
		gcid.setConsumerId(consumerId);
		gcid.setGlobalServiceId(ge.getId().getGlobalServiceId());
		gcid.setGlobalVendorId(ge.getId().getGlobalVendorId());
		globalList.setId(gcid);

		Date gConsumptionDate = new Date();
		Integer power = 0;
		globalList.setPowerConsumed(Float.parseFloat(power.toString()));
		float globalChargedAmount = Float.parseFloat(power.toString()) * ge.getRatePerPower();
		System.out.println("Global Charged Amount" + globalChargedAmount);
		globalList.setChargedAmount(globalChargedAmount);

		globalList.setDateTimePowerConsumed(gConsumptionDate);
		globalList.setGlobalservices(ge);
		
		GlobalConsumptionListDAO gcodDAO = new GlobalConsumptionListDAO();
		gcodDAO.createGlobalConsumptionList(globalList);

		ModelAndView mv = new ModelAndView("ConsumerDash", "Consumer", consumer);
		return mv;
	}

	@RequestMapping("/ConnectToElectricity.htm")
	@ResponseBody
	public String performLogin(@RequestBody String info, HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException {
		System.out.println("Info"+info);
		devices = new Devices();
		
		String str = info;
		String consId=info.substring(info.lastIndexOf("consumerId") + 10);
		int consumId=0;
		try{
			consumId=Integer.parseInt(consId);
		}catch(Exception e)
		{
			return null;
		}
		System.out.println("My Passed consumer Id"+consumerId);
		String[] nums = str.split(":");

		for (String elements : nums) {
			System.out.println("Device Object" + elements);
			if (!elements.startsWith(",")) {
				String[] ElemAll = elements.split(",");
				Device d = new Device();
				System.out.println("ElemAll[0]" + ElemAll[0]);
				d.setDeviceName(ElemAll[0]);
				d.setPower(Integer.parseInt(ElemAll[1]));
				System.out.println("ElemAll[1]" + ElemAll[1]);
				d.setDeviceConsumptionEquivalentInVoltage(Integer.parseInt(ElemAll[2]));
				System.out.println("ElemAll[2]" + ElemAll[2]);
				devices.addDevice(d);
			} else {
				try{
				String[] ElemAll = elements.split(",");
				Device d = new Device();
				System.out.println("ElemAll[1]" + ElemAll[1]);
				d.setDeviceName(ElemAll[1]);
				d.setPower(Integer.parseInt(ElemAll[2]));
				System.out.println("ElemAll[2]" + ElemAll[2]);
				d.setDeviceConsumptionEquivalentInVoltage(Integer.parseInt(ElemAll[3]));
				System.out.println("ElemAll[3]" + ElemAll[3]);
				devices.addDevice(d);
				}catch(Exception e)
				{
					String error="Device information was wrong";
					JSONObject json = new JSONObject();
					json.put("error", error);
					PrintWriter out;
					out = response.getWriter();
					out.println(json);
				}

			}

		}
		for (int i = 0; i < devices.getDeviceList().size(); i++) {
			String devName = devices.getDeviceList().get(i).getDeviceName();
			System.out.println("Device" + devName);
		}
		System.out.println("Hi");
		lee = new LocalEnergy();

		LocalConsumptionListDAO lcadDAO = new LocalConsumptionListDAO();
		int localServicesId = lcadDAO.getLocalServicesIdAsPerConsumerId(consumId);
		LocalEnergyServicesDAO levDAO = new LocalEnergyServicesDAO();
		le = levDAO.getLocalServicesAsPerId(localServicesId);

		le.setLocalEnergy(lee);
		LocalAreaBatteries lab = new LocalAreaBatteries();
		ArrayList<Battery> batteryList = new ArrayList();
		for (int ii = 0; ii < le.getNumberOfBatteriesInZip(); ii++) {
			Battery battery = new Battery();
			battery.setBatteryVolts(336);
			batteryList.add(battery);
		}

		lab.setLocalbatteryList(batteryList);
		lab.setNumberOfBatteries(le.getNumberOfBatteriesInZip());
		lee.setLocalAreabattery(lab);

		sensor = new Sensor();
		ConsumerBattery b = new ConsumerBattery();
		b.setDevices(devices);
		b.setBatteryVolts(336);
		sensor.setBattery(b);
		cs = new CommunitySensor();
		cs.setLocalEnergy(lee);
		consumerId=consumId;
		return null;
	}
	
	@RequestMapping("/CheckEffect.htm")
	@ResponseBody
	public void CheckEffect(@RequestBody String info,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(info);
		String[] parts = info.split("&");
		String temp = parts[0];
		String wind = parts[1];
		NumTemp=0;
		NumWind=0;
		try{
		NumTemp=Integer.parseInt(temp);
		NumWind=Integer.parseInt(wind);
		}catch(Exception e)
		{
			//Error in jsons
		}
		
		
			
		
	}

	@RequestMapping("/ConnectToElect.htm")
	@ResponseBody
	public void ConnectToElectricity(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloConnect");
		String con = request.getParameter("Consumer");
		System.out.println("My Consumer Id"+consumerId);
		// This get from web services
		le.getLocalEnergy().setTempereture(NumTemp);
		le.getLocalEnergy().setWindVelocity(NumWind);

		cs.setLocalEnergy(le.getLocalEnergy());
		String Message = sensor.smartSwitch(cs);

		// Create a locallist and save it in locallist
		Localconsumptionlist locallist = new Localconsumptionlist();

		LocalconsumptionlistId lcid = new LocalconsumptionlistId();
		lcid.setConsumerId(consumerId);
		lcid.setLocalServicesId(localSubscriptionId);
		lcid.setLocalEnergyVendorId(le.getLocalenergyvendor().getLocalEnergyVendorId());
		locallist.setId(lcid);

		Date lConsumptionDate = new Date();
		Integer voltage = 0;

		for (Map.Entry<Date, Integer> entry : sensor.getLocalConsumptionList().entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			lConsumptionDate = entry.getKey();
			voltage = entry.getValue();

		}

		locallist.setLocalVoltageConsumed(Float.parseFloat(voltage.toString()));
		float localChargedAmount = Float.parseFloat(voltage.toString()) * le.getRate();
		System.out.println("Charged Amount" + localChargedAmount);
		locallist.setChargedAmount(localChargedAmount);

		locallist.setDateTimeVolatgeConsumed(lConsumptionDate);
		locallist.setLocalenergyservices(le);

		// If Charged Amount is 0 then no charge hence no billing
		if (localChargedAmount != 0.0) {
			LocalConsumptionListDAO lcodDAO = new LocalConsumptionListDAO();
			lcodDAO.createLocalConsumptionList(locallist);
		}
		System.out.println("---Locallist Saved----");

		// Iteratte the Global List
		// Create Global consumption List
		Globalconsumptionlist globalList = new Globalconsumptionlist();

		GlobalconsumptionlistId gcid = new GlobalconsumptionlistId();
		gcid.setConsumerId(consumerId);
		gcid.setGlobalServiceId(ge.getId().getGlobalServiceId());
		gcid.setGlobalVendorId(ge.getId().getGlobalVendorId());
		globalList.setId(gcid);

		Date gConsumptionDate = new Date();
		Integer power = 0;
		for (Map.Entry<Date, Integer> entry : sensor.getGlobalConsumptionList().entrySet()) {
			System.out.println("Global Key : " + entry.getKey() + "Global Value : " + entry.getValue());
			gConsumptionDate = entry.getKey();
			power = entry.getValue();
		}
		globalList.setPowerConsumed(Float.parseFloat(power.toString()));
		float globalChargedAmount = Float.parseFloat(power.toString()) * ge.getRatePerPower();
		System.out.println("Global Charged Amount" + globalChargedAmount);
		globalList.setChargedAmount(globalChargedAmount);

		globalList.setDateTimePowerConsumed(gConsumptionDate);
		globalList.setGlobalservices(ge);

		// If Charged Amount is 0 then no charge hence no billing
		if (globalChargedAmount != 0.0) {
			GlobalConsumptionListDAO gcodDAO = new GlobalConsumptionListDAO();
			gcodDAO.createGlobalConsumptionList(globalList);
		}

		System.out.println(Message);
		JSONObject json = new JSONObject();
		json.put("Message", Message);
		json.keys();
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

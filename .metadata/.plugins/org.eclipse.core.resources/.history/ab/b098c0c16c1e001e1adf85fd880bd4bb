package com.teamproject.theglory.khj.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamproject.theglory.khj.domain.Reservation;
import com.teamproject.theglory.khj.service.ReservationService;

@Controller
// @RequestMapping()
public class ReservationController {	
	
	private ReservationService service;
	
	@Autowired
	public ReservationController(ReservationService service) {
		this.service = service;
	}
	
	//main페이지	
		@RequestMapping("/main")
		public String main() {	
			return "main";
		}
		
	//캘린더
	@RequestMapping("/monthCal")
	   public String monthCal(@RequestParam(required = false) String startDate, Model model) {
	       return "monthCal";
	   }
	
	@RequestMapping(value={"/resvBldHousStep5", "/list"}, method=RequestMethod.GET)
	public String resvBldHousStep5(Model model) {		
		List<Reservation> bList = service.resvBldHousStep5();
			
		model.addAttribute("bList",bList);
		
		return "khj/resvBldHousStep5";
	}
	
	@RequestMapping(value={"/resvBldHousStep4", "/list"}, method=RequestMethod.GET)
	public String resvBldHousStep4(Model model) {		
		List<Reservation> bList = service.resvBldHousStep4();
			
		model.addAttribute("bList",bList);
		
		return "khj/resvBldHousStep4";
	}
	
	
	
	@RequestMapping(value={"/resvBldHousStep3", "/list"}, method=RequestMethod.GET)
	public String resvBldHousStep3(Model model) {		
		List<Reservation> bList = service.resvBldHousStep3();
			
		model.addAttribute("reservation",bList);
		
		return "khj/resvBldHousStep3";
	}
	
	@RequestMapping(value={"/resvBldHousStep2", "/list"}, method=RequestMethod.GET)
	public String resvBldHousStep2(Model model) {		
		List<Reservation> bList = service.resvBldHousStep2();
			
		model.addAttribute("bList",bList);
		
		return "khj/resvBldHousStep2";
	}
	
	
	@RequestMapping(value={"/resvBldHousStep1", "/list"}, method=RequestMethod.GET)
	public String resvBldHousStep1(Model model) {
		
		List<Reservation> bList = service.resvBldHousStep1();
			
		model.addAttribute("bList", bList);
		

		return "khj/resvBldHousStep1";		
	}
	
	@RequestMapping(value="insertAction", method=RequestMethod.GET)
	public String insertReservation(Reservation r) {
	
	service.insertReservation(r);
	
	return "khj/resvBldHousStep2";
			
	}
		
	//@RequestMapping("/resvBldHousStep3")
}

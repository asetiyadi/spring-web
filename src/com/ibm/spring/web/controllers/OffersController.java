package com.ibm.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.spring.web.dao.Offer;
import com.ibm.spring.web.service.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		this.offersService.throwTestException();
		
		List<Offer> offers = this.offersService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("id is " + id);
		return "home";
	}
	
	// Handle any database exception
	/*@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		return "error";
	}*/
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		// The "offer" must match the commandName value in createoffer.jsp sf:form
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	// BindingResult to validate if the the offer object is valid or not
	// To tell Spring what to validate, we add @Valid annotation on the argument we want Spring to validate
	// To use @Valid, we need to import appropriate jar using Maven
	//  - validation-api
	//  - hibernate
	//  - hibernate-validator
	//
	// In Offer.java, we need to specify validation we want to perform for each of the Offer property
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		if(result.hasErrors()) {
			/*System.out.println("Form does not validate");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}*/
			
			return "createoffer";
		}
		
		this.offersService.create(offer);

		return "offercreated";
	}
	
	/*@RequestMapping("/")
	public ModelAndView showHome() {

		//  ModelAndView exists in REQUEST Scope //
		// pass the logical name of the view to constructor
		ModelAndView mv = new ModelAndView("home");
		
		// return map
		Map<String, Object> model = mv.getModel();
		model.put("name", "Lenon");

		return mv;
	}*/

	/*
	 * public String showHome(HttpSession session) {
	 * 
	 * session.setAttribute("name", "Otong");
	 * 
	 * return "home"; }
	 */
}

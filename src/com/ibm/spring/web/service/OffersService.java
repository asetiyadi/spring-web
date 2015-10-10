package com.ibm.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.spring.web.dao.Offer;
import com.ibm.spring.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDAO;
	
	public List<Offer> getCurrent() {
		return offersDAO.getOffers();
	}
	
	@Autowired
	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDAO = offersDAO;
	}

	public void create(Offer offer) {
		// TODO Auto-generated method stub
		offersDAO.create(offer);
	}

	public void throwTestException() {
		offersDAO.getOffer(999);
	}
}

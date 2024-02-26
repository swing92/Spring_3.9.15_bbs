package com.teamproject.theglory.khj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.theglory.khj.dao.ReservationDao;
import com.teamproject.theglory.khj.domain.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDao reservationDao;

	@Override
	public List<Reservation> resvBldHousStep1() {		
		return reservationDao.resvBldHousStep1();
	}

	@Override
	public List<Reservation> resvBldHousStep2() {		
		return reservationDao.resvBldHousStep2();
	}
	
	@Override
	public List<Reservation> resvBldHousStep3() {
		return reservationDao.resvBldHousStep3();
	}
	
	@Override
	public List<Reservation> resvBldHousStep4() {
		return reservationDao.resvBldHousStep4();
	}
	
	@Override
	public
	List<Reservation> resvBldHousStep5() {
		return reservationDao.resvBldHousStep5();
	}

	@Override
	public void insertReservation(Reservation r) {
		reservationDao.insertReservation(r);
		
	}
	

}

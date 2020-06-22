package com.example.LanzadorDcp;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ManagerDcp {

	public ModelAndView CotizarMetal() {
		ModelAndView mav = new ModelAndView("/TipoMetal");
		return mav;
	}
	
	
	
}

package com.example.LanzadorDcp;





import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;



@Controller
@RestController
public class ControllerDcp {
	@Autowired 
	ManagerDcp mgr;
	
	
	
	@GetMapping("CotizarMetales")
	public ModelAndView test() {
		return mgr.CotizarMetal();
	}

	
	  @RequestMapping(value = "/BuscarPrecioMetal", method = RequestMethod.POST)
	  @ResponseBody
	  public String operationGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  
		String Material =  request.getParameter("material");
			RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        String url = "https://www.indecon.online/date/"  + Material + "/02-01-2020";
	        ResponseEntity<MetalesDTO> responseMS = 
	        		restTemplate.exchange(url, HttpMethod.GET,entity,MetalesDTO.class);
	        
			return "key : " + responseMS.getBody().getKey() + " :---: " + 
			"name : " + responseMS.getBody().getName() + " :---: " +
			"unit :  " + responseMS.getBody().getUnit() + " :---: " +
			"date :  " + responseMS.getBody().getDate() + " :---: " +
			"value :  " + responseMS.getBody().getValue() + " :---: " ;
		
		  
		  
	    }  
	

	
}

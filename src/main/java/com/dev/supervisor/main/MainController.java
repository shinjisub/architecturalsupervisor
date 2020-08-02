package com.dev.supervisor.main;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.supervisor.main.model.BusinessSupervisor;
import com.dev.supervisor.main.service.BusinessSuperVisorService;

@Controller
public class MainController {
	
	@Autowired
	private BusinessSuperVisorService businessSuperVisorService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * Get Supervisory Placement Plan List
	 * @return
	 */
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView Main() {
		ModelAndView mv = new ModelAndView("main");
		List<BusinessSupervisor> m  = businessSuperVisorService.getBusinessSupervisorList(new HashMap<String, Object>());
		mv.addObject("BusinessSupervisorList", m);
		return mv;
	}
	
}

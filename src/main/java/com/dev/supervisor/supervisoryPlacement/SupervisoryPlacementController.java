package com.dev.supervisor.supervisoryPlacement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dev.supervisor.common.JsonUtil;
import com.dev.supervisor.common.StringUtil;
import com.dev.supervisor.supervisoryPlacement.model.SupervisoryPlacement;
import com.dev.supervisor.supervisoryPlacement.service.SupervisoryPlacementService;

@Controller
public class SupervisoryPlacementController {
	
	@Autowired
	private SupervisoryPlacementService service;

	@Resource(name = "JsonUtil")
	private JsonUtil jsonUtil;

	@Resource(name = "StringUtil")
	private StringUtil stringUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(SupervisoryPlacementController.class);
	
	/**
	 * SupervisoryPlacement View
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/supervisoryPlacement", method = RequestMethod.GET)
	public ModelAndView getSupervisoryPlacement() {
		return new ModelAndView("/supervisoryPlacement/supervisoryPlacementList");
	}


	/**
	 * SupervisoryPlacement List [Json]
	 * @param input
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getsupervisoryPlacementList", method = RequestMethod.GET)
	public List<SupervisoryPlacement> test(Map<String, Object> input, Model model) {
		
		//service.getSupervisoryPlacementList(input);
		model.addAttribute("supervisoryPlacementList", service.getSupervisoryPlacementList(input).get(0).getBps_name());
		return service.getSupervisoryPlacementList(input);
	}
	
}

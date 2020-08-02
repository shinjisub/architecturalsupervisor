package com.dev.supervisor.main.service;

import java.util.List;
import java.util.Map;

import com.dev.supervisor.main.model.BusinessSupervisor;

public interface BusinessSuperVisorService {
	public List<BusinessSupervisor> getBusinessSupervisorList(Map<String, Object> input);
}

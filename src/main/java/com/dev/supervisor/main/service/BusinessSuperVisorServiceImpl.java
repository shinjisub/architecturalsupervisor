package com.dev.supervisor.main.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dev.supervisor.main.model.BusinessSupervisor;

@Service
public class BusinessSuperVisorServiceImpl implements BusinessSuperVisorService {

	@Autowired
	private SqlSession sql;
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(BusinessSuperVisorServiceImpl.class);

	public List<BusinessSupervisor> getBusinessSupervisorList(Map<String, Object> input) {
		return sql.selectList("BusinessSupervisor.getBusinessSupervisorList", input); 
	}

}

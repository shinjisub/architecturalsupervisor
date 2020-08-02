package com.dev.supervisor.supervisoryPlacement.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.supervisor.supervisoryPlacement.model.SupervisoryPlacement;

@Service
public class SupervisoryPlacementServiceImpl implements SupervisoryPlacementService {

	@Autowired
	private SqlSession sql;
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(SupervisoryPlacementServiceImpl.class);

	@Override
	public List<SupervisoryPlacement> getSupervisoryPlacementList(Map<String, Object> input) {
		return sql.selectList("SupervisorPlacement.getSupervisorPlacementList", input);	
	}

}

package com.dev.supervisor.supervisoryPlacement.service;

import java.util.List;
import java.util.Map;

import com.dev.supervisor.supervisoryPlacement.model.SupervisoryPlacement;

public interface SupervisoryPlacementService {
	public List<SupervisoryPlacement> getSupervisoryPlacementList(Map<String, Object> input);
}

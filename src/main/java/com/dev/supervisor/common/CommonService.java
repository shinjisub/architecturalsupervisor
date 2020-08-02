package com.dev.supervisor.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommonService {
	
	public List<?> getCommonList(HashMap<String, Object> input);
	
	public Map<String, Object> getCommonRow(HashMap<String, Object> input);
}

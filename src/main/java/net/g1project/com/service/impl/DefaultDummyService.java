package net.g1project.com.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import net.g1project.com.service.DummyService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DefaultDummyService implements DummyService {

	public static final String DUMMY_PATH = "static/dummy/memberDummy.json";
	public static final String DUMMY_DATA_NAME = "data";

	@Autowired
	private JsonParser jsonParser;

	@Autowired
	private ObjectMapper objectMapper;

	private ResourceLoader resourceLoader;

	@SuppressWarnings("unchecked")
	public boolean isExistIDFromDummy(String compareValue, String key) {
		Map<String, Object> responseJson = jsonParser.parseMap(getDummyData());
		ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) responseJson
				.get(DUMMY_DATA_NAME);

		boolean validateResult = true;
		for (Map<String, Object> map : list) {
			String requestIDs = (String) map.get(key);
			if (StringUtils.isNotEmpty(compareValue)
					&& compareValue.equals(requestIDs)) {
				validateResult = false;
			}
		}
		return validateResult;
	}

	@SuppressWarnings("unchecked")
	public boolean setDummyData(String jsonValue) {
		boolean result = true;

		// get Dummy Data
		Map<String, Object> responseJson = jsonParser.parseMap(getDummyData());
		ArrayList<Map<String, Object>> oldList = (ArrayList<Map<String, Object>>) responseJson
				.get(DUMMY_DATA_NAME);

		// add inputValue to clone
		ArrayList<Map<String, Object>> newList = (ArrayList<Map<String, Object>>) oldList
				.clone();
		newList.add(jsonParser.parseMap(jsonValue));

		// replace to Data added inputValue
		result = responseJson.replace(DUMMY_DATA_NAME, oldList, newList);
		if (result) {
			Resource dummy = resourceLoader.getResource(DUMMY_PATH);
			try {
				objectMapper.writeValue(dummy.getFile(), responseJson);
			} catch (Exception e) {
				result = false;
				e.printStackTrace();
			}
		}
		return result;
	}

	public String getDummyData() {
		Resource dummy = resourceLoader.getResource(DUMMY_PATH);
		String memberDummy = null;
		try {
			memberDummy = FileUtils.readFileToString(dummy.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memberDummy;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

}

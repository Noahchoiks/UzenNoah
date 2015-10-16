package net.g1project.com.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.g1project.com.utils.ValidationUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/valid")
public class ValidationDataFactory {

	public static final String ENTITY_VALID_DATA_KEY_REGEX = "regex";
	public static final String ENTITY_VALID_DATA_KEY_MESSAGE = "message";
	
	@Autowired
	private ReloadableResourceBundleMessageSource properties;
	
	@Autowired
	private JsonParser jsonParser;
	
	@Autowired
	private ValidationUtils validationUtils;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	@SuppressWarnings("unchecked")
	public Map<String, Object> getValidInfomation(@RequestBody String requestBody) {
		
		Map<String, Object> requestJson = jsonParser.parseMap(requestBody);
		String controllerName = (String) requestJson.get("controllerName");
		ArrayList<String> validList = (ArrayList<String>) requestJson.get("validList");
		return getValidDataToMap(controllerName,validList);
	}
	
	
	private Map<String, Object> getValidDataToMap(String controllerName,ArrayList<String> validList){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		Map<String,Object> entityValidData;
		for (String entity : validList) {
			entityValidData = new HashMap<String, Object>();
			String key = controllerName.concat(".").concat(entity);	
			System.out.println(key);
			entityValidData.put(ENTITY_VALID_DATA_KEY_REGEX, validationUtils.getValidationRegex(key, null));
			entityValidData.put(ENTITY_VALID_DATA_KEY_MESSAGE, validationUtils.getValidationMessage(key, null));
			resultMap.put(entity, entityValidData);
		}
		
		return resultMap;
	}
}

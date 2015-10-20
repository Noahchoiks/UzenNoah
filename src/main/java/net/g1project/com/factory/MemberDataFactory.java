package net.g1project.com.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.g1project.com.service.DummyService;
import net.g1project.com.validator.MemberG1Validator;
import net.g1project.com.vo.MemberVO;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/factory")
public class MemberDataFactory {

	@Autowired
	private DummyService dummyService;

	@Autowired
	private JsonParser jsonParser;

	@Autowired
	private MemberG1Validator validator;

	@ResponseBody
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	public Map<String, Object> memberInfo() {
		return jsonParser.parseMap(dummyService.getDummyData());
	}

	@ResponseBody
	@RequestMapping(value = "/isExistID", method = RequestMethod.POST)
	public Map<String, Object> memberValid(@RequestBody String requestBody) {
		Map<String, Object> requestJson = jsonParser.parseMap(requestBody);
		String requestMemberID = (String) requestJson.get("id");

		Map<String, Object> responseJson = new HashMap<String, Object>();
		responseJson.put("result",
				dummyService.isExistIDFromDummy(requestMemberID, "id"));

		return responseJson;
	}

	@ResponseBody
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public Map<String, Object> join(@RequestBody MemberVO memberTemp,
			BindingResult resultBinder) {

		Map<String, Object> responseJson = new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();

		validator.validate(memberTemp, resultBinder);
		boolean result = resultBinder.hasErrors();
		if (result) {
			responseJson.put("result", !result);
			responseJson.put("resultMessage", "Server validationError");
			return responseJson;
		} 
		
		try {
			result = dummyService.setDummyData(objectMapper
					.writeValueAsString(memberTemp));
		} catch (IOException e) {
			e.printStackTrace();
		}
		responseJson.put("result", result);
		if (result) {
			responseJson.put("resultMessage", "SUCCESS");
		}else{
			responseJson.put("resultMessage", "Server save Error");
		}
		return responseJson;
	}

}

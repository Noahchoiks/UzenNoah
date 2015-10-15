package net.g1project.com.factory;

import java.util.HashMap;
import java.util.Map;

import net.g1project.com.service.DummyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/factory")
public class DataFactory {

	@Autowired
	private DummyService dummyService;

	@Autowired
	private JsonParser jsonParser;

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
	public Map<String, Object> join(@RequestBody String memberDetail) {
		boolean result = dummyService.setDummyData(memberDetail);

		Map<String, Object> responseJson = new HashMap<String, Object>();
		responseJson.put("result", result);

		return responseJson;
	}

}

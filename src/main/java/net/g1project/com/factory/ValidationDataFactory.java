package net.g1project.com.factory;

import java.util.Map;

import net.g1project.com.constants.G1ValidationConstants;
import net.g1project.com.factory.abstractFactory.AbstractDataFactory;
import net.g1project.com.utils.ValidationUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/valid")
public class ValidationDataFactory extends AbstractDataFactory{

	@Autowired
	private ReloadableResourceBundleMessageSource properties;

	@Autowired
	private JsonParser jsonParser;

	@Autowired
	private ValidationUtils validationUtils;

	@ResponseBody
	@RequestMapping(value = "/{voName}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getValidInfomation(
			@PathVariable String voName) {
		
		String voNameWithPackage = G1ValidationConstants.V_VO_PACKAGE
		+ G1ValidationConstants.V_DEPTH_SEPARATOR + voName;
		Class<?> clazz = null;
		try {
			clazz = Class.forName(voNameWithPackage);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return validationUtils.getValidDataToResponseEntity(clazz);
	}

	
}

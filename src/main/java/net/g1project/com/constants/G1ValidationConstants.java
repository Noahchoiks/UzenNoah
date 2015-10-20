package net.g1project.com.constants;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class G1ValidationConstants {

	public static final String V_VO_PACKAGE = "net.g1project.com.vo";

	public static final String V_DEPTH_SEPARATOR = ".";

	public static final String V_MESSAGE_FIELD_SUFFIX = "message";

	public static final String V_STATUS_MESSAGE_SUFFIX = V_DEPTH_SEPARATOR
			+ V_MESSAGE_FIELD_SUFFIX;

	public enum Status {

		PATTERN("pattern"), MAX_LENGTH("maxLength"), MIN_LENGTH("minLength"), REQUIRED(
				"required");

		private String suffix;

		Status(String suffix) {
			this.suffix = suffix;
		}

		public String getSuffix() {
			return suffix;
		}		
	}

	@SuppressWarnings("serial")
	public static Map<Class<?>, PropertyEditor> DEFAULT_EDITORS = new HashMap<Class<?>, PropertyEditor>() {
		{
			put(String.class, new StringTrimmerEditor(true));
			put(boolean.class, new CustomBooleanEditor(false));
			put(Boolean.class, new CustomBooleanEditor(true));
			put(int.class, new CustomNumberEditor(Integer.class, false));
			put(Integer.class, new CustomNumberEditor(Integer.class, true));
			put(long.class, new CustomNumberEditor(Long.class, false));
			put(Long.class, new CustomNumberEditor(Long.class, true));
			put(double.class, new CustomNumberEditor(Double.class, false));
			put(Double.class, new CustomNumberEditor(Double.class, true));
		}
	};
	


}

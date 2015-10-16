package net.g1project.com.constants;

public class G1ValidationConstants {

	public static final String V_VO_PACKAGE = "net.g1project.com.vo";

	public static final String V_DEPTH_SEPARATOR = ".";

	public enum Status {

		MESSAGE("message"), PATTERN("pattern"), MAX_LENGTH("maxLength"), MIN_LENGTH(
				"minLength"), REQUIRED("required");

		private String suffix;

		Status(String suffix) {
			this.suffix = suffix;
		}

		public String getSuffix() {
			return suffix;
		}
	}

}

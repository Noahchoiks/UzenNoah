package net.g1project.com.vo;

public class ValidateInfoVO {

	private String pattern;
	private String patternMessage;
	private int maxLength;
	private String maxLengthMessage;
	private int minLength;
	private String minLengthMessage;
	private boolean required;
	private String requiredMessage;
	
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPatternMessage() {
		return patternMessage;
	}
	public void setPatternMessage(String patternMessage) {
		this.patternMessage = patternMessage;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public String getMaxLengthMessage() {
		return maxLengthMessage;
	}
	public void setMaxLengthMessage(String maxLengthMessage) {
		this.maxLengthMessage = maxLengthMessage;
	}
	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public String getMinLengthMessage() {
		return minLengthMessage;
	}
	public void setMinLengthMessage(String minLengthMessage) {
		this.minLengthMessage = minLengthMessage;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getRequiredMessage() {
		return requiredMessage;
	}
	public void setRequiredMessage(String requiredMessage) {
		this.requiredMessage = requiredMessage;
	}
	@Override
	public String toString() {
		return "ValidateInfoVO [pattern=" + pattern + ", patternMessage="
				+ patternMessage + ", maxLength=" + maxLength
				+ ", maxLengthMessage=" + maxLengthMessage + ", minLength="
				+ minLength + ", minLengthMessage=" + minLengthMessage
				+ ", required=" + required + ", requiredMessage="
				+ requiredMessage + "]";
	}
}

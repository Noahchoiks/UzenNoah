package net.g1project.com.service;

import org.springframework.context.ResourceLoaderAware;

public interface DummyService extends ResourceLoaderAware{

	public boolean isExistIDFromDummy(String compareValue, String key);
	public String getDummyData();
	public boolean setDummyData(String jsonValue);
}

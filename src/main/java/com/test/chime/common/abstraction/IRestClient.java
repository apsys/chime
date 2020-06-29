package com.test.chime.common.abstraction;

import com.test.chime.common.utility.WResponse;

public interface IRestClient {
	
	public WResponse get(String path);

}